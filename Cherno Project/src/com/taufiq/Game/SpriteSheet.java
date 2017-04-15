package com.taufiq.Game;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	String path;
	public final int SIZE;
	public int[] pixels;
	
	public static SpriteSheet OrigSheet = new SpriteSheet("/Spritesheet.png",256);
	public SpriteSheet(String path, int size){
		this.path = path;
		this.SIZE = size;
		pixels = new int[SIZE * SIZE];
		loadSheet();
	}
	private void loadSheet(){
		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			pixels = image.getRGB(0, 0, w, h,null, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
