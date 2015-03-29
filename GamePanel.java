import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import kuusisto.tinysound.Music;
import kuusisto.tinysound.Sound;
import kuusisto.tinysound.TinySound;

public class GamePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JPanel panel_1;
	private MenuButton btnNewButton;
	private MenuButton btnNewButton_1;
	private MenuButton btnNewButton_4;
	ImageIcon logo = new ImageIcon(getClass().getResource("logo.jpg"));
	/**
	 * Create the panel.
	 */
	public GamePanel() {

		createContents();
	}
	private void createContents() {
		TinySound.init();
		final Sound click = TinySound.loadSound("choose.wav");
		final Music theme = TinySound.loadMusic("main_theme.wav");
		theme.play(true);
		setBackground(Color.BLACK);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		{
			panel_1 = new JPanel(){
				
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public void paintComponent(Graphics g){
					super.paintComponent(g);
					logo.paintIcon(this, g, (super.getWidth() / 2) - logo.getIconWidth() / 2, 10);
					
				}
			};
			panel_1.setBackground(Color.BLACK);
			GridBagConstraints gbc_panel_1 = new GridBagConstraints();
			gbc_panel_1.fill = GridBagConstraints.BOTH;
			gbc_panel_1.gridx = 0;
			gbc_panel_1.gridy = 0;
			add(panel_1, gbc_panel_1);
			panel_1.setLayout(new BorderLayout(0, 0));
		}
		{
			panel = new JPanel();
			panel.setBackground(Color.BLACK);
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.gridheight = 4;
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 1;
			add(panel, gbc_panel);
			panel.setLayout(new GridLayout(5, 0, 0, 0));
			{
				btnNewButton = new MenuButton("SINGLE PLAYER");
				btnNewButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {	
						btnNewButton.setForeground(Color.WHITE);
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						btnNewButton.setForeground(Color.YELLOW);
					}
				});
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						click.play();
						MainFrame.menus.show(MainFrame.contentPane, "single");
					}
				});
				panel.add(btnNewButton);
			}
			{
				btnNewButton_4 = new MenuButton("MULTIPLE PLAYERS");
				btnNewButton_4.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						btnNewButton_4.setForeground(Color.WHITE);
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						btnNewButton_4.setForeground(Color.YELLOW);
					}
				});
				btnNewButton_4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						click.play();
						MainFrame.menus.show(MainFrame.contentPane, "multi");
					}
				});
				panel.add(btnNewButton_4);
			}
			{
				btnNewButton_1 = new MenuButton("BACK");
				btnNewButton_1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						btnNewButton_1.setForeground(Color.WHITE);
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						btnNewButton_1.setForeground(Color.YELLOW);
					}
				});
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						click.play();
						MainFrame.menus.show(MainFrame.contentPane, "menu");
					}
				});
				panel.add(btnNewButton_1);
			}
		}
	}

}
