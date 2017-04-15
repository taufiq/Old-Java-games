package taufiq.game.level;

import java.util.Random;

import taufiq.game.entities.mob.Player;

public class RandomLevel extends Level {
	private static Random random = new Random();

	public RandomLevel(int width, int height, Player player) {
		super(width, height, player);
	}

	protected void genLevel() {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				tiles[x + y * width] = random.nextInt(100);
			}
		}

	}

}
