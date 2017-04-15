package com.ravern.rpg.levels;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.ravern.rpg.Game;

public class Level {
	
	public static int tileSize = 64;
	private final int WIDTH, HEIGHT;
	private final int MAP_SIZE = 100;
	BufferedImage grass;
	BufferedImage wall;
	
	public Level(int width, int height) {
		this.WIDTH = width;
		this.HEIGHT = height;
		try {
			BufferedImage grass = ImageIO.read(Level.class.getResource("/grass.png"));
			BufferedImage wall = ImageIO.read(Level.class.getResource("/wall.png"));
			this.grass = grass;
			this.wall = wall;
		} catch (IOException e){
			System.out.println("IO Error!");
		}
	}
		
	public void render(Graphics g, int xOffset, int yOffset) {
		for (int y = 0; y < MAP_SIZE; y++) {
			for (int x = 0; x < MAP_SIZE; x++) {
				int xx = x * tileSize + xOffset;
				int yy = y * tileSize + yOffset;
				if (xx >= 0 - tileSize & xx <= WIDTH & yy >= 0 - tileSize & yy <= HEIGHT) {
					drawTile(g, xx, yy, grass);
				}
			}
		}
		drawTileGrp(g, 1, 1, 1, 4, xOffset, yOffset, wall);
		drawTileGrp(g, 1, 7, 4, 1, xOffset, yOffset, wall);
	}
	
	private void drawTile(Graphics g, int xTile, int yTile, BufferedImage image) {
		g.drawImage(image, xTile, yTile, tileSize, tileSize, null);
	}
	
	private void drawTileGrp(Graphics g, int xTile, int yTile, int widthTile, int heightTile, int xOffset, int yOffset, BufferedImage image) {
		for (int yd = yTile; yd < heightTile + yTile; yd++) {
			for (int xd = xTile; xd < widthTile + xTile; xd++) {
				int xx = xd * tileSize + xOffset;
				int yy = yd * tileSize + yOffset;
				g.drawImage(image, xx, yy, tileSize, tileSize, null);
				if (Game.player.OnScreenX < xx + tileSize && Game.player.OnScreenX + tileSize > xx && Game.player.OnScreenY < yy + tileSize && Game.player.OnScreenY + tileSize > yy) {
					if (Game.player.goingUp) {
						Game.player.y += Game.player.speed;
					}
					if (Game.player.goingDown) {
						Game.player.y -= Game.player.speed;
					}
					if (Game.player.goingLeft) {
						Game.player.x += Game.player.speed;
					}
					if (Game.player.goingRight) {
						Game.player.x -= Game.player.speed;
					}
				}
			}
		}
	}
	
}
