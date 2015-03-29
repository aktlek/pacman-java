
public class PacmanRunnable extends Pacman implements Runnable{

	public PacmanRunnable(int xPos, int yPos) {
		super(xPos, yPos);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		try {
			while (true){
				if (super.move){
					super.move();
					Thread.sleep(10);
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
