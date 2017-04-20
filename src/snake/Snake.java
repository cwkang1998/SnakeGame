package snake;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class Snake {
	
	private ArrayList<SnakeEntity> snakeBody;
	private SnakeEntity snakeHead;
	private int snakeLength;
	private int dx;
	private int dy;
	
	public Snake(){
		initSnake();
	}
	
	private void initSnake(){
		this.snakeHead = new SnakeEntity(1,0);
		this.snakeBody = new ArrayList<>();
		this.snakeBody.add(new SnakeEntity(0,0));
		this.snakeLength = 1;
		this.dx = 10;
		this.dy = 0;
	}
	
	
	public void grow(){
		int  previousPartX = snakeBody.get(snakeLength-1).getX();
		int  previousPartY = snakeBody.get(snakeLength-1).getY();
		snakeBody.add(new SnakeEntity(previousPartX, previousPartY));
		snakeLength++;
	}
	
	public void setDx(int dx) {
		this.dx = dx*10;
		this.dy = 0;
	}
	
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
	
	private void move(){
		int lastCoorX = snakeHead.getX();
		int lastCoorY = snakeHead.getY();
		snakeHead.setNewLocation(snakeHead.getX()+ dx, snakeHead.getY() + dy);
		attachTail(lastCoorX,lastCoorY);
	}
	
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
	
	public void draw(Graphics2D g2d){
		this.move();
		this.checkCollision();
		g2d.setColor(SnakeEntity.getSnakeColor());
		g2d.fill(snakeHead.getSnakeEntity());
		for(SnakeEntity part : snakeBody){
			g2d.fill(part.getSnakeEntity());
		}
	}
	
	private void checkCollision(){
		if(snakeHead.getX()<0||snakeHead.getY()<0||
				snakeHead.getX()>Display.WINDOWS_WIDTH+10||snakeHead.getY()>Display.WINDOWS_HEIGHT){
			initSnake();
		}
		else{
			for(SnakeEntity part : snakeBody){
				if(snakeHead.getX() == part.getX()&&snakeHead.getY()==part.getY()){
					initSnake();
					break;
				}
			}
		}
	}

}
