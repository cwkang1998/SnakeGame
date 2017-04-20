package snake;

import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * 
 * @author Chen Wen Kang
 * Class for Full Snake Object, Dependent of the Snake Entity Class
 * which represents each section of the full snake
 *
 */
public class Snake {
	
	//Fields
	private ArrayList<SnakeEntity> snakeBody;
	private SnakeEntity snakeHead;
	private Food food;
	private int snakeLength;
	private int dx;
	private int dy;
	
	//Constructor
	public Snake(){
		initSnake();
	}
	
	//Initialise the snake
	public void initSnake(){
		this.snakeHead = new SnakeEntity(0,0);
		this.snakeBody = new ArrayList<>();
		this.snakeBody.add(new SnakeEntity(-1,0));
		this.snakeLength = 1;
		this.dx = 10;
		this.dy = 0;
	}	
	
	//Increase the length of the snake
	public void grow(){
		int  previousPartX = snakeBody.get(snakeLength-1).getX();
		int  previousPartY = snakeBody.get(snakeLength-1).getY();
		snakeBody.add(new SnakeEntity(previousPartX, previousPartY));
		snakeLength++;
	}
	
	//Set direction increment along X axis
	public void setDx(int dx) {
		this.dx = dx*10;
		this.dy = 0;
	}
	
	//Set direction increment along Y axis
	public void setDy(int dy) {
		this.dy = dy*10;
		this.dx = 0;
	}
	
	public int getDx() {
		return dx;
	}
	
	public int getDy() {
		return dy;
	}
	
	//Get the total length of the snake
	public int getSnakeLength() {
		return snakeLength;
	}
	
	public SnakeEntity getSnakeHead() {
		return snakeHead;
	}
	
	public ArrayList<SnakeEntity> getSnakeBody() {
		return snakeBody;
	}
	
	//move the snake
	private void move(){
		int lastCoorX = snakeHead.getX();
		int lastCoorY = snakeHead.getY();
		snakeHead.setNewLocation(snakeHead.getX()+ dx, snakeHead.getY() + dy);
		attachTail(lastCoorX,lastCoorY);
	}
	
	//Attach the tail to the snake head
	private void attachTail(int hLastX, int hLastY){
		int lastX = snakeBody.get(0).getX();
		int lastY = snakeBody.get(0).getY();
		snakeBody.get(0).setNewLocation(hLastX,hLastY);
		for(int i=1;i<this.snakeLength;i++){
			int tempX = snakeBody.get(i).getX();
			int tempY = snakeBody.get(i).getY(); 
			snakeBody.get(i).setNewLocation(lastX, lastY);
			lastX = tempX;
			lastY = tempY;
			
		}
	}
	
	
	//Draws the snake
	public void draw(Graphics2D g2d){
		this.move();
		g2d.setColor(SnakeEntity.getSnakeColor());
		g2d.fill(snakeHead.getSnakeEntity());
		for(SnakeEntity part : snakeBody){
			g2d.fill(part.getSnakeEntity());
		}
	}

}
