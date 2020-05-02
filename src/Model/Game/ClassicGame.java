package Model.Game;

import Model.GameObjects.GameObject;
import Model.GameObjects.GameObjectFactory;

import java.util.Random;

public class ClassicGame {

    private int highScore;



    private static ClassicGame instance;
    private ClassicGame() {
    }



    public static ClassicGame getClassicGame()
    {
        if(instance==null)
            instance=new ClassicGame();
        return instance;
    }




    private Random random=new Random();
    private int lives;
    private int level;
    private int numberOfFruitsInLevel;  //number of fruits  level
    private int score;




    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }



    public void startGame() {

        this.lives=3;
        this.level=1;
        this.numberOfFruitsInLevel=random.nextInt(20)+20;   //the minimum number of fruits in first level is 40 and max is 80
        this.score=0;
    }




    public int getNumberInWave()
    {

        int numberOfFruitsInWave;
        Random random=new Random();
        numberOfFruitsInWave=random.nextInt((level+3))+1;


        if(numberOfFruitsInWave>this.numberOfFruitsInLevel)
        {
            numberOfFruitsInWave=this.numberOfFruitsInLevel;
            levelUp();
        }

        this.numberOfFruitsInLevel-=numberOfFruitsInWave;

        return numberOfFruitsInWave;
    }





    public void resetGame() {
    startGame();
    }



    public void levelUp()
    {

        level++;
        numberOfFruitsInLevel=random.nextInt(20)+20*level;
    }

    public void minusLives(int lives)
    {
        if(lives!=0)
        this.lives-=lives;
    }
    public void allLivesLost()
    {
        this.lives=0;
    }

    public int getLives() {
        return lives;
    }

    public int getLevel() {
        return level;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int score) {
        this.score += score;
    }

    public void decrementNumberOfFruits()
    {
        numberOfFruitsInLevel--;
        if(numberOfFruitsInLevel==0)
            levelUp();
    }

}
