package snake;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Main {
	
	private JFrame frame;
	private Game game;
	private Timer timer;
	
	public Main(){
		frame = new JFrame("Snake");
		game = new Game();
		timer = new Timer(90,game);
		game.initTimer(timer);
		
		frame.setLayout(new BorderLayout());
		frame.add(game,BorderLayout.CENTER);
		frame.add(game.getScoreBoard(), BorderLayout.NORTH);
		frame.addKeyListener(game);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		System.out.println(	frame.getSize() + " "+game.getSize());
		timer.start();
	}
	
	public static void main(String[] args){
		new Main();
	}

}
