import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class MainFrame extends JFrame{

	/**
	 * 
	 */
	public static final long serialVersionUID = 1L;
	public static JPanel contentPane;
	public static CardLayout menus = new CardLayout();
	public static MenuPanel menu = new MenuPanel();
	public static GamePanel game = new GamePanel();
	public static HelpPanel help = new HelpPanel();
	public static AboutPanel about = new AboutPanel();
	public static HighScorePanel high = new HighScorePanel();
	public static SinglePlayerPanel single = new SinglePlayerPanel();
	public static MultiPlayerPanel multi = new MultiPlayerPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		createContents();
	}
	private void createContents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 660);
		super.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(menus);
		contentPane.add(menu, "menu");
		contentPane.add(game, "game");
		contentPane.add(high, "high");
		contentPane.add(about, "about");
		contentPane.add(help, "help");
		contentPane.add(single, "single");
		contentPane.add(multi, "multi");
		this.setFocusable(true);
		this.addKeyListener(single);
		this.requestFocus();
	}


}
