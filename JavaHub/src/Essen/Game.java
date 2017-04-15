package Essen;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import sprites.Player;
import sprites.background;

public class Game extends Canvas implements Runnable{
	private static final long serialVersionUID = 1L;
	
	int y = 1;
	
	private Thread thread;
	public static int WIDTH = 500;
	public static int HEIGHT = 1000;
	boolean running = false;
	BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	Player player = new Player(this);
	background bg = new background(this);
	public synchronized void start(){
		thread = new Thread(this, "Display");
		thread.start();
		running = true;
	}
	public synchronized void stop(){
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void run() {
		while(running){
			
			update();
			render();	
		}
	}
	private void render() {
		
		BufferStrategy bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, WIDTH,HEIGHT, null);
		g.setColor(Color.cyan);
		
		bg.render(g);
		player.render(g);
		g.dispose();
		bs.show();
		
	}
	private void update() {
		player.fall();
		bg.update();
		
	}
	public Game(){
		addKeyListener(new KeyListener(){

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				player.keyPressed(e);
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				player.keyReleased(e);
				
			}
			
		});
		setFocusable(true);
	}
	public static void main(String args[]){
		JFrame frame = new JFrame("BLOCK");
		Game game = new Game();
		frame.add(game);
		frame.setSize(WIDTH,HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		game.start();
	}
	
}