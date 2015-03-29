
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import kuusisto.tinysound.Sound;
import kuusisto.tinysound.TinySound;


public class HelpPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ImageIcon logo = new ImageIcon(getClass().getResource("logo.jpg"));
    ImageIcon help = new ImageIcon(getClass().getResource("help.png"));
	private JPanel panel;
	
	private JPanel panel_1;
	private MenuButton btnBack;
	final Sound click = TinySound.loadSound("choose.wav");
	/**
	 * Create the panel.
	 */
	public HelpPanel() {
		
		
		createContents();
	}
	private void createContents() {
		super.setBackground(Color.BLACK);
		setLayout(new BorderLayout(0, 0));
		{
			panel = new JPanel();
			panel.setBackground(Color.BLACK);
			add(panel, BorderLayout.SOUTH);
			panel.setLayout(new GridLayout(3, 0, 0, 0));

		}
		{
			panel_1 = new JPanel(){
				private static final long serialVersionUID = 1L;

				public void paintComponent(Graphics g){
					super.paintComponent(g);
					logo.paintIcon(this, g, (450) - logo.getIconWidth() / 2, 10);
                                        help.paintIcon(this, g, (450) - help.getIconWidth() / 2, 10);
					repaint();
				}
			};
			panel_1.setBackground(Color.BLACK);
			add(panel_1, BorderLayout.CENTER);
			panel_1.setLayout(null);
			{
				btnBack = new MenuButton("BACK");
				btnBack.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {	
						btnBack.setForeground(Color.WHITE);
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						btnBack.setForeground(Color.YELLOW);
					}
				});
				btnBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						click.play();
						MainFrame.menus.show(MainFrame.contentPane, "menu");
					}
				});
				btnBack.setBounds(385, 470, 120, 30);
				panel_1.add(btnBack);
			}
		}
	}
}

/*
 * 
 The player controls Pac-Man through a maze, eating pac-dots. When all pac-dots are eaten,
 Pac-Man is taken to the next stage. Enemies trying to catch Pac-Man. If an enemy touches 
 Pac-Man, a life is lost. When all lives have been lost, the game ends. Near the corners 
 of the maze are four larger, flashing dots known as power pellets that provide Pac-Man 
 with the temporary ability to eat the enemies.
 * 
 */