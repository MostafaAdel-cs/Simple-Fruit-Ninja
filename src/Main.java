
import Control.ClassicLogic;
import Control.Logic;
import View.ArcadeGame;
import View.ClassicGame;
import View.HighScores;
import View.Menu;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {





    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ClassicLogic classicLogic=new ClassicLogic();

        ArcadeGame arcadeGame=new ArcadeGame(primaryStage);
        ClassicGame classicGame=new ClassicGame(primaryStage);
        HighScores highScores=new HighScores(primaryStage);


        Menu menu = new Menu(primaryStage,highScores,arcadeGame,classicGame);

        arcadeGame.setMenu(menu);
        classicGame.setMenu(menu);

        highScores.setMenu(menu);

        menu.start();
    }


}
