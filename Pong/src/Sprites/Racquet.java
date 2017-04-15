package Sprites;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import com.game.Game;

public class Racquet {
	private static Game game;
	private static final int Y = 255;
	private static final int WIDTH = 80;
	private static final int HEIGHT = 20;
	int x = 0;
	int xa = 0;


	public Racquet(Game game) {
		this.game = game;
	}

	public void move() {
		if (x + xa > 0 && x + xa < game.getWidth() - WIDTH)
			x = x + xa;
	}

	public void paint(Graphics2D g) {
		int y = game.getHeight() - 25;
		g.fillRect(x, y, WIDTH, HEIGHT);
	}

	public void keyReleased(KeyEvent e) {
		xa = 0;
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			xa = -3;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			xa = 3;
	}

	public Rectangle getBounds() {
		int y = game.getHeight() - 25;
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}

	public int getTopY() {
		int y = game.getHeight() - 25;
		return y;
	}
}