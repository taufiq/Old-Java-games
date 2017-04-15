package com.taufiq.entities.mob;

import com.game.Input.KeyBoard;
import com.taufiq.Game.Screen;
import com.taufiq.Game.Sprite;
import com.taufiq.levels.tile.Tile;

public class Player extends Mob {
	public KeyBoard input;
	
	public Player(KeyBoard input){
		this.input = input;
	}
		
	public Player(int x, int y, KeyBoard input){
		this.x = x;
		this.y = y;
		this.input = input;
	}
	public void update(){
		int xa = 0;int ya = 0;
		if(input.up)ya = -1;
		if(input.down)ya = 1;
		if(input.right)xa = 1;
		if(input.left)xa = -1;
		if(input.attack)attack = true;
		else{attack = false;}
		if(xa != 0 || ya != 0)move(xa,ya);
	}
	public void render(Screen screen){
		if(dir == 0)
		screen.renderPlayer(x - 16, y - 16, Sprite.player0);
		if(dir == 1)
			screen.renderPlayer(x - 16,y - 16, Sprite.player1);
		if(dir == 2)
			screen.renderPlayer(x - 16, y - 16, Sprite.player2);
		if(dir == 3)
			screen.renderPlayer(x - 16, y - 16, Sprite.player3);
	}
	public int getx(){
		return x;
	}
	public int gety(){
		return y;
	}
	public int[] xy(){
		int[] r = new int[2];
		r[0] = x;
		r[1] = y;
		return r;
	}
}
