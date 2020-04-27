package View;

import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class classicGame {

    public void start(Stage classicGameStage)
    {
        classicGameStage.setTitle("Fruit Ninja");
        classicGameStage.centerOnScreen();
        classicGameStage.setResizable(false);
        Pane root = new Pane();
        Scene scene = new Scene(root,1000,650);
        classicGameStage.setScene(scene);
        classicGameStage.show();

        Image background = new Image("file:Fruit_Ninja_Materials/Background.jpg");
        ImageView bg = new ImageView(background);

        Label highScore = new Label("High Score: ");
        highScore.setLayoutX(50);
        highScore.setLayoutY(50);
        highScore.setFont(new Font("Arial Bold", 25));
        highScore.setTextFill(Color.web("#FFFF00", 1)); //Yellow color

        Label highScoreValue = new Label("0");
        highScoreValue.setLayoutX(200);
        highScoreValue.setLayoutY(50);
        highScoreValue.setFont(new Font("Arial Bold", 26));
        highScoreValue.setTextFill(Color.web("#FF6347", 1)); //Tomato color

        Image heart1 = new Image("file:Fruit_Ninja_Materials/Heart.png");
        ImageView firstLive = new ImageView(heart1);
        firstLive.setScaleX(0.22);
        firstLive.setScaleY(0.22);
        firstLive.setX(650);
        firstLive.setY(-70);

        Image heart2 = new Image("file:Fruit_Ninja_Materials/Heart.png");
        ImageView secondLive = new ImageView(heart2);
        secondLive.setScaleX(0.22);
        secondLive.setScaleY(0.22);
        secondLive.setX(700);
        secondLive.setY(-70);

        Image heart3 = new Image("file:Fruit_Ninja_Materials/Heart.png");
        ImageView thirdLive = new ImageView(heart3);
        thirdLive.setScaleX(0.22);
        thirdLive.setScaleY(0.22);
        thirdLive.setX(750);
        thirdLive.setY(-70);

        Image greenApple = new Image("file:Fruit_Ninja_Materials/Fruits/Green_Apple.png");
        Image slicedGreenApple = new Image("file:Fruit_Ninja_Materials/Fruits/SlicedGreenApple.png");
        ImageView Apple = new ImageView(greenApple);
        Apple.setScaleX(2.8);
        Apple.setScaleY(2.8);
        Apple.setX(200);
        Apple.setY(750);

        Image watermelon = new Image("file:Fruit_Ninja_Materials/Fruits/Watermelon.png");
        ImageView Watermelon = new ImageView(watermelon);
        Image slicedWatermelon = new Image("file:Fruit_Ninja_Materials/Fruits/SlicedWatermelon.png");
        Watermelon.setScaleX(2.8);
        Watermelon.setScaleY(2.8);
        Watermelon.setX(400);
        Watermelon.setY(750);

        Image banana = new Image("file:Fruit_Ninja_Materials/Fruits/Banana.png");
        ImageView Banana = new ImageView(banana);
        Image slicedBanana = new Image("file:Fruit_Ninja_Materials/Fruits/SlicedBanana.png");
        Banana.setScaleX(2.8);
        Banana.setScaleY(2.8);
        Banana.setX(500);
        Banana.setY(750);

        Image orange = new Image("file:Fruit_Ninja_Materials/Fruits/Orange.png");
        ImageView Orange = new ImageView(orange);
        Image slicedOrange = new Image("file:Fruit_Ninja_Materials/Fruits/SlicedOrange.png");
        Orange.setScaleX(2.8);
        Orange.setScaleY(2.8);
        Orange.setX(800);
        Orange.setY(750);


        Duration duration = Duration.millis(700);
        TranslateTransition transition = new TranslateTransition(duration,Apple);
        transition.setByX(0);
        transition.setByY(-700);
        duration = Duration.millis(10000);
        RotateTransition rotateTransition = new RotateTransition(duration, Apple);
        rotateTransition.setByAngle(500);
        rotateTransition.play();
        transition.setAutoReverse(true);
        transition.setRate(0.5);
        transition.setCycleCount(2);
        transition.play();

        Duration duration2 = Duration.millis(1000);
        TranslateTransition transition2 = new TranslateTransition(duration2,Watermelon);
        transition2.setByX(0);
        transition2.setByY(-700);
        duration2 = Duration.millis(10000);
        RotateTransition rotateTransition2 = new RotateTransition(duration2, Watermelon);
        rotateTransition2.setByAngle(500);
        rotateTransition2.play();
        transition2.setAutoReverse(true);
        transition2.setRate(0.5);
        transition2.setCycleCount(2);
        transition2.play();

        Duration duration3 = Duration.millis(900);
        TranslateTransition transition3 = new TranslateTransition(duration3,Banana);
        transition3.setByX(0);
        transition3.setByY(-700);
        duration3 = Duration.millis(10000);
        RotateTransition rotateTransition3 = new RotateTransition(duration3, Banana);
        rotateTransition3.setByAngle(500);
        rotateTransition3.play();
        transition3.setAutoReverse(true);
        transition3.setRate(0.5);
        transition3.setCycleCount(2);
        transition3.play();

        Duration duration4 = Duration.millis(800);
        TranslateTransition transition4 = new TranslateTransition(duration4,Orange);
        transition4.setByX(0);
        transition4.setByY(-700);
        duration4 = Duration.millis(10000);
        RotateTransition rotateTransition4 = new RotateTransition(duration4, Orange);
        rotateTransition4.setByAngle(500);
        rotateTransition4.play();
        transition4.setAutoReverse(true);
        transition4.setRate(0.5);
        transition4.setCycleCount(2);
        transition4.play();



        Path path = new Path();
        path.setStrokeWidth(2);
        path.setStroke(Color.YELLOW);

        EventHandler<MouseEvent> mouseHandler = new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getEventType() == MouseEvent.MOUSE_PRESSED) {
                    path.getElements().clear();
                    path.getElements().add(new MoveTo(mouseEvent.getX(), mouseEvent.getY()));

                }
                else if (mouseEvent.getEventType() == MouseEvent.MOUSE_DRAGGED) {
                    path.getElements().add(new LineTo(mouseEvent.getX(), mouseEvent.getY()));

                }
                else if (mouseEvent.getEventType() == MouseEvent.MOUSE_RELEASED) {
                    path.getElements().clear();
                    path.getElements().add(new MoveTo(mouseEvent.getX(), mouseEvent.getY()));
                }

            }

        };

        scene.setOnMouseClicked(mouseHandler);
        scene.setOnMouseDragged(mouseHandler);
        scene.setOnMouseEntered(mouseHandler);
        scene.setOnMouseExited(mouseHandler);
        scene.setOnMouseMoved(mouseHandler);
        scene.setOnMousePressed(mouseHandler);
        scene.setOnMouseReleased(mouseHandler);


        Apple.setOnMouseEntered(e -> Apple.setImage(slicedGreenApple));
        Watermelon.setOnMouseEntered(e -> Watermelon.setImage(slicedWatermelon));
        Banana.setOnMouseEntered(e -> Banana.setImage(slicedBanana));
        Orange.setOnMouseEntered(e -> Orange.setImage(slicedOrange));


        root.getChildren().addAll(bg,Apple,Watermelon,Banana,Orange,path,highScore,highScoreValue,firstLive,secondLive,thirdLive);
    }

}
