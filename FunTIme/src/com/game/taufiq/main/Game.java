package com.game.taufiq.main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{
	private static final long serialVersionUID = 1L;
	private boolean running = false;
	private Thread thread;
	private static JFrame frame;
	public static int WIDTH = 700;
	public static int HEIGHT = 700;
	private Screen screen;
	private KeyBoard key;
	int x = 0;
	int y = 0;
	BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	int pixels[] = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	
	public Game(){
		screen = new Screen(WIDTH,HEIGHT);
		key = new KeyBoard();
		addKeyListener(key);
	}
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
		long lastTime = System.nanoTime();
		double delta = 0;
		long timer = System.currentTimeMillis();
		double nspertick = 1000000000D/60D;
		int frames = 0;
		int updates = 0;
		while(running){
			requestFocus();
			long now = System.nanoTime();
			delta = delta + (now - lastTime)/nspertick;
			lastTime = now;
			if(delta >= 1){
				delta--;
				update();
				updates++;
			}
			render();
			frames++;
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				frame.setTitle("Ticks:" + updates + " || " + "Frames:" + frames);
				updates = 0;
				frames = 0;
			}
		}
		
	}

	private void render() {
		BufferStrategy bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, WIDTH, HEIGHT, null);
		screen.clear();
		g.dispose();
		bs.show();
		for(int i = 0;i < pixels.length;i++){
			pixels[i] = screen.pixels[i];
		}
	}

	private void update() {
		key.update();
		if(key.up)y -= 3;
		if(key.down)y += 3;
		if(key.left)x -= 3;
		if(key.right)x += 3;
		
	}
	public static void main(String args[]){
		frame = new JFrame();
		Game game = new Game();
		frame.add(game);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.start();
	}
}
