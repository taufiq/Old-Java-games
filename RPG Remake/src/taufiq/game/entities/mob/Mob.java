package taufiq.game.entities.mob;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import taufiq.game.entities.Entity;
import taufiq.game.entities.Projectile;
import taufiq.game.entities.WizardProjectile;
import taufiq.game.level.Level;

public abstract class Mob extends Entity {
	public int dir;
	boolean canhurt = true;
	public void render() {

	}

	public void move(int xa, int ya) {
		if (xa != 0 && ya != 0) {
			move(xa, 0);
			move(0, ya);
			return;
		}
		if (!collision(xa, ya)) {
			x += xa;
			y += ya;
		}
		if (xa > 0)
			dir = 1;
		if (xa < 0)
			dir = 3;
		if (ya > 0)
			dir = 2;
		if (ya < 0)
			dir = 0;
	}

	public boolean collision(int xa, int ya) {
		boolean solid = false;
		for (int c = 0; c < 4; c++) {
			int xt = (x + xa + c % 2 * 15) / 16;
			int yt = (y + ya + c / 2 * 15) / 16;
			if (level.getTile(xt, yt).solid())
				solid = true;
		}
		for(int i = 0;i < level.mobs.size();i++){
			if(level.mobs.get(i).getBounds().intersects(level.player.getBounds())){
				System.out.print("OKAY!");
			}; 
		}
		return solid;
	}
	protected void shoot(int x, int y, int dir) {
		Projectile shots = new WizardProjectile(x, y, dir);
		shots.init(level);
		level.addProjectile(shots);
	}

	public void update(){
	}
	
	public boolean solid(){
		return false;
	}
	public Rectangle getBounds(){
		return new Rectangle(x,y,16,16);
	}

}
