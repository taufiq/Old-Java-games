package taufiq.game;

import taufiq.game.tiles.Tile;

public class Screen {
	public int width;
	public int height;
	int xOffset,yOffset;
	int[] pixels;
	public Screen(int width, int height){
		this.height = height;
		this.width = width;
		pixels = new int[width * height];
	}
	public void clear(){
			for(int i = 0;i < pixels.length;i++){
				pixels[i] = 0;
			}
	}
	public void renderTile(int xp, int yp, Tile tile) {
		xp -= xOffset;
		yp -= yOffset;
		for(int y = 0;y < tile.sprite.SIZE; y++){
			int ya = yp + y;
			for(int x = 0;x < tile.sprite.SIZE; x++){
				int xa = xp + x;
				if(xa < -tile.sprite.SIZE || xa >= width || ya < 0 || ya >= height)break;
				if(xa < 0)xa = 0;
				pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
			}
		}
	}
	public void renderSprite(int xp, int yp, Sprite sprite) {
		xp -= xOffset;
		yp -= yOffset;
		for(int y = 0;y < sprite.SIZE; y++){
			int ya = yp + y;
			for(int x = 0;x < sprite.SIZE; x++){
				int xa = xp + x;
				if(xa < -sprite.SIZE || xa >= width || ya < 0 || ya >= height)break;
				if(xa < 0)xa = 0;
				int col = sprite.pixels[x + y * sprite.SIZE];
				if(col != 0xffff00ff)pixels[xa + ya * width] = col;
			}
		}
	}
	public void setOffset(int xOffset,int yOffset){
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	public void renderPlayer(int xp, int yp, Sprite sprite) {
		xp -= xOffset;
		yp -= yOffset;
		for(int x = 0;x < sprite.SIZE;x++){
			int xa = x + xp;
			for(int y = 0;y < sprite.SIZE;y++){
				int ya = y + yp;
				if(xa < -sprite.SIZE || xa >= width || ya < 0 || ya >= height)break;
				pixels[xa + ya * width] = sprite.pixels[x + y * sprite.SIZE];
			}
		}
	}
}
