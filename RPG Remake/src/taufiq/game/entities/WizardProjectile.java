package taufiq.game.entities;

import taufiq.game.Screen;
import taufiq.game.Sprite;

public class WizardProjectile extends Projectile{
	public static int FIRE_RATE = 30;
	public WizardProjectile(int x, int y, int dir) {
		super(x, y, dir);
		sprite = Sprite.bullet;
		range = 300;
		speed = 10;
	}
	public void update(){
		move();
	}
	protected void move() {
		if(!level.tileCollision(x ,y ,(int)speed,(int) speed)){
		if(dir == 0){y -= speed;}
		if(dir == 1){x += speed;}
		if(dir == 2){y += speed;}
		if(dir == 3){x -= speed;}
		}
		if(level.tileCollision(x,y ,(int)speed,(int) speed))Remove();
	}
	public void render(Screen screen){
		screen.renderSprite(x , y, sprite);
	}
}
