package taufiq.game;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import taufiq.game.entities.mob.Chaser;
import taufiq.game.entities.mob.Player;
import taufiq.game.level.Level;
import taufiq.game.level.SpawnLevel;
import taufiq.game.tiles.TileCoordinate;



public class Game extends Canvas implements Runnable{
	private static final long serialVersionUID = 1L;
	public static int WIDTH = 250;
	public static int HEIGHT = 250;
	public static int SCALE = 3;
	public boolean running = false;
	static JFrame frame;
	TileCoordinate playerSpawn;
	Thread thread;
	Screen screen;
	KeyBoard key;
	private Level level;
	private Player player;
	private BufferedImage image = new BufferedImage(HEIGHT, WIDTH, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	
	public Game(){
		Dimension size = new Dimension(HEIGHT * SCALE, WIDTH * SCALE);
		screen = new Screen(WIDTH, HEIGHT);
		frame.setPreferredSize(size);
		playerSpawn = new TileCoordinate(6,10);
		key = new KeyBoard();
		addKeyListener(key);
		player = new Player(playerSpawn.x(),playerSpawn.y(), key);
		level = new SpawnLevel("/level.png", player);
		player.init(level);
		
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
		level.render(xScroll,yScroll, screen);
		player.render(screen);
		for(int i = 0;i < pixels.length;i++){
			pixels[i] = screen.pixels[i];
		}
		screen.clear();
		g.dispose();
		bs.show();
	}
	private void update() {
		key.update();
		player.update();
		level.update();
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
