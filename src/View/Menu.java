package View;

import Control.ClassicLogic;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;

public class Menu {

Stage menuStage;
HighScoresGui highScores;
Boolean songIsPlaying=false;

ClassicGameGui classicGameGui;
ImageGetter logic= ImageGetter.createImageGetter();
ClassicLogic classicLogic=ClassicLogic.createClassicLogic();
    String musicFile="FruitNinjaAudio\\MenuMusic.mp3";
    Media mediaPlayer=new Media(new File(musicFile).toURI().toString());
    MediaPlayer mediaPlayer1=new MediaPlayer(mediaPlayer);


    public Menu(Stage menuStage, HighScoresGui highScores, ClassicGameGui classicGame) {
        this.menuStage = menuStage;
        this.highScores = highScores;
        this.classicGameGui = classicGame;
    }

    public void start() {


        if (!songIsPlaying)
        {
            songIsPlaying=true;
            mediaPlayer1.setCycleCount(MediaPlayer.INDEFINITE);
            mediaPlayer1.play();
    }
        menuStage.setTitle("Fruit Ninja");
        menuStage.centerOnScreen();
        menuStage.setResizable(false);
        Pane root = new Pane();
        Scene scene = new Scene(root,1000,650);
        menuStage.setScene(scene);
        menuStage.show();



        ImageView bg = new ImageView(logic.getBackground().getImage());


        ImageView title = new ImageView(logic.getLogo().getImage());
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



        ImageView quit = new ImageView(logic.getExit().getImage());
        quit.setScaleX(0.21);
        quit.setScaleY(0.21);
        quit.setX(250);
        quit.setY(350);
        quit.setOnMouseClicked(e -> System.exit(0));


        ImageView classic = new ImageView(logic.getStartClassic().getImage());
        classic.setScaleX(1.8);
        classic.setScaleY(1.8);
        classic.setX(300);
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

        classic.setOnMouseClicked(e->{
            mediaPlayer1.stop();
            songIsPlaying=false;
            classicLogic.startGame();
            classicGameGui.start();

        });



        ImageView HS = new ImageView(logic.getHighScore().getImage());
        HS.setScaleX(0.4);
        HS.setScaleY(0.4);
        HS.setX(400);
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


        ImageView man = new ImageView(logic.getNinjaMan().getImage());
        man.setScaleX(0.25);
        man.setScaleY(0.25);
        man.setX(-150);
        man.setY(100);


        root.getChildren().addAll(bg,quit,classic,HS,man,path,title);
    }




}
