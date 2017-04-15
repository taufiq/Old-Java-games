package taufiq.game.level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import taufiq.game.entities.mob.Chaser;
import taufiq.game.entities.mob.Player;

public class SpawnLevel extends Level{
	String path;
	public SpawnLevel(String path, Player player){
		super(path, player);
		this.player = player;
	}
	protected void loadLevel(String path){
		this.path = path;
		try {
			BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
			int w = width =  image.getWidth();
			int h = height = image.getHeight();
			tiles = new int[width * height];
			image.getRGB(0, 0, w, h, tiles, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	protected void genLevel() {
		
	}
	
}
