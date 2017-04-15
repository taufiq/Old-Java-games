package com.game.taufiq.levels;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.game.taufiq.tiles.Tiles;

public class Level {
	public int width,height;
	int[] tiles;
	public Level(int width,int height){
		this.width = width;
		this.height = height;
		tiles = new int[width * height];
		load();
	}
	private void load(){
		try {
			BufferedImage image = ImageIO.read(Level.class.getResource("/level.png"));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, tiles, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public Tiles render(){
		for(int x = 0;x < width;x++){
			for(int y = 0;y < width;y++){
				if(tiles[x + y * width] == 0){
					return Tiles.grass;
				} 
			}
		}
	}
}
