package View;

import Model.GameObjects.Apple;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
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

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class ClassicGame {
Stage classicGameStage;
Menu menu;






    public ClassicGame(Stage classicGameStage) {
        this.classicGameStage = classicGameStage;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void start()
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

        Label classicScore = new Label("Score: ");
        classicScore.setLayoutX(50);
        classicScore.setLayoutY(50);
        classicScore.setFont(new Font("Arial Bold", 25));
        classicScore.setTextFill(Color.web("#FFFF00", 1)); //Yellow color

        Label classicScoreValue = new Label("0");
        classicScoreValue.setLayoutX(150);
        classicScoreValue.setLayoutY(50);
        classicScoreValue.setFont(new Font("Arial Bold", 26));
        classicScoreValue.setTextFill(Color.web("#FF6347", 1)); //Tomato color

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

        root.getChildren().addAll(bg);
        createObject(root);
        root.getChildren().addAll(path,classicScore,classicScoreValue,firstLive,secondLive,thirdLive);

    }


    private void createObject(Pane root) {

        Random random=new Random();
       for(int i=0;i<6;i++)  {
            Image greenApple = new Image("file:Fruit_Ninja_Materials/Fruits/Green_Apple.png");      //read pic
            Image slicedGreenApple = new Image("file:Fruit_Ninja_Materials/Fruits/SlicedGreenApple.png");
            ImageView Apple = new ImageView(greenApple);        //view pic
            Apple.setScaleX(2.8);           //size
            Apple.setScaleY(2.8);           //size



            Apple.setX(random.nextInt(1000));                //start position =======adjust



            Apple.setY(750);                //start position
           int randomHeight;
            randomHeight=random.nextInt(700)+300;
            Duration duration = Duration.millis(randomHeight);   //time fruit goes up and down =======adjust here
            TranslateTransition transition = new TranslateTransition(duration, Apple);
            transition.setByX(0);//



           int randomY=-700;

            transition.setByY(randomY);    //max height ============adjust here
           randomY=-700+300;

            // mtl3b4 hna
            duration = Duration.millis(10000);
            RotateTransition rotateTransition = new RotateTransition(duration, Apple);
            rotateTransition.setByAngle(500);
            rotateTransition.play();
            transition.setAutoReverse(true);
            transition.setRate(0.5);
            transition.setCycleCount(2);
            transition.play();

            Apple.setOnMouseMoved(e -> Apple.setImage(slicedGreenApple));

            root.getChildren().add(Apple);
        }
    }

}
