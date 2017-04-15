package com.taufiq.levels.tile;

import com.taufiq.Game.Screen;
import com.taufiq.Game.Sprite;

public class Tile {
	public int x,y;
	public Sprite sprite;
	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	public static Tile WoodPlank = new VoidTile(Sprite.wood);
	public static Tile stone = new StoneTile(Sprite.stone);
		
	public Tile(Sprite sprite){
		this.sprite = sprite;
	}
	
	public void render(int x,int y, Screen screen){
		
	}
	public boolean solid(){
		return false;
	}
	
}
