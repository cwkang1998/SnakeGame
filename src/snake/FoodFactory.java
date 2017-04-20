package snake;

import java.awt.Rectangle;
import java.util.Random;

public class FoodFactory {
	
	private int x;
	private int y;
	private Random random;
	
	public FoodFactory(){}
	
	private int generateRandomCoor(){
		return random.nextInt(800);
	}
	
	public Rectangle generateFood(){
		return new Rectangle();
	}
	
	

}
