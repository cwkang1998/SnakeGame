package snake;

import java.awt.Color;
import java.awt.Rectangle;

public class SnakeEntity{
	
	private Rectangle snakeRect;
	private int x;
	private int y;
	private static final int SNAKE_WIDTH = 10;
	private static final int SNAKE_HEIGHT = 10;
	private static final Color SNAKE_COLOR = Color.WHITE;
	
	public SnakeEntity(){
		snakeRect = new Rectangle(SNAKE_WIDTH,SNAKE_HEIGHT);
		this.x = 0;
		this.y = 0;
	}
	
	public SnakeEntity(int x,int y){
		snakeRect = new Rectangle(SNAKE_WIDTH,SNAKE_HEIGHT);
		this.x = x;
		this.y = y;
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
