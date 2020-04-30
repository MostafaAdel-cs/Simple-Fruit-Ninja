package Model.GameObjects;

import Model.Game.ClassicGame;
import View.BufferedImage;
import javafx.scene.image.Image;


import java.util.ArrayList;
import java.util.Random;

public abstract class GameObject {
    private String name;
    private int xLocation;
    private int maxHeight;
    private int time; //in milliseconds
    private int gameLevel;


    private BufferedImage unCutBufferedImage;
    private BufferedImage cutBufferedImage;

    public GameObject(String name, Image imageUncut,Image imageCut )
    {
        Random random=new Random();
        unCutBufferedImage=new BufferedImage(name+"Uncut",imageUncut);
        cutBufferedImage=new BufferedImage(name+"Cut",imageCut);
        this.name=name;
        xLocation = random.nextInt(1000);
        maxHeight=-random.nextInt(1000)+(gameLevel*50);
        time=random.nextInt(500)+500-(gameLevel-1)*50;
    }

    public int getXLocation() {
        return xLocation;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public int getTime() {
        return time;
    }

    public BufferedImage getCutBufferedImageImages()
    {

        return cutBufferedImage;
    }
    public BufferedImage getUnCutBufferedImageImages()
    {

        return unCutBufferedImage;
    }


}
