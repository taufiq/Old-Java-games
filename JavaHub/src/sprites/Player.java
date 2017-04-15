package sprites;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;

import Essen.Game;

public class Player implements KeyListener{
	int x = 0;
	int y = 0;
	int ya = 0;
	int xa = 0;
	int jumpCount = 0;
	int terminal = 7;
	int mass = 3;
	int gravity = 2;
	int weight = mass * gravity;
	int air = 0;
	int posY = 0;
	private Game game;
	public Player(Game game){
		this.game = game;
	}
	
	Image p1 = new ImageIcon(this.getClass().getClassLoader().getResource("Untitled.png")).getImage();
	
	public void fall(){
		x = x + xa;
			y = y + weight - air;
		if(y > game.getHeight() - 32){
			y = game.getHeight() - 32;
		}
		
		
	}
	public void render(Graphics g){
		g.drawImage(p1, x, y, null);
	}
	@Override
	public void keyTyped(KeyEvent e) {
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP){
			ya = -1;
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			xa = 1;
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT){
			xa = -1;
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		ya = 0;
		xa = 0;
		
	}
	
}
