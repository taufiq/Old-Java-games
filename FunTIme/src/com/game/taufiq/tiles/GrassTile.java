package com.game.taufiq.tiles;

import com.game.taufiq.main.Screen;
import com.game.taufiq.main.Sprites;

public class GrassTile extends Tiles {
	int x,y;
	public Sprites sprite;

	public GrassTile(Sprites sprite) {
		super(sprite);
		this.sprite = sprite;
	}
	public void render(int x,int y, Screen screen){

		screen.renderTile(x << 4, y << 4, this);
		
	}

}
