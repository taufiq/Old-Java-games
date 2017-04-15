package com.taufiq.levels;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import com.taufiq.levels.tile.Tile;

public class SpawnLevel extends Level{
	String path;
	public SpawnLevel(String path){
		super(path);
	}
	protected void loadLevel(String path) {
		try {
			this.path = path;
			BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
			int h = height = image.getHeight();
			int w = width = image.getWidth();
			tiles = new int[width * height];
			image.getRGB(0, 0, w, h, tiles, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("ERROR!Can't load the Level!");
		}
	}
	//Grass is 0x00ff00;
	//Void tile is 0xff00ff;
	protected void GenLevel() {

	}
}
