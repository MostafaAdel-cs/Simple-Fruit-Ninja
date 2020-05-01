package Model.GameObjects;

import View.BufferedImage;
import javafx.scene.image.Image;

import java.util.Random;

public class GameObjectFactory {

    private static GameObjectFactory instance;


    private GameObjectFactory() {

    }

    public static GameObjectFactory createObjectFactory() {
        if(instance==null)
        {
            instance=new GameObjectFactory();
        }
        return instance;
    }


    //=============================================here are the images of the objects========================================================//
    private Image unCutApple=new  Image("file:Fruit_Ninja_Materials/Fruits/Green_Apple.png");
    private Image cutApple=new Image("file:Fruit_Ninja_Materials/Fruits/SlicedGreenApple.png");
    private Image uncutBomb=new Image("file:Fruit_Ninja_Materials/Fruits/-10_Bomb.png");
    private Image cutBomb=new Image("file:Fruit_Ninja_Materials/Fruits/-10_Bomb_Sliced.png");
    private Image unCutBanana=new Image("file:Fruit_Ninja_Materials/Fruits/Banana.png");
    private Image cutBanana=new Image("file:Fruit_Ninja_Materials/Fruits/SlicedBanana.png");
    private Image unCutWaterMelon=new Image("file:Fruit_Ninja_Materials/Fruits/Watermelon.png");
    private Image cutWaterMelon=new Image("file:Fruit_Ninja_Materials/Fruits/SlicedWatermelon.png");
    private Image specialBomb=new Image("file:Fruit_Ninja_Materials/Fruits/Bomb.png");
    private Image cutSpecialBomb=new Image("file:Fruit_Ninja_Materials/Fruits/Bomb.png");

    public GameObject createObject(String objectType,int gameLevel)
    {
        if(objectType.contentEquals("Apple"))
            return new Fruit("Apple",unCutApple,cutApple,gameLevel);
        else if(objectType.contentEquals("Bomb"))
            return new Bomb("Bomb",uncutBomb,cutBomb,gameLevel);
        else if(objectType.contentEquals("Banana"))
            return new Fruit("Banana",unCutBanana,cutBanana,gameLevel);
        else if(objectType.contentEquals("WaterMelon"))
            return new Fruit("WaterMelon",unCutWaterMelon,cutWaterMelon,gameLevel);
        else if(objectType.contentEquals("SpecialBomb"))
            return new Bomb("SpecialBomb",specialBomb,cutSpecialBomb,gameLevel);


        return null;
    }

    public GameObject createRandomFruit(int gameLevel,boolean getBomb)
    {
        Random r=new Random();
        if(getBomb==true) {
            if (r.nextInt(2) == 1)
                return createObject("Bomb", gameLevel);
            else
                return createObject("SpecialBomb", gameLevel);
        }

        int rm=r.nextInt(3)+1;
        if(rm==1)
        {
            return createObject("Apple",gameLevel);
        }
        else if(rm==2)
        {
            return createObject("Banana",gameLevel);
        }
        else if(rm==3)
        {
            return createObject("WaterMelon",gameLevel);
        }


        return null;
    }
}
