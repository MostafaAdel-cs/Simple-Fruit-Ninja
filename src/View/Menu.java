package View;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Menu {


    public void start(Stage menuStage)
    {

        menuStage.setTitle("Fruit Ninja");
        menuStage.centerOnScreen();
        menuStage.setResizable(false);
        Pane root = new Pane();

        Image background = new Image("file:Fruit_Ninja_Materials/Background.jpg");
        ImageView bg = new ImageView(background);

        Image logo = new Image("file:Fruit_Ninja_Materials/logo.png");
        ImageView title = new ImageView(logo);
        title.setScaleX(0.4);
        title.setScaleY(0.4);
        title.setX(-300);
        title.setY(-100);

        Image exit = new Image("file:Fruit_Ninja_Materials/exit.png");
        ImageView quit = new ImageView(exit);
        quit.setScaleX(0.21);
        quit.setScaleY(0.21);
        quit.setX(250);
        quit.setY(350);
        quit.setOnMouseClicked(e -> System.exit(0));

        Image startClassic = new Image("file:Fruit_Ninja_Materials/Classic.png");
        ImageView Classic = new ImageView(startClassic);
        Classic.setScaleX(1.8);
        Classic.setScaleY(1.8);
        Classic.setX(480);
        Classic.setY(400);

        Image startArcade = new Image("file:Fruit_Ninja_Materials/Arcade.png");
        ImageView Arcade = new ImageView(startArcade);
        Arcade.setScaleX(1.8);
        Arcade.setScaleY(1.8);
        Arcade.setX(250);
        Arcade.setY(400);

        Image highScore = new Image("file:Fruit_Ninja_Materials/HS.png");
        ImageView HS = new ImageView(highScore);
        HS.setScaleX(0.4);
        HS.setScaleY(0.4);
        HS.setX(580);
        HS.setY(280);

        Image ninjaMan = new Image("file:Fruit_Ninja_Materials/man.png");
        ImageView man = new ImageView(ninjaMan);
        man.setScaleX(0.25);
        man.setScaleY(0.25);
        man.setX(-150);
        man.setY(100);

        Scene scene = new Scene(root,1000,650);
        menuStage.setScene(scene);
        menuStage.show();


        root.getChildren().addAll(bg,title,quit,Classic,Arcade,HS,man);
    }

}
