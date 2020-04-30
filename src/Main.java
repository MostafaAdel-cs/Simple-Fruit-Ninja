
import View.*;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {





    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {




        ArcadeGameGui arcadeGame=new ArcadeGameGui(primaryStage);
        ClassicGameGui classicGame=new ClassicGameGui(primaryStage);
        HighScoresGui highScores=new HighScoresGui(primaryStage);


        Menu menu = new Menu(primaryStage,highScores,arcadeGame,classicGame);

        arcadeGame.setMenu(menu);
        classicGame.setMenu(menu);

        highScores.setMenu(menu);

        menu.start();
    }


}
