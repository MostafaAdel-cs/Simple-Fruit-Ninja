package View;

import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {

    Stage menuStage = new Stage();
    Menu menu = new Menu();


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        menu.start(menuStage);
    }


}
