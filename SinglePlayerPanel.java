
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SinglePlayerPanel extends JPanel implements KeyListener,Runnable{



    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum MapItem {
        EMPTY, WALL, PACMAN, CHEESE, PELLET, GHOST1, GHOST2, GHOST3, GHOST4, CHERRY
    };
    JLabel label;
    public MapItem[][] map;
    public int I = 11;
    public int J = 10;
    public int L = 1;
    public static int CELL_WIDTH = 30;
    public static int CELL_HEIGHT = 30;
    public Image empty;
    public int score = 0;
    public int live = 3;
    public int cheese = 198;public int cheese2=10000;public int cheese3=10000;public int cheese4=10000;public int cheese5=10000;public int cheese6=10000;
    public int level = 1;
    ImageIcon pacman = new ImageIcon(getClass().getResource("pacman.gif"));
    ImageIcon pacman0 = new ImageIcon(getClass().getResource("pacman.gif"));
    ImageIcon pacman1 = new ImageIcon(getClass().getResource("pacman.gif"));
    ImageIcon pacman2 = new ImageIcon(getClass().getResource("pacman2.gif"));
    ImageIcon pacman3 = new ImageIcon(getClass().getResource("pacman3.gif"));
    ImageIcon pacman4 = new ImageIcon(getClass().getResource("pacman4.gif"));
    ImageIcon ghots1 = new ImageIcon(getClass().getResource("monster1.png"));
    ImageIcon ghots2 = new ImageIcon(getClass().getResource("monster2.png"));
    ImageIcon ghots3 = new ImageIcon(getClass().getResource("monster3.png"));
    ImageIcon ghots4 = new ImageIcon(getClass().getResource("monster4.png"));
    ImageIcon cherry = new ImageIcon(getClass().getResource("cherry.png"));
    ImageIcon gamelogo = new ImageIcon(getClass().getResource("gamelogo.png"));
    ImageIcon font = new ImageIcon(getClass().getResource("font.png"));
    ImageIcon sdu = new ImageIcon(getClass().getResource("sdu.jpg"));
    ExecutorService ghosts = Executors.newCachedThreadPool();
    
    public SinglePlayerPanel() {
        loadMap("/Users/aktlek/Desktop/Development/Eclipse_workspace/Pacman 0.3a/source/map.txt");
        addKeyListener(this);
        setPreferredSize(new Dimension(map[0].length * CELL_WIDTH, map.length * CELL_HEIGHT));
        
        
    }
    public void loadMap(String mapFile) {
        try {
            Scanner in = new Scanner(new File(mapFile));
            int n = in.nextInt();
            int m = in.nextInt();
            map = new MapItem[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int x = in.nextInt();
                    switch (x) {
                        case 5:
                            I = i;
                            J = j;
                            map[i][j] = MapItem.EMPTY;
                            break;
                        case 0:
                            map[i][j] = MapItem.EMPTY;
                            break;
                        case 1:
                            map[i][j] = MapItem.WALL;
                            break;
                        case 3:
                            map[i][j] = MapItem.CHEESE;
                            break;
                        case 6:
                            map[i][j] = MapItem.PELLET;
                            break;
                        case 7:
                            map[i][j] = MapItem.GHOST1;
                            break;
                        case 8:
                            map[i][j] = MapItem.GHOST2;
                            break;
                        case 9:
                            map[i][j] = MapItem.GHOST3;
                            break;
                        case 2:
                            map[i][j] = MapItem.GHOST4;
                            break;              
                        case 10:
                            map[i][j] = MapItem.CHERRY;
                            break;
                        default: // if any unknown numbers are written
                            map[i][j] = MapItem.EMPTY;
                    }
                }
            }
            in.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Level not exists");
        }		
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.BLACK);
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                switch (map[i][j]) {
                    case EMPTY:
                        g.setColor(Color.BLACK);
                        g.fillRect(j * CELL_WIDTH, i * CELL_HEIGHT, CELL_WIDTH, CELL_HEIGHT);
                        break;
                    case WALL:
                        g.setColor(Color.CYAN);
                        g.fillRect(j * CELL_WIDTH+2, i * CELL_HEIGHT+2, CELL_WIDTH-6, CELL_HEIGHT-6);
                        g.drawRect(j * CELL_WIDTH, i * CELL_HEIGHT, CELL_WIDTH-2, CELL_HEIGHT-2);
                        g.setColor(Color.BLACK);
                        g.fillOval(j * CELL_WIDTH+3, i * CELL_HEIGHT+3, 3, 3);
                        g.fillOval(j * CELL_WIDTH+21, i * CELL_HEIGHT+3, 3, 3);
                        g.fillOval(j * CELL_WIDTH+3, i * CELL_HEIGHT+21, 3, 3);
                        g.fillOval(j * CELL_WIDTH+21, i * CELL_HEIGHT+21, 3, 3);
                        break;
                    case PACMAN:
                        g.setColor(Color.YELLOW);
                        break;
                    case CHEESE:
                        g.setColor(Color.YELLOW);
                        g.fillOval(j * CELL_WIDTH+11, i * CELL_HEIGHT+11, 8, 8);
                        break;
                    case PELLET:
                        g.setColor(Color.RED);
                        g.fillOval(j * CELL_WIDTH+9, i * CELL_HEIGHT+9, 12, 12);
                        break;
                    case GHOST1:
                        g.drawImage(ghots1.getImage(), j*CELL_WIDTH,i*CELL_HEIGHT, CELL_HEIGHT, CELL_HEIGHT, this);
                        break;
                    case GHOST2:
                        g.drawImage(ghots2.getImage(), j*CELL_WIDTH,i*CELL_HEIGHT, CELL_HEIGHT, CELL_HEIGHT, this);
                        break;
                    case GHOST3:
                        g.drawImage(ghots3.getImage(), j*CELL_WIDTH,i*CELL_HEIGHT, CELL_HEIGHT, CELL_HEIGHT, this);
                        break;
                    case GHOST4:
                        g.drawImage(ghots4.getImage(), j*CELL_WIDTH,i*CELL_HEIGHT, CELL_HEIGHT, CELL_HEIGHT, this);
                        break;
                    case CHERRY:
                        g.drawImage(cherry.getImage(), j*CELL_WIDTH,i*CELL_HEIGHT, CELL_HEIGHT, CELL_HEIGHT, this);
                        break;
                }
                
            }
        }
        g.setColor(Color.YELLOW);
        pacman.paintIcon(this, g, J * CELL_WIDTH, I * CELL_HEIGHT);
        g.drawImage(gamelogo.getImage(), 645, 70, 230, 63, this);
        g.drawString("SCORE: "+score, 730, 230);
        g.drawString("LIVES: "+live, 730, 250);
        g.drawString("LEVEL: "+level, 730, 270);
        g.drawImage(sdu.getImage(), 640, 270, 240, 240, this);
        g.drawImage(font.getImage(), 645, 520, 240, 120, this);
        if(score==700 || (score>0 && score%1500==0)){map[11][10]=MapItem.CHERRY;}
        
    }
    
    public void keyPressed(KeyEvent e) {
        if(live==0){JOptionPane.showMessageDialog(this, "GAME OVER");
        System.exit(0);
        }
        ghosts.execute(this);
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            pacman = pacman3;
            I--; // step if possible
            if (map[I][J] == MapItem.CHEESE){
                map[I][J] = MapItem.EMPTY;
                score+=10;
                cheese--;cheese2--;cheese3--;cheese4--;cheese5--;cheese6--;
            }
            else if(map[I][J]==MapItem.PELLET){
                map[I][J]=MapItem.EMPTY;
                score+=100;
                cheese--;cheese2--;cheese3--;cheese4--;cheese5--;cheese6--;
            }
            else if(map[I][J]==MapItem.CHERRY){
                map[I][J]=MapItem.EMPTY;
                live+=1;
                score+=100;
            }
            else if(map[I][J]==MapItem.GHOST1 || map[I][J]==MapItem.GHOST2 || map[I][J]==MapItem.GHOST3 || map[I][J]==MapItem.GHOST4){
                live-=1;
                I=11;
                J=10;
            }
            else if (map[I][J] != MapItem.EMPTY) {
                I++; // go back if impossible to step here
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            pacman = pacman2;
            J++; // same like previous
            if (map[I][J] == MapItem.CHEESE){
                map[I][J] = MapItem.EMPTY;
                score+=10;
                cheese--;cheese2--;cheese3--;cheese4--;cheese5--;cheese6--;
            }
            else if(map[I][J]==MapItem.PELLET){
                map[I][J]=MapItem.EMPTY;
                score+=100;
                cheese--;cheese2--;cheese3--;cheese4--;cheese5--;cheese6--;
            }
            else if(map[I][J]==MapItem.CHERRY){
                map[I][J]=MapItem.EMPTY;
                live+=1;
                score+=100;
            }
            else if(map[I][J]==MapItem.GHOST1 || map[I][J]==MapItem.GHOST2 || map[I][J]==MapItem.GHOST3 || map[I][J]==MapItem.GHOST4){
                live-=1;
                I=11;
                J=10;
            }
            else if (map[I][J] != MapItem.EMPTY) {
                J--;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            pacman = pacman4;
            I++;
            if (map[I][J] == MapItem.CHEESE){
                map[I][J] = MapItem.EMPTY;
                score+=10;
                cheese--;cheese2--;cheese3--;cheese4--;cheese5--;cheese6--;
            }
            else if(map[I][J]==MapItem.PELLET){
                map[I][J]=MapItem.EMPTY;
                score+=100;
                cheese--;cheese2--;cheese3--;cheese4--;cheese5--;cheese6--;
            }
            else if(map[I][J]==MapItem.CHERRY){
                map[I][J]=MapItem.EMPTY;
                live+=1;
                score+=100;
            }
            else if(map[I][J]==MapItem.GHOST1 || map[I][J]==MapItem.GHOST2 || map[I][J]==MapItem.GHOST3 || map[I][J]==MapItem.GHOST4){
                live-=1;
                I=11;
                J=10;
                JOptionPane.showMessageDialog(this, "Lose LIVE. You have "+live+"lives");
            }
            else if (map[I][J] != MapItem.EMPTY) {
                I--;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            pacman = pacman1;
            J--;
            //eat.play(false);
            if (map[I][J] == MapItem.CHEESE){
                map[I][J] = MapItem.EMPTY;
                score+=10;
                cheese--;cheese2--;cheese3--;cheese4--;cheese5--;cheese6--;
            }
            else if(map[I][J]==MapItem.PELLET){
                map[I][J]=MapItem.EMPTY;
                score+=100;
                cheese--;cheese2--;cheese3--;cheese4--;cheese5--;cheese6--;
            }
            else if(map[I][J]==MapItem.CHERRY){
                map[I][J]=MapItem.EMPTY;
                live+=1;
                score+=100;
            }
            else if(map[I][J]==MapItem.GHOST1 || map[I][J]==MapItem.GHOST2 || map[I][J]==MapItem.GHOST3 || map[I][J]==MapItem.GHOST4){
                live-=1;
                I=11;
                J=10;
            }
            else if (map[I][J] != MapItem.EMPTY) {
                J++;
            }
        } 
        if(cheese==0){
            loadMap("map2.txt");
            level++;
            cheese2=212;
            cheese=10000;
            J=10;
            I=11;
            JOptionPane.showMessageDialog(this, "You Win. Level 2");
            //newgame.play();
        }
        if(cheese2==0){
            loadMap("map3.txt");
            level++;
            cheese3=198;
            cheese2=10000;
            J=10;
            I=11;
            JOptionPane.showMessageDialog(this, "You Win. Level 3");
        }
        if(cheese3==0){
            loadMap("map4.txt");
            level++;
            cheese4=208;
            cheese3=10000;
            J=10;
            I=11;
            JOptionPane.showMessageDialog(this, "You Win. Level 4");
        }
        if(cheese4==0){
            loadMap("map5.txt");
            level++;
            cheese5=200;
            cheese4=10000;
            J=10;
            I=11;
            JOptionPane.showMessageDialog(this, "You Win. Level 5");
        }
        if(cheese5==0){
            loadMap("map6.txt");
            level++;
            cheese6=200;
            cheese5=10000;
            J=10;
            I=11;
            JOptionPane.showMessageDialog(this, "You Win. Level 6");
        }
        repaint();
    }
    
    public void run() {
        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map[i].length; j++){
            	if (map[i][j] == MapItem.GHOST1){
            		if (map[i - 1][j] != MapItem.WALL){
            			map[i - 1][j] = MapItem.GHOST1;
            		} else if (map[i+1][j] != MapItem.WALL){
            			map[i + 1][j] = MapItem.GHOST1;
            		} else if (map[i][j - 1] != MapItem.WALL){
            			map[i][j - 1] = MapItem.GHOST1;
            		} else if (map[i][j + 1] != MapItem.WALL){
            			map[i][j + 1] = MapItem.GHOST1;
            		}
            	}
       
            }
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    public void keyReleased(KeyEvent e) {}

    public void keyTyped(KeyEvent e) {}
    
}