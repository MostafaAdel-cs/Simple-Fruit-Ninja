package Model.Game;

import Model.GameObjects.GameObject;

public interface GameActions {

    public GameObject createGameObject(); //to create the object

    public void updateObjectsLocation(); //to update moving objects location

    public void sliceObjects();

    public void saveGame();

    public void loadGame();

    public void resetGame();

}
