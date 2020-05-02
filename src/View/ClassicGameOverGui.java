package View;

import Control.ClassicLogic;
import View.Menu;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ClassicGameOverGui {

	Menu menu;
	Stage classicGameOverStage;
	ImageGetter imageGetter=ImageGetter.createImageGetter();
	ClassicLogic classicLogic=ClassicLogic.createClassicLogic();
	public ClassicGameOverGui(Stage classicGameOverStage) {
		this.classicGameOverStage = classicGameOverStage;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public void start()
	{
		classicGameOverStage.setTitle("Fruit Ninja");
		classicGameOverStage.centerOnScreen();
		classicGameOverStage.setResizable(false);
		Pane root = new Pane();
		Scene scene = new Scene(root,1000,650);
		classicGameOverStage.setScene(scene);
		classicGameOverStage.show();
		

		ImageView bg = new ImageView(imageGetter.getBackground().getImage());
		
		Label gameOverLbl = new Label("GAME OVER");
		gameOverLbl.setLayoutX(400);
		gameOverLbl.setLayoutY(80);
		gameOverLbl.setFont(new Font("Arial Bold", 35));
		gameOverLbl.setTextFill(Color.web("#90EE90", 1)); //Tomato color
		
		Label classicScore = new Label("Your Score: ");
		classicScore.setLayoutX(380);
		classicScore.setLayoutY(250);
		classicScore.setFont(new Font("Arial Bold", 30));
		classicScore.setTextFill(Color.web("#FFFF00", 1)); //Yellow color
		
		Label classicScoreValue = new Label(""+classicLogic.getScore());
		classicScoreValue.setLayoutX(600);
		classicScoreValue.setLayoutY(250);
		classicScoreValue.setFont(new Font("Arial Bold", 32));
		classicScoreValue.setTextFill(Color.web("#00FFFF", 1)); //Aqua color
		
		Label classicHighScore = new Label("Classic Mode High Score: ");
		classicHighScore.setLayoutX(180);
		classicHighScore.setLayoutY(400);
		classicHighScore.setFont(new Font("Arial Bold", 30));
		classicHighScore.setTextFill(Color.web("#FFFF00", 1)); //Yellow color
		
		Label classicHighScoreValue = new Label("0");
		classicHighScoreValue.setLayoutX(600);
		classicHighScoreValue.setLayoutY(400);
		classicHighScoreValue.setFont(new Font("Arial Bold", 32));
		classicHighScoreValue.setTextFill(Color.web("#00FFFF", 1)); //Aqua color
		

		ImageView menu = new ImageView(imageGetter.getBack().getImage());
		menu.setScaleX(0.21);
		menu.setScaleY(0.21);
		menu.setX(-100);
		menu.setY(350);
		menu.setRotate(180);
		menu.setOnMouseClicked(e -> {
			
			
			this.menu.start();
		});
	
		
		
		root.getChildren().addAll(bg,gameOverLbl,classicScore,classicScoreValue,classicHighScore,classicHighScoreValue,menu);
	
	}
}
