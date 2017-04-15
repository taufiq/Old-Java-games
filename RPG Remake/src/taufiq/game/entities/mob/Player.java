package taufiq.game.entities.mob;



import taufiq.game.KeyBoard;
import taufiq.game.Screen;
import taufiq.game.Sprite;
import taufiq.game.entities.Projectile;
import taufiq.game.entities.WizardProjectile;

public class Player extends Mob{
	KeyBoard key;
	private int firerate = 0;
	Chaser chaser;
	public Player(int x, int y, KeyBoard key){
		this.x = x;
		this.y = y;
		this.key = key;
		firerate = WizardProjectile.FIRE_RATE;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void render(Screen screen){
		screen.renderPlayer(x, y, Sprite.Player);
	}
	public void update(){
		int xa = 0;int ya = 0;
		if(firerate > 0)firerate--;
		if(key.attack && firerate <= 0){shoot(x,y,dir);firerate = WizardProjectile.FIRE_RATE;}
		if(key.down){ya = 3;dir = 2;}
		if(key.up){ya = -3;dir = 0;}
		if(key.left){xa = -3;dir = 3;}
		if(key.right){xa = 3;dir = 1;}
		if(xa != 0 || ya != 0)move(xa,ya);
		clear();
	}
	private void clear(){
		for(int i = 0;i < level.projectiles.size();i++){
			Projectile p = level.projectiles.get(i);
			if(p.isRemoved())level.projectiles.remove(i);
		}
	}
	
	}
