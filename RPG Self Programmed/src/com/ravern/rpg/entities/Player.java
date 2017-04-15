package com.ravern.rpg.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.ravern.rpg.input.InputHandler;
import com.ravern.rpg.levels.Level;

public class Player {
	
	public boolean goingUp = false;
	public boolean goingDown = false;
	public boolean goingLeft = false;
	public boolean goingRight = false;
	
	public boolean facingUp = false;
	public boolean facingDown = false;
	public boolean facingLeft = false;
	public boolean facingRight = true;
	
	BufferedImage playerUp;
	BufferedImage playerDown;
	BufferedImage playerLeft;
	BufferedImage playerRight;
	
	public int speed = 2;
	public int x = 0, y = 0;
	public int OnScreenX = 900 / 2 - Level.tileSize /2;
	public int OnScreenY = 504 / 2 - Level.tileSize /2;
	
	public Player() {
		try {
			BufferedImage imageUp = ImageIO.read(Player.class.getResource("/playerUp.png"));
			BufferedImage imageDown = ImageIO.read(Player.class.getResource("/playerDown.png"));
			BufferedImage imageLeft = ImageIO.read(Player.class.getResource("/playerLeft.png"));
			BufferedImage imageRight = ImageIO.read(Player.class.getResource("/playerRight.png"));
			playerUp = imageUp;
			playerDown = imageDown;
			playerLeft = imageLeft;
			playerRight = imageRight;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update(InputHandler IH) {
			if (IH.up) {
				goingUp = true;
				goingDown = false;
				goingLeft = false;
				goingRight = false;
				facingUp = true;
				facingDown = false;
				facingLeft = false;
				facingRight = false;
			} else goingUp = false;
			if (IH.down) {
				goingUp = false;
				goingDown = true;
				goingLeft = false;
				goingRight = false;
				facingDown = true;
				facingUp = false;
				facingLeft = false;
				facingRight = false;
			} else goingDown = false;
			if (IH.left) {
				goingUp = false;
				goingDown = false;
				goingLeft = true;
				goingRight = false;
				facingLeft = true;
				facingUp = false;
				facingDown = false;
				facingRight = false;
			} else goingLeft = false;
			if (IH.right) {
				goingUp = false;
				goingDown = false;
				goingLeft = false;
				goingRight = true;
				facingRight = true;
				facingUp = false;
				facingDown = false;
				facingLeft = false;
			} else goingRight = false;
			
			if (goingUp) y += speed;
			if (goingDown) y -= speed;
			if (goingLeft) x += speed;
			if (goingRight) x -= speed;
	}
	
	public void render(Graphics g) {
		if (facingUp)
			g.drawImage(playerUp, OnScreenX, OnScreenY, Level.tileSize, Level.tileSize, null);
		if (facingDown)
			g.drawImage(playerDown, OnScreenX, OnScreenY, Level.tileSize, Level.tileSize, null);
		if (facingLeft)
			g.drawImage(playerLeft, OnScreenX, OnScreenY, Level.tileSize, Level.tileSize, null);
		if (facingRight)
			g.drawImage(playerRight, OnScreenX, OnScreenY, Level.tileSize, Level.tileSize, null);
	}
	
}
