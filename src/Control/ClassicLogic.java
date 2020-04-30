package Control;

import Model.Game.ClassicGame;
import Model.GameObjects.GameObject;
import Model.GameObjects.GameObjectFactory;

import java.util.Random;

public class ClassicLogic {


    private static ClassicLogic instance;

    private GameObjectFactory gameObjectFactory=GameObjectFactory.createObjectFactory();

    private ClassicLogic() {
    }
    public static ClassicLogic createClassicLogic()
    {
        if(instance==null)
            instance=new ClassicLogic();
        return instance;
    }



    ClassicGame game=ClassicGame.getClassicGame();


    public void startGame()
    {
        game.startGame();
    }

    public int getLives()
    {
        return game.getLives();
    }


    public int getNumberOfFruitsInWave()
    {
        int n=game.getNumberInWave();
        return n;
    }

    public void addScore()
    {
        game.addScore(1);
    }
    public int getScore()
    {
        return game.getScore();
    }
    public GameObject getRandomFruit()
    {
     return gameObjectFactory.createRandomFruit();
    }

    public void removeLive()
    {
        game.minusLives(1);
    }


}
