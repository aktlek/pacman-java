import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;


public class MenuButton extends JButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MenuButton(String label){
		super(label);
		super.setBorder(new EmptyBorder(0, 0, 0, 0));
		super.setBackground(Color.BLACK);
		super.setForeground(Color.YELLOW);
		super.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 30));
	}

}
