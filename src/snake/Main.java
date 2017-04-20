package snake;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Main {
	
	private JFrame frame;
	private Display display;
	private Timer timer;
	
	public Main(){
		frame = new JFrame("Snake");
		display = new Display();
		timer = new Timer(90,display);
		frame.setLayout(new BorderLayout());
		frame.add(display,BorderLayout.CENTER);
		frame.add(new Label("Test"), BorderLayout.SOUTH);
		frame.addKeyListener(display);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		System.out.println(	frame.getSize() + " "+display.getSize());
		timer.start();
	}
	
	public static void main(String[] args){
		new Main();
	}

}
