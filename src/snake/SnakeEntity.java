package snake;

import java.awt.Color;
import java.awt.Rectangle;
/**
 * 
 * @author Chen Wen Kang
 * SnakeEntity represents each section of a Snake
 *
 */
public class SnakeEntity{
	
	//Fields
	private Rectangle snakeRect;
	private int x;
	private int y;
	private static final int SNAKE_WIDTH = 10;
	private static final int SNAKE_HEIGHT = 10;
	private static final Color SNAKE_COLOR = Color.WHITE;
	
	//Constructor
	public SnakeEntity(int x,int y){
		this.x = x;
		this.y = y;
		snakeRect = new Rectangle(this.x,this.y,SNAKE_WIDTH,SNAKE_HEIGHT);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setNewLocation(int x,int y){
		this.x = x;
		this.y = y;
		snakeRect.setLocation(this.x, this.y);
	}
	
	
	public Rectangle getSnakeEntity(){
		return snakeRect;
	}
	
	public static Color getSnakeColor() {
		return SNAKE_COLOR;
	}
	
	public static int getSNAKE_HEIGHT() {
		return SNAKE_HEIGHT;
	}
	
	public static int getSNAKE_WIDTH() {
		return SNAKE_WIDTH;
	}

}
