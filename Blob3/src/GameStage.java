import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GameStage {
	public static final int WINDOW_HEIGHT = 800;
	public static final int WINDOW_WIDTH = 800;
	private Scene scene;
	private Stage stage;
	private Group root;
	private Canvas canvas;
	private GraphicsContext gc;
	private GameTimer gametimer;


	//the class constructor
	public GameStage(Stage stage) {
		this.stage = stage;
		this.root = new Group();
		this.scene = new Scene(root, GameStage.WINDOW_WIDTH,GameStage.WINDOW_HEIGHT,Color.CADETBLUE);
//
//		Image image = new Image("images/player.png", Enemy.ENEMY_WIDTH,Enemy.ENEMY_WIDTH,false,false);
//		ImageView imgView = new ImageView(image);
//		imgView.setLayoutX(50);
//		imgView.setLayoutY(60);
//		this.root.getChildren().add(imgView);


		this.canvas = new Canvas(GameStage.WINDOW_WIDTH,GameStage.WINDOW_HEIGHT);
//		this.gc = canvas.getGraphicsContext2D();
		//instantiate an animation timer
//		this.gametimer = new GameTimer(this.stage);
	}

	//method to add the stage elements
	public void setGameStage() {
		this.gametimer = new GameTimer(this.scene, this.root);
		this.stage.setTitle("Buildings.io");
		this.stage.setScene(this.scene);

//		this.stage = stage;

		//set stage elements here
//		this.root.getChildren().add(canvas);

//		this.stage.setTitle("Buildings.io");
//		this.stage.setScene(this.scene);
//
////		invoke the start method of the animation timer
		this.gametimer.start();
//
		this.stage.show();
	}



}
