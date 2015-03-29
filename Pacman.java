import javax.swing.ImageIcon;



public class Pacman {
	public int x;
	public int y;
	public String dir = "left";
	public Boolean move = false;
	final public ImageIcon pacpic0 = new ImageIcon(getClass().getResource("/0.png"));
	public Pacman(int xPos, int yPos){
		x = xPos;
		y = yPos;
	}
	
	public void move(){
		if (dir.equals("left")){
			x--;
		} 
		else if (dir.equals("right")){
			x++;
		}
		else if (dir.equals("up")){
			y--;
		} else if (dir.equals("down")){
			y++;
		}
	}
	
	public void setDirection(String direction) {
		dir = direction;
	}
	
}
