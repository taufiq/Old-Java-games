package taufiq.game.entities;

import java.util.Random;




import taufiq.game.Screen;
import taufiq.game.level.Level;



public abstract class Entity {
	public int x;
	public int y;
	boolean removed = false;
	public Level level;
	protected final Random random = new Random();
	
	public void update() {
	}
	
	public void render(Screen screen){
	}
	
	public boolean isRemoved(){
		return removed;
	}
	public void Remove(){
		removed = true;
	}
	public void init(Level level){
		this.level = level;
	}
}

