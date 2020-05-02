package Control;

import Model.Game.ClassicGame;
import Model.GameObjects.GameObject;
import Model.GameObjects.GameObjectFactory;

import javax.xml.bind.JAXBException;
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


public void allLivesLost()
{
    game.allLivesLost();
}
    ClassicGame game=ClassicGame.getClassicGame();

    public void resetGame()
    {
        game.resetGame();
    }

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
    public GameObject getRandomFruit(Boolean getBomb)
    {
     return gameObjectFactory.createRandomFruit(game.getLevel(),getBomb);
    }

    public void removeLive()
    {
        game.minusLives(1);
    }


    public int getLevel() {
        return game.getLevel();
    }
    public void fruitSliced()
    {
        game.decrementNumberOfFruits();
    }

    public int getHighScore()
    {
        return game.getHighScore();
    }
    public void setHighScore( int currentScore)
    {
        if(currentScore>game.getHighScore())
        {
            game.setHighScore(currentScore);
            game.saveHighScore();
        }
    }
    public void loadHighScore()
    {
        game.loadHighScore();
    }




}
