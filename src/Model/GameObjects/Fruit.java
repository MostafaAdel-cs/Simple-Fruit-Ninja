package Model.GameObjects;

import View.BufferedImage;
import javafx.scene.image.Image;


import java.nio.Buffer;

public class Fruit extends GameObject {

    public Fruit(String name, Image unCut, Image cut,int gameLevel) {
        super(name,unCut,cut,gameLevel);
    }
}
