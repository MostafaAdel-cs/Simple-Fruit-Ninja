package View;

import javafx.animation.KeyFrame;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Glow;
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

public class ArcadeGame {


    Stage arcadeGameStage;
    Menu menu;

    public ArcadeGame(Stage arcadeGameStage) {
        this.arcadeGameStage = arcadeGameStage;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    private final Integer startTime = 60;
    private Integer seconds = startTime;
    private Label timerLabel = new Label();

    private void doTime()
    {
        timerLabel.setLayoutX(760);
        timerLabel.setLayoutY(50);
        timerLabel.setFont(new Font("Arial Bold", 30));
        timerLabel.setTextFill(Color.web("#00FFFF", 1)); //Cyan color

        Timeline time = new Timeline();
        time.setCycleCount(Timeline.INDEFINITE);

        if(time!=null)
        {
            time.stop();
        }

        KeyFrame frame = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                seconds--;
                timerLabel.setText("Timer: "+seconds.toString());

                if(seconds<=0)
                {
                    time.stop();
                }

            }
        });


        time.getKeyFrames().add(frame);
        time.playFromStart();
    }

    public void start()
    {
        arcadeGameStage.setTitle("Fruit Ninja");
        arcadeGameStage.centerOnScreen();
        arcadeGameStage.setResizable(false);
        Pane root = new Pane();
        Scene scene = new Scene(root,1000,650);
        arcadeGameStage.setScene(scene);
        arcadeGameStage.show();

        Image background = new Image("file:Fruit_Ninja_Materials/Background.jpg");
        ImageView bg = new ImageView(background);

        Label arcadeScore = new Label("Score: ");
        arcadeScore.setLayoutX(50);
        arcadeScore.setLayoutY(50);
        arcadeScore.setFont(new Font("Arial Bold", 25));
        arcadeScore.setTextFill(Color.web("#FFFF00", 1)); //Yellow color

        Label arcadeScoreValue = new Label("0");
        arcadeScoreValue.setLayoutX(150);
        arcadeScoreValue.setLayoutY(50);
        arcadeScoreValue.setFont(new Font("Arial Bold", 26));
        arcadeScoreValue.setTextFill(Color.web("#FF6347", 1)); //Tomato color

        doTime(); //SET TIMER

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
        Effect glow = new Glow(1.0);
        path.setEffect(glow);

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


        root.getChildren().addAll(bg,Apple,Watermelon,Banana,Orange,path,arcadeScore,arcadeScoreValue,timerLabel);
    }
}
