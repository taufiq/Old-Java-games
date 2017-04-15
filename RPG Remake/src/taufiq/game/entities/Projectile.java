package taufiq.game.entities;

import taufiq.game.Sprite;
import taufiq.game.level.Level;

public class Projectile extends Entity{
	protected final int xOrigin, yOrigin;
	protected int xa,ya;
	protected Sprite sprite;
	protected double range, damage, speed;
	protected int dir;
	
	public Projectile(int x, int y,int dir){
		xOrigin = x;
		yOrigin = y;
		this.dir = dir;
		this.x = x;
		this.y = y;
	}
	protected void move() {
		
	}
	
	public void init(Level level){
		this.level = level;
	}
	
}
