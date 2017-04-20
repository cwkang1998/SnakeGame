package snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Display extends JPanel implements ActionListener,KeyListener{
	
	private Snake snake;
	final public static int WINDOWS_WIDTH = 400;
	final public static int WINDOWS_HEIGHT = 400;
	
	public Display(){
		this.snake = new Snake();
		this.setBackground(Color.DARK_GRAY);
		this.setPreferredSize(new Dimension(WINDOWS_WIDTH,WINDOWS_HEIGHT));
		this.setMinimumSize(new Dimension(WINDOWS_WIDTH,WINDOWS_HEIGHT));
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		snake.draw((Graphics2D)g);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_LEFT && snake.getDx()!= 10){
			snake.setDx(-1);
		}
		else if(key == KeyEvent.VK_RIGHT && snake.getDx()!=-10){
			snake.setDx(1);
		}
		else if(key == KeyEvent.VK_UP && snake.getDy()!=10){
			snake.setDy(-1);
		}
		else if(key == KeyEvent.VK_DOWN && snake.getDy()!=-10){
			snake.setDy(1);
		}
		else if(key == KeyEvent.VK_SPACE){
			snake.grow();
		}
	}

	@Deprecated
	@Override
	public void keyReleased(KeyEvent e){}


	@Deprecated
	@Override
	public void keyTyped(KeyEvent e) {}


	@Override
	public void actionPerformed(ActionEvent e) {
		this.repaint();
	}

}
