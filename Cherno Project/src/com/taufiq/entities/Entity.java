package com.taufiq.entities;

import java.util.Random;

import com.taufiq.Game.Screen;
import com.taufiq.levels.Level;

public abstract class Entity {
	public int x;
	public int y;
	private boolean removed = false;
	protected Level level;
	protected final Random random = new Random();
	public void update() {
	}
	public void render(Screen screen){

	}
	public void remove(){
		//Remove entity from level;
		removed = true;
	}
	public boolean isRemoved(){
		return removed;
	}
	public void init(Level level){
		this.level = level;
	}
}
