package sprites;

import java.awt.Color;
import java.awt.Graphics;

import Essen.Game;

public class background {
	int x = 0;
	int y = 0;
	int xx = 0;
	int yy = 0;
	private Game game;
	int Xoffset = 5;
	public background(Game game){
		this.game = game;
	}
	public void render(Graphics g){
		
		g.fillRect(x, y, game.getWidth(), game.getHeight());
		
	}
	public void update(){
	
	}
}
