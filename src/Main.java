
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
        ArcadeGameGui arcadeGame=new ArcadeGameGui(primaryStage);
        ClassicGameGui classicGame=new ClassicGameGui(primaryStage);
        HighScoresGui highScores=new HighScoresGui(primaryStage);
        ArcadeGameOverGui arcadeGameOverGui=new ArcadeGameOverGui(primaryStage);

        Menu menu = new Menu(primaryStage,highScores,arcadeGame,classicGame);
        classicGameOverGui.setMenu(menu);
        arcadeGame.setArcadeGameOverGui(arcadeGameOverGui);
        classicGame.setMenu(menu);
        classicGame.setClassicGameOverGui(classicGameOverGui);
        highScores.setMenu(menu);
        arcadeGameOverGui.setMenu(menu);

        menu.start();
    }


}
