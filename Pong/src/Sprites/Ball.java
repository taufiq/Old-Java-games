package Sprites;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.game.Game;

public class Ball {
	private static final int DIAMETER = 30;
	int x = 0;
	int y = 0;
	int xa = 1;
	int ya = 1;
	private Game game;

	public Ball(Game game) {
		this.game= game;
	}

	public void move() {
		x = x + xa;
		y = y + ya;
		if (x + xa < 0)
			xa = 1;
		if (x + xa > game.getWidth() - DIAMETER)
			xa = -1;
		if (y + ya < 0)
			ya = 1;
	
		if (collision()){
			ya = -1;
			y = game.racquet.getTopY() - DIAMETER;
		}
		
	}

	private boolean collision(){
		return getBounds().intersects(game.racquet.getBounds());
	}
	public Rectangle getBounds() {
		return new Rectangle(x,y,DIAMETER,DIAMETER);
	}

	public void paint(Graphics2D g) {
		Font font = new Font("ARIAL",0,30);
		game.setFont(font);
		if(y + ya > game.getHeight() - DIAMETER){
			g.drawString("YOU DIED", 70, game.getHeight()/2); 
		}
		g.fillOval(x, y, DIAMETER, DIAMETER);
	}
}