package com.ravern.rpg.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener{
	
	private boolean[] keys = new boolean[300];
	public boolean up = false;
	public boolean down = false;
	public boolean left = false;
	public boolean right = false;
	
	public void update() {
		if (keys[KeyEvent.VK_UP] | keys[KeyEvent.VK_W]) {
			for (int i = 0; i < keys.length; i++) {
				if (i != KeyEvent.VK_UP)
					keys[i] = false;
			}
			up = true;
		}
		else up = false;
		if (keys[KeyEvent.VK_DOWN] | keys[KeyEvent.VK_S]) {
			for (int i = 0; i < keys.length; i++) {
				if (i != KeyEvent.VK_DOWN)
					keys[i] = false;
			}
			down = true;
		}
		else down = false;
		if (keys[KeyEvent.VK_LEFT] | keys[KeyEvent.VK_A]) {
			for (int i = 0; i < keys.length; i++) {
				if (i != KeyEvent.VK_LEFT)
					keys[i] = false;
			}
			left = true;
		}
		else left = false;
		if (keys[KeyEvent.VK_RIGHT] | keys[KeyEvent.VK_D]) {
			for (int i = 0; i < keys.length; i++) {
				if (i != KeyEvent.VK_RIGHT)
					keys[i] = false;
			}
			right = true;
		}
		else right = false;
	}

	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	public void keyTyped(KeyEvent e) {		
	}

}
