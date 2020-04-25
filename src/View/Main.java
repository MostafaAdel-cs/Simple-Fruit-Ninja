package View;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.ArrayList;


public class Main extends Application {





    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BufferedImage background=new BufferedImage("background",new Image("file:Fruit_Ninja_Materials/Background.jpg"));
        BufferedImage logo=new BufferedImage("logo",new Image("file:Fruit_Ninja_Materials/logo.png"));
        BufferedImage exit=new BufferedImage("exit",new Image("file:Fruit_Ninja_Materials/exit.png"));
        BufferedImage startClassic=new BufferedImage("startClassic",new Image("file:Fruit_Ninja_Materials/Classic.png"));
        BufferedImage startArcade=new BufferedImage("startArcade",new Image("file:Fruit_Ninja_Materials/Arcade.png"));
        BufferedImage highScore =new BufferedImage("highScore",new Image("file:Fruit_Ninja_Materials/HS.png"));
        BufferedImage ninjaMan =new BufferedImage("ninjaMan",new Image("file:Fruit_Ninja_Materials/man.png"));





        Menu menu = new Menu(background,logo,exit,startClassic,startArcade,highScore,ninjaMan);
        menu.start(primaryStage);
    }


}
