package View;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HighScoresGui {

    ImageGetter imageGetter=ImageGetter.createImageGetter();
    Stage highScoresStage;
    Menu menu;

    public HighScoresGui(Stage highScoresStage ) {
        this.highScoresStage = highScoresStage;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void start()
    {



        Pane root = new Pane();
        Scene scene = new Scene(root,1000,650);
        highScoresStage.setScene(scene);
        highScoresStage.show();


        ImageView bg = new ImageView(imageGetter.getBackground().getImage());

        Label classicHighScore = new Label("Classic Mode High Score: ");
        classicHighScore.setLayoutX(180);
        classicHighScore.setLayoutY(200);
        classicHighScore.setFont(new Font("Arial Bold", 30));
        classicHighScore.setTextFill(Color.web("#FFFF00", 1)); //Yellow color

        Label classicScoreValue = new Label("0");
        classicScoreValue.setLayoutX(600);
        classicScoreValue.setLayoutY(200);
        classicScoreValue.setFont(new Font("Arial Bold", 32));
        classicScoreValue.setTextFill(Color.web("#00FFFF", 1)); //Aqua color

        Label arcadeHighScore = new Label("Arcade Mode High Score: ");
        arcadeHighScore.setLayoutX(180);
        arcadeHighScore.setLayoutY(400);
        arcadeHighScore.setFont(new Font("Arial Bold", 30));
        arcadeHighScore.setTextFill(Color.web("#FFFF00", 1)); //Yellow color

        Label arcadeScoreValue = new Label("0");
        arcadeScoreValue.setLayoutX(600);
        arcadeScoreValue.setLayoutY(400);
        arcadeScoreValue.setFont(new Font("Arial Bold", 32));
        arcadeScoreValue.setTextFill(Color.web("#00FFFF", 1)); //Aqua color


        ImageView menu = new ImageView(imageGetter.getBack().getImage());
        menu.setScaleX(0.21);
        menu.setScaleY(0.21);
        menu.setX(-100);
        menu.setY(350);
        menu.setRotate(180);
        menu.setOnMouseClicked(e -> {

            this.menu.start();

        });



        root.getChildren().addAll(bg,classicHighScore,classicScoreValue,arcadeHighScore,arcadeScoreValue,menu);

    }
}