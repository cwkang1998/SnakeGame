package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;
/**
 * 
 * @author Chen Wen Kang
 * The food object for the snake to consume
 *
 */
public class Food{
	
	//Fields
	private int x;
	private int y;
	private Random random;
	
	
	//Constructors
	public Food(){
		this.random = new Random();
		this.x = generateX();
		this.y = generateY();
	}
	
	private int generateX(){
		while(true){
			int no = random.nextInt(400);
			if(no%10==0){
				return no;
			}
		}
	}
	
	private int generateY(){
		while(true){
			int no = random.nextInt(401);
			if(no%10==0){
				return no;
			}
		}
	}
	
	//Draws the food
	public void draw(Graphics2D g2d){
		g2d.setColor(Color.WHITE);
		g2d.fill(new Rectangle(x,y,10,10));
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}	

}
