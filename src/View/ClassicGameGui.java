package View;

import Control.ClassicLogic;
import Model.Game.ClassicGame;
import Model.GameObjects.GameObject;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClassicGameGui {
private Stage classicGameStage;
private Menu menu;
private ImageGetter imageGetter=ImageGetter.createImageGetter();
private ClassicLogic classicLogic=ClassicLogic.createClassicLogic();






    public ClassicGameGui(Stage classicGameStage) {
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


        ImageView bg = new ImageView(imageGetter.getBackground().getImage());

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



        ImageView firstLive = new ImageView(imageGetter.getHeart().getImage());
        firstLive.setScaleX(0.22);
        firstLive.setScaleY(0.22);
        firstLive.setX(650);
        firstLive.setY(-70);


        ImageView secondLive = new ImageView(imageGetter.getHeart().getImage());
        secondLive.setScaleX(0.22);
        secondLive.setScaleY(0.22);
        secondLive.setX(700);
        secondLive.setY(-70);


        ImageView thirdLive = new ImageView(imageGetter.getHeart().getImage());
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
        createObject(root,firstLive,secondLive,thirdLive);
        root.getChildren().addAll(path,classicScore,classicScoreValue,firstLive,secondLive,thirdLive);


    }




    private void createObject(Pane root,ImageView firstHeart,ImageView secondHeart,ImageView thirdHeart) {

        Random random = new Random();

        List<GameObject> gameObjectList=new ArrayList();
        int numberOfFruits=classicLogic.getNumberOfFruitsInWave();
        for (int i=0;i<numberOfFruits;i++) {


            gameObjectList.add(classicLogic.getRandomFruit());

            ImageView object = new ImageView(gameObjectList.get(i).getUnCutBufferedImageImages().getImage());        //view pic
            object.setScaleX(2.8);           //size
            object.setScaleY(2.8);           //size


            object.setX(random.nextInt(1000));                //start position =======adjust

            object.setY(750);                //start position


            Duration duration = Duration.millis(2000);   //time fruit goes up and down =======adjust here


            TranslateTransition transition = new TranslateTransition(duration, object);
            transition.setByX(0);//


            transition.setByY(random.nextInt(700) - 1000);    //max height ============adjust here


            // mtl3b4 hna
            duration = Duration.millis(10000);
            RotateTransition rotateTransition = new RotateTransition(duration, object);
            rotateTransition.setByAngle(500);
            rotateTransition.play();
            transition.setAutoReverse(true);
            transition.setRate(0.5);
            transition.setCycleCount(2);

            //to know when the object falls down is it cut or not
            transition.setOnFinished(e -> {

            });


            transition.play();
            final boolean[] l = {false};
            int finalI = i;
            object.setOnMouseMoved(e -> {

                object.setImage(gameObjectList.get(finalI).getCutBufferedImageImages().getImage());

                if(!l[0]) {
                    classicLogic.addScore();
                }
                l[0] =true;

            });


            transition.setOnFinished(e->
            {
                if(object.getImage()==gameObjectList.get(finalI).getUnCutBufferedImageImages().getImage())
                {
                    classicLogic.removeLive();
                    adjustHearts(firstHeart,secondHeart,thirdHeart);
                }
            });

            root.getChildren().add(object);


        }


    }

    private void adjustHearts(ImageView firstHeart,ImageView secondHeart,ImageView thirdHeart)
    {
        if(classicLogic.getLives()==1)
        {
            secondHeart.setVisible(false);
            thirdHeart.setVisible(false);
        }
        else if(classicLogic.getLives()==2)
        {
            thirdHeart.setVisible(false);
        }



    }
    private void editScoreLabel()
    {

    }


}
