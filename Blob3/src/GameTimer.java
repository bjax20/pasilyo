import java.util.ArrayList;
import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;








public class GameTimer extends AnimationTimer {
	private GraphicsContext gc;
	private Scene theScene;
	private Group group;
	private Shape Circle;
	private ImageView player;
//	private Player myPlayer;
//	 private static final int SPEED = 5;
	private ArrayList<Enemy> enemy;
	ArrayList<ImageView> imageViewsEnemies;
	
	public static final int MAX_NUM_ENEMY = 10;
	ImageView eee;
	 private static final int SPEED = 5;
	private boolean movingUp;
    private boolean movingDown;
    private boolean movingLeft;
    private boolean movingRight;


	GameTimer(Scene scene, Group group){
		this.group = group;
//		Circle circle = new Circle(50, 50, 50, Color.RED);
//		circle.setLayoutX(100);
//		circle.setLayoutY(100);
		this.enemy = new ArrayList<Enemy>();
		this.imageViewsEnemies = new ArrayList<>();
		
		this.spawnEnemy();
	
//		Enemy bill = new Enemy(5, 5);
//		this.enemy.add(bill);
//		this.enemy.add(new Enemy(5,5));
//		Random r = new Random();
//
//		for(int i=0;i<GameTimer.MAX_NUM_ENEMY;i++){
//			int x = r.nextInt(200)+600;
//			int y = r.nextInt(GameStage.WINDOW_HEIGHT-50);
//			this.enemy.add(new Enemy(x,y));
////			System.out.println("An enemy has spawned.");
//		}
		for (Enemy e : this.enemy){
			ImageView imgView = new ImageView(e.img);
			imgView.setLayoutX(e.x);
			imgView.setLayoutY(e.y);
			this.group.getChildren().add(imgView);
			this.imageViewsEnemies.add(imgView);
		}
		
		// chnage to avatar
		
		Circle circle = new Circle(50, 50, 50, Color.RED);
		circle.setLayoutX(350);
		circle.setLayoutY(350);
		this.Circle = circle;
		
		// insert image
		Image image = new Image("images/player.png", Enemy.ENEMY_WIDTH,Enemy.ENEMY_WIDTH,false,false);
		ImageView player = new ImageView(image);
		player.setLayoutX(350);
		player.setLayoutY(350);
		this.player = player;
		
		
		
		this.group.getChildren().add(player);
		
		// CONTROLS SHITS
		
		// set up key event handlers
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.W) {
                movingUp = true;
            } else if (event.getCode() == KeyCode.S) {
                movingDown = true;
            } else if (event.getCode() == KeyCode.A) {
                movingLeft = true;
            } else if (event.getCode() == KeyCode.D) {
                movingRight = true;
            }
        });
        scene.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.W) {
                movingUp = false;
            } else if (event.getCode() == KeyCode.S) {
                movingDown = false;
            } else if (event.getCode() == KeyCode.A) {
                movingLeft = false;
            } else if (event.getCode() == KeyCode.D) {
                movingRight = false;
            }
        });
		
		
		
//		ImageView imgView = new ImageView(enemy.get(1).img);
//		imgView.setLayoutX(50);
//		imgView.setLayoutY(50);
//		this.eee = imgView;

//		this.group.getChildren().add(imgView);

//
//		Group root = new Group(circle);
//		this.theScene = new Scene(this.group, 100, 100);
//
//		this.enemy = new ArrayList<Enemy>();
//		this.spawnEnemy();

//		System.out.println(enemy.get(1).x);
//		
//		Image image = new Image("images/enemy.png", Enemy.ENEMY_WIDTH,Enemy.ENEMY_WIDTH,false,false);
//		ImageView imgView = new ImageView(image);
//		imgView.setLayoutX(50);
//		imgView.setLayoutY(60);
//		this.eee = imgView;

//		stage.setScene(this.theScene);
//		stage.show();
	}



	@Override
	public void handle(long currentNanoTime) {

//		ImageView imgView = new ImageView(enemy.get(1).img);
//		imgView.setLayoutX(enemy.get(1).x);
//		imgView.setLayoutY(enemy.get(1).y);
//		Group root = new Group(imgView);

    
    
    
    for (ImageView e : this.imageViewsEnemies){
    	 if (movingDown) {
			 e.setTranslateY( e.getTranslateY() - SPEED);
    }
    if (movingUp) {
    	e.setTranslateY( e.getTranslateY() + SPEED);
    }
    if (movingRight) {
    	e.setTranslateX( e.getTranslateX() - SPEED);
    }
    if (movingLeft) {
    	e.setTranslateX( e.getTranslateX() + SPEED);
    }
	}
    
    
    

	}


	private void spawnEnemy(){
		Random r = new Random();

		for(int i=0;i<GameTimer.MAX_NUM_ENEMY;i++){
			int x = r.nextInt(GameStage.WINDOW_WIDTH);
			int y = r.nextInt(GameStage.WINDOW_HEIGHT);
			this.enemy.add(new Enemy(x,y));
			System.out.println("An enemy has spawned.");
		}

	}


	private void renderEnemy() {
//		for (Enemy e : this.enemy){
//			e.render(this.gc);
//		}
	}




}
