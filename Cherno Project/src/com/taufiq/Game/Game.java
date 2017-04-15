package com.taufiq.Game;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.game.Input.KeyBoard;
import com.taufiq.entities.mob.Chaser;
import com.taufiq.entities.mob.Player;
import com.taufiq.levels.Level;
import com.taufiq.levels.SpawnLevel;
import com.taufiq.levels.tile.TileCoordinate;


public class Game extends Canvas implements Runnable{
	public static int HEIGHT = 250;
	public static int WIDTH = 250;
	public static int SCALE = 3;
	private static final long serialVersionUID = 1L;
	private Thread thread;
	private int SPEED = 10;
	public boolean running = false;
	BufferedImage image = new BufferedImage(WIDTH,HEIGHT, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	private Screen screen;
	private Player player;
	private static JFrame frame;
	private KeyBoard key;
	private Level level;
	Chaser chaser;
	TileCoordinate playerSpawn;
	
	public static int x = 0;
	public static int y = 0;
	
	public Game(){
		Dimension size = new Dimension(WIDTH * SCALE,HEIGHT * SCALE);
		setPreferredSize(size);
		screen = new Screen(WIDTH,HEIGHT);
		key = new KeyBoard();
		addKeyListener(key);
		playerSpawn = new TileCoordinate(32,32);
		player = new Player(playerSpawn.x(),playerSpawn.y(),key);
		level = new SpawnLevel("/level.png");
		chaser = new Chaser(10,10, player);
		player.init(level);
		chaser.init(level);
	}
	
	public synchronized void start(){
		thread = new Thread(this, "Display");
		running = true;
		thread.start();
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
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0/60.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		while(running){
			long now = System.nanoTime();
			delta = delta + (now - lastTime)/ns;
			lastTime = now;
			requestFocus();
			while(delta >= 1){
				update();
				updates++;
				delta--;
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
	private void update() {
		key.update();
		player.update();
		chaser.update();
	}
	private void render() {
		BufferStrategy bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		int xScroll = player.x - screen.width/2;
		int yScroll = player.y - screen.height/2;
		screen.clear();
		level.render(xScroll, yScroll, screen);
		player.render(screen);
		chaser.render(screen);
		//The below is to make sure that the pixels in this class == to Screen class pixels[];
		for(int i = 0;i < pixels.length;i++){
			pixels[i] = screen.pixels[i];
		}
		player.render(screen);
		g.dispose();
		bs.show();
		
	}
	
	public static void main(String args[]){
		frame = new JFrame();
		Game game = new Game();
		frame.add(game);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.start();
	}
	
}
