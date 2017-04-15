package com.taufiq.entities.mob;

import com.taufiq.Game.Screen;
import com.taufiq.Game.Sprite;

public class Chaser extends Mob{
	Player player;
	public Chaser(int x, int y, Player player){
		this.x = x;
		this.y = y;
		this.player = player;
	}

	@Override
	public void update() {
		int xa = 0;int ya = 0;
		if(x < player.x)xa = 1;
		if(x > player.x)xa = -1;
		if(y < player.y)ya = 1;
		if(y > player.y)ya = -1;
		if(xa != 0 || ya != 0)move(xa,ya);
	}

	@Override
	public void render(Screen screen) {
		screen.renderPlayer(x - 16, y - 16, Sprite.player0);
	}
}
