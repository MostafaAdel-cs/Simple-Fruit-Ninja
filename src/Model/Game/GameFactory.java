package Model.Game;

public class GameFactory {
    private GameFactory instance;

    private GameFactory()
    {

    }
    public GameFactory createGameFactory(){
        if(instance==null)
        {
            instance=new GameFactory();
        }
        return instance;
    }

    public GameActions createGame(String gameName)
    {
        if(gameName.contentEquals("Arcade"))
            return new ArcadeGame();
        else if(gameName.contentEquals("Classic"))
            return new ClassicGame();

        return null;
    }
}
