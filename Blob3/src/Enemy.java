import java.util.Random;
import javafx.scene.image.Image;




public class Enemy extends Sprite{
	public static final int MAX_ENEMY_SPEED = 5;
	public final static Image ENEMY_IMAGE = new Image("images/enemy.png", Enemy.ENEMY_WIDTH,Enemy.ENEMY_WIDTH,false,false);
	public final static int ENEMY_WIDTH=50;
	private boolean alive;
	//attribute that will determine if an enemy will initially move to the right part of the screen
	private boolean moveRight;
	private int speed;


	Enemy(int x, int y){
		super(x,y);
		this.alive = true;
		this.loadImage(Enemy.ENEMY_IMAGE);


		/*
		 *Randomize speed of fish and moveRight's initial value
		 */
//		Random r = new Random();
//		this.moveRight = r.nextBoolean();
//		this.speed = r.nextInt(Enemy.MAX_ENEMY_SPEED)+1;

	}


	//method that changes the x position of the enemy
	void move(){
		/*
		 * If moveRight is true and if the fish hasn't reached the right boundary yet,
		 *   then move the fish to the right by changing the x position of the fish depending on its speed.
		 * Else, if moveRight is false and the fish hasn't reached the left boundary yet,
		 * 	 then move the fish to the left by changing the x position of the fish depending on its speed.
		 * */


//		if(this.moveRight){
//			if(this.x + Enemy.ENEMY_WIDTH <= GameStage.WINDOW_WIDTH) this.x += this.speed;
//			else this.moveRight = false;
//		}else{
//			if(this.x <= 0) this.moveRight = true;
//			else this.x -= this.speed;
//		}

		// player's version of move (i just copy paste it for testing purposes only)

//		if(this.x+this.dx <= GameStage.WINDOW_WIDTH-this.width && this.x+this.dx >=0 && this.y+this.dy <= GameStage.WINDOW_HEIGHT-this.width && this.y+this.dy >=0){
//    		this.x += this.dx;
//    		this.y += this.dy;
//    	}

		this.x += this.dx;
		this.y += this.dy;


	}

	//getter
		public boolean isAlive() {
			return this.alive;
		}

}
