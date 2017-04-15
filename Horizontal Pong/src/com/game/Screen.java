package com.game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.Sprites.Ball;
import com.Sprites.Bat;
import com.Sprites.Bat2;
public class Screen extends Canvas {

	private static final long serialVersionUID = 1L;
	public Ball ball = new Ball(this);
	public Bat bat = new Bat(this);
	public Bat2 bat1 = new Bat2(this);
	protected Ball game;
	private void move(){
		ball.move();
		bat.move();
		bat1.move(this);
	}
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.white);
		g2d.drawString(String.valueOf(ball.pCounter), 50, 50);
		ball.paint(g2d);
		bat.paint(g2d);
		bat1.paint(g2d);
		g.setColor(Color.WHITE);
		repaint();
	}
	public Screen(){
		addKeyListener(new KeyListener(){

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				bat.keyPressed(e);
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				bat.keyReleased(e);
				
			}
		});
			setFocusable(true);
	}
	
	public static void main(String args[]) throws InterruptedException{
		JFrame frame = new JFrame("Pong");
		Screen game = new Screen();
		frame.add(game);
		frame.setSize(800,500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		while(true){
			Thread.sleep(10);
			game.move();
		}
	}


}
