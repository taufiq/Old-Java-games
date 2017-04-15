package com.game.taufiq.main;

import com.game.taufiq.tiles.Tiles;

public class Screen {
	int width;
	int height;
	int[] pixels;
	int xOffset;
	int yOffset;

	public Screen(int width,int height){
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}
	public void renderTile(int xp,int yp,Tiles tile){
		for(int x = 0;x < tile.sprite.SIZE;x++){
			int xa = x + xp;
			for(int y = 0;y < tile.sprite.SIZE;y++){
				int ya = y + yp;
				pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
			}
		}
	}
	public void clear() {
		for(int i = 0;i < pixels.length;i++){
			pixels[i] = 0;
		}
		
	}
}
