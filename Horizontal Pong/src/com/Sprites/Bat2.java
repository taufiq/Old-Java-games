package com.Sprites;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.game.Screen;

public class Bat2 {
	int y = 100;
	int ya = 2;
	private Screen game;
	public Bat2(Screen game){
		this.game = game;
	}
	public void move(Screen game){
		y = game.ball.y;
		if(y <= 0){
			y = 0;
		}
		else if (y >= game.getHeight() - 80){
			y = game.getHeight() - 80;
		}
		}
	
	public void paint(Graphics g){
		Graphics g2d = (Graphics) g;
		g2d.fillRect(game.getWidth() - 26, y, 20, 80);
	}
	public Rectangle getBounds(){
		return new Rectangle(game.getWidth() - 26,y,20,80);
	}
}
