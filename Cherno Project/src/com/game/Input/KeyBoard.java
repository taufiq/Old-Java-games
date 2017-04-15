package com.game.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoard implements KeyListener{
	private boolean[] keys = new boolean[300];
	public boolean up, down, left, right,attack;
	
	public void update(){
		up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W]; 
		down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S]; 
		left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A]; 
		right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D]; 
		attack = keys[KeyEvent.VK_SPACE]; 
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;	
	}

	
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;		
	}

}
