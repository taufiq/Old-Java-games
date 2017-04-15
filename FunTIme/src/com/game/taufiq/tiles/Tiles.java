package com.game.taufiq.tiles;

import com.game.taufiq.main.Screen;
import com.game.taufiq.main.Sprites;

public class Tiles {
	public int x,y;
	public Sprites sprite;
	public static Tiles grass = new GrassTile(Sprites.grass);
	
	
	public Tiles(Sprites sprite){
		this.sprite = sprite;
	}
	public boolean isSolid(){
		return false;
	}
	public void render(int x,int y,Screen screen){
	}
}
