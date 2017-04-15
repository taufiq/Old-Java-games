package com.taufiq.levels.tile;

import com.taufiq.Game.Screen;
import com.taufiq.Game.Sprite;

public class VoidTile extends Tile {

	public VoidTile(Sprite sprite) {
		super(sprite);
		// TODO Auto-generated constructor stub
	}
	public void render(int x,int y, Screen screen){
		screen.renderTile(x << 4, y << 4, this);
	}

}
