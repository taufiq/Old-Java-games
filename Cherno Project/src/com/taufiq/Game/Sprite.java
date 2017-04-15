package com.taufiq.Game;

public class Sprite {
	public final int SIZE;
	private int x,y;
	public int[] pixels;
	private SpriteSheet sheet;
	
	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.OrigSheet);
	public static Sprite voidSprite = new Sprite(16,0x1B87E0); 
	public static Sprite wood = new Sprite(16,1,0,SpriteSheet.OrigSheet);
	public static Sprite player0 = new Sprite(32,0,5,SpriteSheet.OrigSheet);
	public static Sprite player1 = new Sprite(32,0,6,SpriteSheet.OrigSheet);
	public static Sprite player2 = new Sprite(32,0,7,SpriteSheet.OrigSheet);
	public static Sprite player3 = new Sprite(32,0,4,SpriteSheet.OrigSheet);
	public static Sprite stone = new Sprite(16, 0, 1, SpriteSheet.OrigSheet);
	public static Sprite tree = new Sprite(32, 0, 1, SpriteSheet.OrigSheet);
	
	public Sprite(int size,int x,int y,SpriteSheet sheet){
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
	}
	public Sprite(int size, int colour){
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
				pixels[x + y * SIZE] = sheet.pixels[(this.x + x) + (this.y + y) * sheet.SIZE];
			}
		}
	}
}
