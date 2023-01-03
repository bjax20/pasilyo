import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WelcomeStage {

	private Scene welcomeScene;
	private Stage stage;
//	private Group root;
	private Canvas canvas;			// the canvas where the animation happens
	private GraphicsContext gc;
	private StackPane root;

	public WelcomeStage(Stage stage){
		this.stage = stage; // assign the stage argument to the stage variable of the welcomeStage class.
		welcomeSceneCreator(stage); // call the welcomeSceneCreator. It will create canvas and VBox for the menu (welcome stage).
	}


	public void setWelcomeStage(){
		// make the welcome stage as the current scene
		this.stage.setTitle("Buildings.io");
		this.stage.setScene( this.welcomeScene );
        this.stage.setResizable(false);
		this.stage.show();
	}

	// This method below will create a splash scene
		private void welcomeSceneCreator(Stage stage){
			StackPane root = new StackPane();
			root.getChildren().addAll(this.createCanvas(), this.createVBox());
			this.welcomeScene = new Scene(root);
		}

		private Canvas createCanvas() {
	    	Canvas canvas = new Canvas(GameStage.WINDOW_WIDTH,GameStage.WINDOW_HEIGHT);
	        GraphicsContext gc = canvas.getGraphicsContext2D();

	        Image bg = new Image("images/background.png");
	        gc.drawImage(bg, 0, 0);
	        return canvas;
	    }
		// The method below will create a VBox (so we can layout our menu buttons vertically)

		 private VBox createVBox() {
		    	VBox vbox = new VBox();
		        vbox.setAlignment(Pos.BOTTOM_CENTER);
		        vbox.setPadding(new Insets(10));
		        vbox.setSpacing(8);


		        // Creation of Buttons
		        Button newGameButton = new Button("New Game");    // this button start the game
		        Button instructionsButton = new Button("Instructions"); // this button go to instructions page
		        Button aboutButton = new Button("About");        // this button goes to the about page


		        vbox.getChildren().addAll(newGameButton, instructionsButton, aboutButton);


		        // NEW GAME BUTTON
		        newGameButton.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent e) {
//		                setGameStage(stage);		// changes the scene into the game scene
		            	GameStage gameStage = new GameStage(stage);
		            	gameStage.setGameStage();
		            }
		        });


		        // INSTRUCTIONS BUTTON
		        instructionsButton .setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent e) {
		            	setInstructionsPage(stage);     // call the method to set the scene to the instruction page
		            }
		        });

		        // ABOUT BUTTON
		        aboutButton.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent e) {
		            	setAboutPage(stage);     // call the method to set the scene to the about page
		            }
		        });

		        return vbox;
		    }


		 void setGameStage(Stage stage) {
			 // If this method get called, then the gameStage will be displayed.
			 // (specifically, the setGameStage method of the gameStage class will set the new current scene.
			 GameStage gameStage = new GameStage(stage);
//			 gameStage.setGameStage(); // when you use setGameStage() you are setting the game stage as the current scene.
			}


		 void setInstructionsPage(Stage stage){

			// If this method get called, the current scene will be the instructions page
			Canvas canvas = new Canvas( GameStage.WINDOW_WIDTH, GameStage.WINDOW_HEIGHT );
	 		Group root = new Group();
	 		VBox vbox = new VBox();
		    Button goBack = new Button("Go Back");

		    vbox.getChildren().add(goBack);
		    root.getChildren().addAll(canvas, vbox);
		        Scene scene = new Scene(root);
		        stage.setScene(scene);

		        goBack.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent e) {
		            	// set the scene to welcome stage AGAIN (going back)
		            	 setWelcomeStage();

		            }
		        });

		 }

		 void setAboutPage(Stage stage){
			// If this method get called, the current scene will be the About page
			 Canvas canvas = new Canvas( GameStage.WINDOW_WIDTH, GameStage.WINDOW_HEIGHT );
		 		Group root = new Group();
		 		VBox vbox = new VBox();
			    Button goBack = new Button("Go Back");

			    vbox.getChildren().add(goBack);
			    root.getChildren().addAll(canvas, vbox);
			        Scene scene = new Scene(root);
			        stage.setScene(scene);

			        goBack.setOnAction(new EventHandler<ActionEvent>() {
			            @Override
			            public void handle(ActionEvent e) {
 			                // set the scene to welcome stage AGAIN (going back)
			            	 setWelcomeStage();
			            }
			        });
		 }

}
