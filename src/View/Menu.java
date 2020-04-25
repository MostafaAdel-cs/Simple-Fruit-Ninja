package View;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Menu {

    BufferedImage background;
    BufferedImage logo;
    BufferedImage exit;
    BufferedImage startClassic;
    BufferedImage startArcade;
    BufferedImage highScore;
    BufferedImage ninjaMan;


    public Menu(BufferedImage background, BufferedImage logo, BufferedImage exit, BufferedImage startClassic, BufferedImage startArcade, BufferedImage highScore, BufferedImage ninjaMan) {

        this.background = background;
        this.logo = logo;
        this.exit = exit;
        this.startClassic = startClassic;
        this.startArcade = startArcade;
        this.highScore = highScore;
        this.ninjaMan = ninjaMan;
    }

    public void start(Stage menuStage)
    {

        menuStage.setTitle("Fruit Ninja");
        menuStage.centerOnScreen();
        menuStage.setResizable(false);
        Pane root = new Pane();


        ImageView bg = new ImageView(background.getImage());

        Image logo = new Image("file:Fruit_Ninja_Materials/logo.png");
        ImageView title = new ImageView(logo);
        title.setScaleX(0.4);
        title.setScaleY(0.4);
        title.setX(-300);
        title.setY(-100);


        ImageView quit = new ImageView(exit.getImage());
        quit.setScaleX(0.21);
        quit.setScaleY(0.21);
        quit.setX(250);
        quit.setY(350);
        quit.setOnMouseClicked(e -> System.exit(0));

        ImageView Classic = new ImageView(startClassic.getImage());
        Classic.setScaleX(1.8);
        Classic.setScaleY(1.8);
        Classic.setX(480);
        Classic.setY(400);


        ImageView Arcade = new ImageView(startArcade.getImage());
        Arcade.setScaleX(1.8);
        Arcade.setScaleY(1.8);
        Arcade.setX(250);
        Arcade.setY(400);


        ImageView HS = new ImageView(highScore.getImage());
        HS.setScaleX(0.4);
        HS.setScaleY(0.4);
        HS.setX(580);
        HS.setY(280);


        ImageView man = new ImageView(ninjaMan.getImage());
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
