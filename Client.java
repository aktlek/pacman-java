
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;

public class Client extends JPanel 
{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ObjectOutputStream output; // output stream to server
	private ObjectInputStream input; // input stream from server
	private String chatServer; // host server for this application
	private Socket client; // socket to communicate with server

   // initialize chatServer and set up GUI
   public Client( String host )
   {

      chatServer = host; // set server to which this client connects


      
   	createContents();
   } // end Client constructor
   private void createContents() {
   	setBackground(Color.BLACK);
   	setLayout(new GridLayout(1, 0, 0, 0));
   }

   // connect to server and process messages from server
   public void runClient() 
   {
      try // connect to server, get streams, process connection
      {
         connectToServer(); // create a Socket to make connection
         getStreams(); // get the input and output streams
         processConnection(); // process connection
      } // end try
      catch ( EOFException eofException ) 
      {
    	  
      } // end catch
      catch ( IOException ioException ) 
      {
         ioException.printStackTrace();
      } // end catch
      finally 
      {
         closeConnection(); // close connection
      } // end finally
   } // end method runClient

   // connect to server
   private void connectToServer() throws IOException
   {      

      client = new Socket( InetAddress.getByName( chatServer ), 12345 );

   } // end method connectToServer

   // get streams to send and receive data
   private void getStreams() throws IOException
   {
      // set up output stream for objects
      output = new ObjectOutputStream( client.getOutputStream() );      
      output.flush(); // flush output buffer to send header information
      input = new ObjectInputStream( client.getInputStream() );
      
   }

   // process connection with server
   private void processConnection() throws IOException
   {

   } // end method processConnection

   // close streams and socket
   private void closeConnection() 
   {

      try 
      {
         output.close(); // close output stream
         input.close(); // close input stream
         client.close(); // close socket
      } // end try
      catch ( IOException ioException ) 
      {
         ioException.printStackTrace();
      } // end catch
   } 

} // end class Client
