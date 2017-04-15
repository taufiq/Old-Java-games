package com.game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Sprites.Ball;
import Sprites.Racquet;

public class Game extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public Ball ball = new Ball(this);
	public Racquet racquet = new Racquet(this);
	
	
	private void move(){
		ball.move();
		racquet.move();
	}
	
	public void paint(Graphics g){	
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		ball.paint(g2d);
		racquet.paint(g2d);
		repaint();
		}
	
	public Game() {
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				racquet.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				racquet.keyPressed(e);
			}
		});
		setFocusable(true);
	}
	
	public static void main(String[] args) throws Exception {
	Game game =	new Game();
	JFrame frame = new JFrame("Pong");
	frame.add(game);
	frame.setSize(300,300);
	frame.setVisible(true);
	frame.setLocationRelativeTo(null);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	while(true){
		game.move();
		Thread.sleep(10);
	}
	}
}