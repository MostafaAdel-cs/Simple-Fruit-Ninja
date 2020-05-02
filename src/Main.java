
import Control.ClassicLogic;
import View.*;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {





    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {



        ClassicGameOverGui classicGameOverGui=new ClassicGameOverGui(primaryStage);

        ClassicGameGui classicGame=new ClassicGameGui(primaryStage);
        HighScoresGui highScores=new HighScoresGui(primaryStage);
        ClassicLogic classicLogic=ClassicLogic.createClassicLogic();
        classicLogic.loadHighScore();

        Menu menu = new Menu(primaryStage,highScores,classicGame);
        classicGameOverGui.setMenu(menu);

        classicGame.setMenu(menu);
        classicGame.setClassicGameOverGui(classicGameOverGui);
        highScores.setMenu(menu);


        menu.start();
    }


}
