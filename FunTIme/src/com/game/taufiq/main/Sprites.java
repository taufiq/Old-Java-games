package com.game.taufiq.main;



public class Sprites {
	public final int SIZE;
	private int x,y;
	private SpriteSheet sheet;
	int[] pixels;
	public static Sprites grass = new Sprites(16,0,0,SpriteSheet.tiles);
	
	public Sprites(int size,int x,int y,SpriteSheet sheet){
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
	}
	public Sprites(int size, int colour){
		SIZE = size;
		pixels = new int[SIZE *SIZE];
		setColour(colour);
	}
	private void setColour(int colour) {
		for(int i = 0;i < SIZE*SIZE;i++){
			pixels[i] = colour;
		}
	}
	private void load(){
		for(int y = 0;y < SIZE;y++){
			for(int x = 0;x < SIZE;x++){
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
			}
		}
	}
}