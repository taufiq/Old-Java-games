package com.taufiq.levels;




import com.taufiq.Game.Screen;
import com.taufiq.entities.mob.Player;
import com.taufiq.levels.tile.Tile;

public class Level {
	protected int[] tiles;
	protected int width, height;
	protected int[] tilesInt;
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tilesInt = new int[width * height];
		GenLevel();
	}

	public Level(String path) {
		loadLevel(path);
		GenLevel();
	}

	protected void loadLevel(String path) {

	}

	protected void GenLevel() {
	}

	public void update() {

	}

	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;

		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x,y).render(x, y, screen);
			}
		}

	}


	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height)return Tile.grass;
		if (tiles[x + y * width] == 0xFF00FF00)return Tile.grass;
		if (tiles[x + y * width] == 0xFFFF00FF)return Tile.WoodPlank;		
		if (tiles[x + y * width] == 0xFFFF0000)return Tile.stone;		
		return Tile.voidTile;
	}
}
