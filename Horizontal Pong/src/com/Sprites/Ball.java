package com.Sprites;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

import com.game.Screen;

public class Ball {
	boolean passed = false;
	public int x = 0;
	public int y = 0;
	int xa = 5;
	int ya = 5;
	public int eCounter = 0;
	public int pCounter = 0;
	public int chooser(){
		Random r = new Random();
	int[] array = new int[2];
	array[0] = 5;
	array[1] = -5;
	int rc = r.nextInt(2);
	return array[rc];
	}
	private Screen game;
	
	public Ball(Screen game){
		this.game = game;
	}
	public void move(){
		x = x + xa;
		y = y + ya;
		
		
		if (y + ya < 0){
			ya = 5;

		}
		else if (y + ya > game.getHeight() - 10){
			ya = -5;
		}
		else if(collision()){
			xa = 5;
			ya = chooser();
			pCounter = pCounter + 1;
		}
		else if(collision2()){
			xa = -5;
			eCounter = eCounter + 1;
		}
		
	}
	public boolean collision(){
		return getBounds().intersects(game.bat.getBounds());		
	}

	private boolean collision2(){
		return getBounds().intersects(game.bat1.getBounds());
	}
	public void paint(Graphics g){
		Graphics g2d = (Graphics) g;
		g2d.fillOval(x, y, 10, 10);
		
	}
	public Rectangle getBounds(){
		return new Rectangle(x,y,10,10);
	}
}
