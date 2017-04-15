package taufiq.game;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	private String path;
	public final int Size;
	int[] pixels;
	public static SpriteSheet origsheet = new SpriteSheet(96, "/SpriteTiles.png");
	public SpriteSheet(int SIZE,String path){
		Size = SIZE;
		this.path = path;
		pixels = new int[SIZE * SIZE];
		loadSheet();
	}
	private void loadSheet() {
		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, pixels, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
