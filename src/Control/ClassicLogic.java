package Control;

import Model.Game.ClassicGame;
import Model.Game.GameFactory;
import Model.GameObjects.GameObjectFactory;

public class ClassicLogic extends Logic{
    GameObjectFactory gameObjectFactory=new GameObjectFactory();
    GameFactory gameFactory=new GameFactory();
    ClassicGame game;

    public void startGame()
    {
        game= (ClassicGame) gameFactory.createGame("Classic");
        game.startGame();
    }
    public int getNumberOfFruits()
    {
        return game.getNumberOfFruits();
    }

    public void levelUp()
    {
        game.levelUp();
    }






}
