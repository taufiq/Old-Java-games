 package com.ravern.rpg;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import com.ravern.rpg.entities.Player;
import com.ravern.rpg.input.InputHandler;
import com.ravern.rpg.levels.Level;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 900;
	public static final int HEIGHT = 168 * 3;
	public final Dimension WindowSize = new Dimension (WIDTH, HEIGHT);
	public final String TITLE = "RPG";
	
	BufferedImage image = new BufferedImage (WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	public static JFrame frame;
	Level level = new Level(WIDTH , HEIGHT );
	InputHandler IH = new InputHandler();
	public static Player player = new Player();

	static boolean running = false;
	
	public void run() {
		long lastTime = System.nanoTime();
		double nsPerUpdate = 1000000000D/60D;
		
		int updates = 0;
		int frames = 0;
		
		long lastTimer = System.currentTimeMillis();
		double delta = 0 ;
		
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / nsPerUpdate;
			lastTime = now;
			boolean shouldrender = true;
			
			while (delta >= 1) {
				updates++;
				update();
				delta --;
				shouldrender = true;
			}
			
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if (shouldrender) {
				frames++;
				render();
			}
			
			if (System.currentTimeMillis() - lastTimer >= 1000) {
				lastTimer += 1000;
				System.out.println(frames + " frames, " + updates + " updates");
				frames = 0;
				updates = 0;
			}
		}
	}
	
	public synchronized void start () {
		running = true;
		new Thread (this).start();
	}
	
	public static synchronized void stop () {
		running = false;
		System.exit(0);
	}
	
	public Game() {
		frame = new JFrame();
		
		frame.setTitle (TITLE);
		frame.add(this, BorderLayout.CENTER);
		frame.pack();
		frame.setMinimumSize (WindowSize);
		frame.setPreferredSize (WindowSize);
		frame.setMaximumSize(WindowSize);
		frame.setResizable (false);
		frame.setVisible (true);
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.addKeyListener(IH);
	}

	public void update() {
		player.update(IH);
		IH.update();
	}
	
	public void render () {
		BufferStrategy bs = getBufferStrategy ();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		level.render(g, player.x, player.y);
		player.render(g);
		g.dispose();
		bs.show();
	}
	
	public static void main(String[] args) {
		new Game().start();
	}

}
