package taufiq.game.entities.mob;



import taufiq.game.Screen;
import taufiq.game.Sprite;
import taufiq.game.level.Level;

public class Chaser extends Mob{
	Player player;

	public Chaser(int x, int y, Player player){
		this.x = x;
		this.y = y;
		this.player = player;
	}
	
	public void update() {
		int xa = 0;int ya = 0;
		if(x < player.x)xa = 1;
		if(x > player.x)xa = -1;
		if(y < player.y)ya = 1;
		if(y > player.y)ya = -1;
		if(xa != 0 || ya != 0)move(xa,ya);
	}

	
	public void render(Screen screen) {
		screen.renderPlayer(x, y, Sprite.Enemy);
	}
}
