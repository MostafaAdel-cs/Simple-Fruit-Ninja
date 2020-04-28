package Model.Game;

import Model.GameObjects.GameObject;

import java.util.Random;

public class ClassicGame implements GameActions{
    private int lives;
    private int level;
    private int numberOfFruits;
    private boolean flag;



    @Override
    public void startGame() {
   lives=3;
   level=1;
   flag=false;

    }


    @Override
    public void saveGame() {

    }

    @Override
    public void loadGame() {

    }

    @Override
    public void resetGame() {
    startGame();
    }

    public int getNumberOfFruits()
    {
        Random r=new Random();
        if(!flag) {
            numberOfFruits = r.nextInt(level * 20) + level * 5;
            flag=true;
        }
        return numberOfFruits;
    }
    public void levelUp()
    {
        level++;
        flag=false;
        getNumberOfFruits();
    }

    public void minusLives(int lives)
    {
        this.lives-=lives;
    }

    public int getLives() {
        return lives;
    }

    public int getLevel() {
        return level;
    }

}
