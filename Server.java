import java.awt.Graphics;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Server extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ImageIcon logo = new ImageIcon("/Users/aktlek/Desktop/Programming/Eclipse_workspace/Pacman 0.3a/source/logo.jpg");

	/**
	 * Create the panel.
	 */
	
	private ObjectOutputStream output; // output stream to client
	private ObjectInputStream input; // input stream from client
	private ServerSocket server; // server socket
	private Socket connection; // connection to client
	public Server() {
		
	}
	
	public void runServer()
	   {
	      try // set up server to receive connections; process connections
	      {
	         server = new ServerSocket( 12345, 100 ); // create ServerSocket

	         while ( true ) 
	         {
	            try 
	            {
	               waitForConnection(); // wait for a connection
	               getStreams(); // get input & output streams
	               processConnection(); // process connection
	            } // end try
	            catch ( EOFException eofException ) 
	            {
	            	
	            } // end catch
	            finally 
	            {
	               closeConnection(); //  close connection
	            } // end finally
	         } // end while
	      } // end try
	      catch ( IOException ioException ) 
	      {
	         ioException.printStackTrace();
	      } // end catch
	   } // end method runServer
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		logo.paintIcon(this, g, this.getWidth() / 2 - logo.getIconWidth() / 2, 100);
	}
	
	private void waitForConnection() throws IOException
	   {
	      connection = server.accept(); // allow server to accept connection            
	   } // end method waitForConnection
	
	private void getStreams() throws IOException
	   {
	      // set up output stream for objects
	      output = new ObjectOutputStream( connection.getOutputStream() );
	      output.flush(); // flush output buffer to send header information

	      // set up input stream for objects
	      input = new ObjectInputStream( connection.getInputStream() );

	   } // end method getStreams
	
	private void processConnection() throws IOException
	   {
		
	   } // end method processConnection
	
	private void closeConnection() 
	   {
	      try 
	      {
	         output.close(); // close output stream
	         input.close(); // close input stream
	         connection.close(); // close socket
	      } // end try
	      catch ( IOException ioException ) 
	      {
	         ioException.printStackTrace();
	      } // end catch
	   } // end method closeConnection
}
