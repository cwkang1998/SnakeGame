package snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * 
 * @author Chen Wen Kang
 * Class for the Game Logic of Snake
 *
 */

public class Game extends JPanel implements ActionListener,KeyListener{
	
	
	//Fields
	private Snake snake;
	private Food food;
	private int score;
	private JLabel scoreBoard;
	private Timer timer;
	private boolean gameOver = false;
	private boolean isPaused = false;
	final public static int WINDOWS_WIDTH = 400;
	final public static int WINDOWS_HEIGHT = 400;
	
	
	//Contructor
	public Game(){
		this.snake = new Snake();
		this.food = new Food();
		this.score = 0;
		this.scoreBoard = new JLabel();
		displayScore();
		this.setBackground(Color.DARK_GRAY);
		this.setPreferredSize(new Dimension(WINDOWS_WIDTH,WINDOWS_HEIGHT));
		this.setMinimumSize(new Dimension(WINDOWS_WIDTH,WINDOWS_HEIGHT));
	}
	
	
	//Timer initialisation from the Main Class
	public void initTimer(Timer timer){
		this.timer = timer;
	}
	
	//Spawns a new food on the map
	private void spawnNewFood(){
		this.food = new Food();
	}
	
	
	//Checks the snake's collision with wall, food and itself
	private void checkCollision(){
		if(snake.getSnakeHead().getX()==food.getX()&&snake.getSnakeHead().getY()==food.getY()){
			snake.grow();
			spawnNewFood();
			score += 10;
			displayScore();
		}
		else if(snake.getSnakeHead().getX()<0||snake.getSnakeHead().getY()<0||
				snake.getSnakeHead().getX()>Game.WINDOWS_WIDTH+10||snake.getSnakeHead().getY()>Game.WINDOWS_HEIGHT){
				gameOver = true;
		}
		else{
			for(SnakeEntity part : snake.getSnakeBody()){
				if(snake.getSnakeHead().getX() == part.getX()&&snake.getSnakeHead().getY()==part.getY()){
					gameOver = true;
					break;
				}
			}
		}
		if(gameOver){
			timer.stop();
			scoreBoard.setText("Game Over ! Your Score is " + score + ". Press Space to Restart !");
		}
	}
	
	//Display score on a JLabel
	private void displayScore(){
		scoreBoard.setText("Score : "+score);
	}
	
	
	//restarts the game
	private void restart(){
		snake.initSnake();
		score = 0;
		scoreBoard.setText("Score : "+score);
		gameOver = false;
		timer.start();
	}
	
	//Scoreboard getter
	public JLabel getScoreBoard() {
		return scoreBoard;
	}
		
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.checkCollision();
		snake.draw((Graphics2D)g);
		food.draw((Graphics2D)g);
		g.setColor(Color.WHITE);
	}

	//Getting User keyboard input
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
			if(gameOver){
				restart();
			}
			else if(!isPaused){
				isPaused = true;
				scoreBoard.setText("Paused");
				timer.stop();
			}
			else if(isPaused){
				isPaused = false;
				displayScore();
				timer.start();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.repaint();
	}

	@Deprecated
	@Override
	public void keyReleased(KeyEvent e){}


	@Deprecated
	@Override
	public void keyTyped(KeyEvent e) {}

}
