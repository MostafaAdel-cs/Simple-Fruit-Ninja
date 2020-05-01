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

public class ArcadeGameGui {


    Stage arcadeGameStage=new Stage();
    Stage mainStage;
    ArcadeGameOverGui arcadeGameOverGui;
    ImageGetter imageGetter=ImageGetter.createImageGetter();

    public ArcadeGameGui(Stage mainStage) {
        this.mainStage = mainStage;
    }

    public void setArcadeGameOverGui(ArcadeGameOverGui arcadeGameOverGui) {
        this.arcadeGameOverGui = arcadeGameOverGui;
    }

    private final Integer startTime = 5;
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

                if(seconds==0)
                {
                    arcadeGameStage.close();
                    arcadeGameOverGui.start();

                }

            }
        });


        time.getKeyFrames().add(frame);
        time.playFromStart();
    }

    public void start()
    {
        mainStage.hide();
        arcadeGameStage.setTitle("Fruit Ninja");
        arcadeGameStage.centerOnScreen();
        arcadeGameStage.setResizable(false);
        Pane root = new Pane();
        Scene scene = new Scene(root,1000,650);
        arcadeGameStage.setScene(scene);
        arcadeGameStage.show();


        ImageView bg = new ImageView(imageGetter.getBackground().getImage());

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

        root.getChildren().addAll(bg,arcadeScore,arcadeScoreValue,timerLabel);
    }

}
