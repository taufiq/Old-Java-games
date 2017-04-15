package taufiq.game.level;

import java.util.ArrayList;
import java.util.List;

import taufiq.game.Screen;
import taufiq.game.entities.Entity;
import taufiq.game.entities.Projectile;
import taufiq.game.entities.mob.Chaser;
import taufiq.game.entities.mob.Mob;
import taufiq.game.entities.mob.Player;
import taufiq.game.tiles.Tile;

public class Level {
	protected int[] tiles;
	protected int width, height;
	protected int[] tilesInt;
	public Player player;
	private List<Entity> entities = new ArrayList<Entity>();
	public List<Projectile> projectiles = new ArrayList<Projectile>();
	public List<Mob> mobs = new ArrayList<Mob>();
	private boolean solid = false;

	public Level(int width, int height, Player player) {
		this.width = width;
		this.height = height;
		this.player = player;
		tilesInt = new int[width * height];
		genLevel();
	}

	public Level(String path, Player player) {
		loadLevel(path);
		genLevel();
	}

	protected void loadLevel(String path) {

	}

	protected void genLevel() {

	}

	public void update() {
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).update();
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();
		}
		for (int i = 0; i < mobs.size(); i++) {
			System.out.println(mobs.get(i));
			mobs.get(i).update();
			mobs.get(i).init(this);
		}
	}

	public void addProjectile(Projectile p) {
		projectiles.add(p);
	}

	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;

		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen);
			}
		}
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).render(screen);
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).render(screen);
		}
		for (int i = 0; i < mobs.size(); i++) {
			mobs.get(i).render(screen);
		}
	}

	public void addEntity(Entity e) {
		entities.add(e);
	}

	public void addMob(Mob m) {
		mobs.add(m);
	}

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height)
			return Tile.grass;
		if (tiles[x + y * width] == 0xFFff0000)
			return Tile.Wood;
		if (tiles[x + y * width] == 0xFF0ff0ef)
			return Tile.Stone;
		if (tiles[x + y * width] == 0xFF00FF00)
			return Tile.grass;
		return Tile.VoidTile;
	}

	public boolean tileCollision(int x, int y, int xa, int ya) {
		boolean solid = false;
		for (int c = 0; c < 4; c++) {
			int xt = (x + xa + c % 2 * 7 + 2) / 16;
			int yt = (y + ya + c / 2 * 10 + 3) / 16;
			if (getTile(xt, yt).solid())
				solid = true;
		}
		return solid;
	}

	public boolean Collision(int x, int y) {
		for (int i = 0; i < mobs.size(); i++) {
			if (mobs.get(i).getBounds().intersects(player.getBounds())) {
				solid = true;
			}
		}
		return solid;
	}
}