package View;

import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Menu {

Stage menuStage;
HighScores highScores;
ArcadeGame arcadeGame;
ClassicGame classicGame;


    public Menu(Stage menuStage, HighScores highScores, ArcadeGame arcadeGame, ClassicGame classicGame) {
        this.menuStage = menuStage;
        this.highScores = highScores;
        this.arcadeGame = arcadeGame;
        this.classicGame = classicGame;
    }

    public void start()
    {

        menuStage.setTitle("Fruit Ninja");
        menuStage.centerOnScreen();
        menuStage.setResizable(false);
        Pane root = new Pane();
        Scene scene = new Scene(root,1000,650);
        menuStage.setScene(scene);
        menuStage.show();


        Image background = new Image("file:Fruit_Ninja_Materials/Background.jpg");
        ImageView bg = new ImageView(background);

        Image logo = new Image("file:Fruit_Ninja_Materials/logo.png");
        ImageView title = new ImageView(logo);
        title.setScaleX(0.4);
        title.setScaleY(0.4);
        title.setX(-300);
        title.setY(-100);

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


        Image exit = new Image("file:Fruit_Ninja_Materials/exit.png");
        ImageView quit = new ImageView(exit);
        quit.setScaleX(0.21);
        quit.setScaleY(0.21);
        quit.setX(250);
        quit.setY(350);
        quit.setOnMouseClicked(e -> System.exit(0));

        Image startClassic = new Image("file:Fruit_Ninja_Materials/classic.png");
        ImageView classic = new ImageView(startClassic);
        classic.setScaleX(1.8);
        classic.setScaleY(1.8);
        classic.setX(480);
        classic.setY(400);

        Duration duration = Duration.millis(10000);
        RotateTransition rotateTransition = new RotateTransition(duration, classic);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(Timeline.INDEFINITE);
        rotateTransition.play();

        Duration duration2 = Duration.millis(600);
        ScaleTransition scaleTransition = new ScaleTransition(duration2, classic);
        scaleTransition.setByX(0.3);
        scaleTransition.setByY(0.3);
        scaleTransition.setAutoReverse(true);
        scaleTransition.setCycleCount(Timeline.INDEFINITE);
        scaleTransition.play();

        classic.setOnMouseClicked(e->classicGame.start());

        Image startArcade = new Image("file:Fruit_Ninja_Materials/arcade.png");
        ImageView arcade = new ImageView(startArcade);
        arcade.setScaleX(1.8);
        arcade.setScaleY(1.8);
        arcade.setX(250);
        arcade.setY(400);
        Duration duration3 = Duration.millis(10000);
        RotateTransition rotateTransition2 = new RotateTransition(duration3, arcade);
        rotateTransition2.setByAngle(360);
        rotateTransition2.setCycleCount(Timeline.INDEFINITE);
        rotateTransition2.play();

        Duration duration4 = Duration.millis(600);
        ScaleTransition scaleTransition2 = new ScaleTransition(duration4, arcade);
        scaleTransition2.setByX(0.3);
        scaleTransition2.setByY(0.3);
        scaleTransition2.setAutoReverse(true);
        scaleTransition2.setCycleCount(Timeline.INDEFINITE);
        scaleTransition2.play();

        arcade.setOnMouseClicked(e -> {

            arcadeGame.start();


        });

        Image highScore = new Image("file:Fruit_Ninja_Materials/HS.png");
        ImageView HS = new ImageView(highScore);
        HS.setScaleX(0.4);
        HS.setScaleY(0.4);
        HS.setX(580);
        HS.setY(280);
        Duration duration5 = Duration.millis(1000);
        ScaleTransition scaleTransition3 = new ScaleTransition(duration5, HS);
        scaleTransition3.setByX(0.07);
        scaleTransition3.setByY(0.07);
        scaleTransition3.setAutoReverse(true);
        scaleTransition3.setCycleCount(Timeline.INDEFINITE);
        scaleTransition3.play();

        HS.setOnMouseClicked(e -> {

            highScores.start();


        });

        Image ninjaMan = new Image("file:Fruit_Ninja_Materials/man.png");
        ImageView man = new ImageView(ninjaMan);
        man.setScaleX(0.25);
        man.setScaleY(0.25);
        man.setX(-150);
        man.setY(100);


        root.getChildren().addAll(bg,quit,classic,arcade,HS,man,path,title);
    }




}
