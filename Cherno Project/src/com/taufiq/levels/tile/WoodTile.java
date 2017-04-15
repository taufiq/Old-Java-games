package com.taufiq.levels.tile;

import com.taufiq.Game.Screen;
import com.taufiq.Game.Sprite;

public class WoodTile extends Tile{
	public int x,y;
	public WoodTile(Sprite sprite) {
		super(sprite);
	}
public void render(int x,int y, Screen screen){
		screen.renderTile(x >> 4, y >> 4, this);
	}
}
