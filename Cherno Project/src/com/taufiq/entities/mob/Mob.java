package com.taufiq.entities.mob;

import com.taufiq.Game.Screen;
import com.taufiq.Game.Sprite;
import com.taufiq.entities.Entity;

public abstract class Mob extends Entity{
	protected Sprite sprite;
	protected int dir = 0;
	protected boolean solid;
	protected boolean moving = false;
	protected boolean attack = false;

	public void move(int xa, int ya){
		if(xa != 0 && ya != 0){
			move(xa,0);
			move(0,ya);
			return;
		}
		if(xa > 0)dir = 1;
		if(xa < 0)dir = 3;
		if(ya > 0)dir = 2;
		if(ya < 0)dir = 0;
		if(!collision(xa,ya)){
			x += xa;
			y += ya;
		}
	}
	
	public abstract void update();
	public abstract void render(Screen screen);
	private boolean collision(int xa,int ya){
		boolean solid = false;
		for(int c = 0;c < 4;c++){
			int xt = (x + xa + c % 2 * 20 - 10)/16;
			int yt = (y + ya + c / 2 * 20 - 4)/16;
			if(level.getTile(xt,yt).solid())solid = true;
		}
		return solid;
	}
	
}
