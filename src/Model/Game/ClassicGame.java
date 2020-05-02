package Model.Game;

import Model.GameObjects.GameObject;
import Model.GameObjects.GameObjectFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
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

    public void saveHighScore()
    {
        try {
            File xmlFile = new File("Scores.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            DOMSource source = new DOMSource(doc);


            NodeList Scores = doc.getElementsByTagName("Classic");

            for (int i = 0; i < Scores.getLength(); i++)
            {

                Node scoresValues = Scores.item(i);

                Element element = (Element) scoresValues;



                element.getElementsByTagName("classicHighScore").item(0).setTextContent(""+highScore);

            }


            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            StreamResult file = new StreamResult(new File("Scores.xml"));
            transformer.transform(source, file);


        }catch(Exception e) {System.out.println("Error in saving !");}
    }


    public void loadHighScore()
    {
        try {
            File xmlFile = new File("Scores.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            DOMSource source = new DOMSource(doc);


            NodeList Scores = doc.getElementsByTagName("Classic");

            for (int i = 0; i < Scores.getLength(); i++)
            {

                Node scoresValues = Scores.item(i);

                Element element = (Element) scoresValues;

               highScore= Integer.parseInt (element.getElementsByTagName("classicHighScore").item(0).getTextContent());

            }


            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            StreamResult file = new StreamResult(new File("Scores.xml"));
            transformer.transform(source, file);


        }catch(Exception e) {System.out.println("Error in reading !");}
    }




}
