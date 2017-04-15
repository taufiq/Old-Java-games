package com.Sprites;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.game.Screen;

public class Bat{
	private Screen game;
	int y = 50;
	int ya = 0;
	public Bat(Screen game){
		this.game = game;
	}
	public void paint(Graphics g){
		Graphics g2d = (Graphics) g;
		g2d.fillRect(6, y, 20, 80);
	}
	public void move(){
		if(y + ya > 0 && y + ya < game.getHeight() - 80)
		y = y + ya;
	}

	public void keyPressed(KeyEvent e) {
		int keycode = e.getKeyCode();
		if(keycode == KeyEvent.VK_UP)
			ya = -5;
		if (keycode == KeyEvent.VK_DOWN)
			ya = 5;
	}
	public void keyReleased(KeyEvent e) {
		ya = 0;
		
	}
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public Rectangle getBounds(){
		return new Rectangle(6,y,20,80);
	}
}
