package taufiq.game;

public class Sprite {
	private int x,y;
	public final int SIZE;
	public int[] pixels;
	private SpriteSheet sheet;
	public static Sprite Grass = new Sprite(16,0,1,SpriteSheet.origsheet);
	public static Sprite Void = new Sprite(16,5,0,SpriteSheet.origsheet);
	public static Sprite Player = new Sprite(16,4,0,SpriteSheet.origsheet);
	public static Sprite Enemy = new Sprite(16,3,0,SpriteSheet.origsheet);
	public static Sprite Wood = new Sprite(16,4,3,SpriteSheet.origsheet);
	public static Sprite Stone = new Sprite(16,1,2,SpriteSheet.origsheet);
	public static Sprite bullet = new Sprite(16,3,2,SpriteSheet.origsheet);
	
	public Sprite(int size, int x, int y,SpriteSheet sheet){
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
	}
	private void load(){
		for(int y = 0;y < SIZE;y++){
			for(int x = 0;x < SIZE;x++){
				pixels[x + y * SIZE] = sheet.pixels[(this.x + x) + (this.y + y) * sheet.Size];
			}
		}
	}
}
