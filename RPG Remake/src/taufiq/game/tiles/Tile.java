package taufiq.game.tiles;

import taufiq.game.Screen;
import taufiq.game.Sprite;

public class Tile {
	public Sprite sprite;
	public static Tile grass = new GrassTile(Sprite.Grass);
	public static Tile VoidTile = new VoidTile(Sprite.Void);
	public static Tile Stone = new StoneTile(Sprite.Stone);
	public static Tile Wood = new WoodTile(Sprite.Wood);
	
	public Tile(Sprite sprite){
		this.sprite = sprite;
	}
	public void render(int x, int y, Screen screen){
		
	}
	public boolean solid(){
		return false;
	}
}
