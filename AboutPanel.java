import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import kuusisto.tinysound.Sound;
import kuusisto.tinysound.TinySound;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class AboutPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ImageIcon logo = new ImageIcon(getClass().getResource("logo.jpg"));
	ImageIcon abai = new ImageIcon(getClass().getResource("abai1.png"));
	ImageIcon andrey = new ImageIcon(getClass().getResource("andrey1.png"));
	ImageIcon aktlek = new ImageIcon(getClass().getResource("aktlek1.png"));
	ImageIcon abay = new ImageIcon(getClass().getResource("abay1.png"));
	private JPanel panel;
	private JLabel lblCopyright;
	private JLabel lblAllRightsReserved;
	private JPanel panel_1;
	private JLabel lblVersion;
	private JLabel lblSduedukz;
	private JLabel lblInstructors;
	private JLabel lblAbaiNusipbekov;
	private JLabel lblAndreyBogdanchikov;
	private MenuButton btnBack;
	final Sound click = TinySound.loadSound("choose.wav");
	private JLabel lblDevelopers;
	private JLabel lblAktlekMukhtassyrov;
	private JLabel lblAbaySerikov;
	/**
	 * Create the panel.
	 */
	public AboutPanel() {
		
		
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
			{
				lblCopyright = new JLabel("Copyright \u00A9 2013 Suleyman Demirel University");
				lblCopyright.setBackground(Color.BLACK);
				lblCopyright.setForeground(Color.YELLOW);
				lblCopyright.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lblCopyright);
			}
			{
				lblAllRightsReserved = new JLabel("All Rights Reserved");
				lblAllRightsReserved.setBackground(Color.BLACK);
				lblAllRightsReserved.setForeground(Color.YELLOW);
				lblAllRightsReserved.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lblAllRightsReserved);
			}
			{
				lblSduedukz = new JLabel("sdu.edu.kz");
				lblSduedukz.setHorizontalAlignment(SwingConstants.CENTER);
				lblSduedukz.setForeground(Color.YELLOW);
				panel.add(lblSduedukz);
			}
		}
		{
			panel_1 = new JPanel(){
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public void paintComponent(Graphics g){
					super.paintComponent(g);
					logo.paintIcon(this, g, (450) - logo.getIconWidth() / 2, 10);
					abai.paintIcon(this, g, 300, 120);
					andrey.paintIcon(this, g, 470, 120);
					aktlek.paintIcon(this, g, 300, 300);
					abay.paintIcon(this, g, 470, 300);
					repaint();
				}
			};
			panel_1.setBackground(Color.BLACK);
			add(panel_1, BorderLayout.CENTER);
			panel_1.setLayout(null);
			{
				lblVersion = new JLabel("Version 1.0");
				lblVersion.setForeground(Color.YELLOW);
				lblVersion.setBounds(450 - 38, 510, 76, 16);
				panel_1.add(lblVersion);
			}
			{
				lblInstructors = new JLabel("INSTRUCTORS");
				lblInstructors.setFont(new Font("Lucida Grande", Font.BOLD, 15));
				lblInstructors.setForeground(Color.YELLOW);
				lblInstructors.setBounds(395, 100, 110, 16);
				panel_1.add(lblInstructors);
			}
			{
				lblAbaiNusipbekov = new JLabel("Abai Nusipbekov");
				lblAbaiNusipbekov.setForeground(Color.YELLOW);
				lblAbaiNusipbekov.setBounds(313, 258, 110, 16);
				panel_1.add(lblAbaiNusipbekov);
			}
			{
				lblAndreyBogdanchikov = new JLabel("Andrey Bogdanchikov");
				lblAndreyBogdanchikov.setForeground(Color.YELLOW);
				lblAndreyBogdanchikov.setBounds(468, 258, 139, 16);
				panel_1.add(lblAndreyBogdanchikov);
			}
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
			{
				lblDevelopers = new JLabel("DEVELOPERS");
				lblDevelopers.setFont(new Font("Lucida Grande", Font.BOLD, 15));
				lblDevelopers.setForeground(Color.YELLOW);
				lblDevelopers.setBounds(400, 280, 100, 16);
				panel_1.add(lblDevelopers);
			}
			{
				lblAktlekMukhtassyrov = new JLabel("Aktlek Mukhtassyrov");
				lblAktlekMukhtassyrov.setForeground(Color.YELLOW);
				lblAktlekMukhtassyrov.setBounds(298, 440, 140, 16);
				panel_1.add(lblAktlekMukhtassyrov);
			}
			{
				lblAbaySerikov = new JLabel("Abay Serikov");
				lblAbaySerikov.setForeground(Color.YELLOW);
				lblAbaySerikov.setBounds(496, 440, 90, 16);
				panel_1.add(lblAbaySerikov);
			}
		}
	}
}
