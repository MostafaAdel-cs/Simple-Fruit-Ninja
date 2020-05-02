package View;

import javafx.scene.image.Image;

public class ImageGetter {

   private static ImageGetter instance;

    private ImageGetter() {
    }
    public static ImageGetter createImageGetter()
    {
     if(instance==null)
      instance=new ImageGetter();
     return instance;
    }


  //all images needed in gui except fruit images
   private BufferedImage background=new BufferedImage("BackGround",new Image("file:Fruit_Ninja_Materials/Background.jpg"));
   private BufferedImage logo=new BufferedImage("Logo",new Image("file:Fruit_Ninja_Materials/logo.png"));
   private BufferedImage exit=new BufferedImage("Exit",new Image("file:Fruit_Ninja_Materials/exit.png"));
   private BufferedImage startClassic=new BufferedImage("Classic",new Image("file:Fruit_Ninja_Materials/classic.png"));
   private BufferedImage highScore=new BufferedImage("High Score", new Image("file:Fruit_Ninja_Materials/HS.png"));
   private BufferedImage ninjaMan=new BufferedImage("Ninja Man", new Image("file:Fruit_Ninja_Materials/man.png"));
   private BufferedImage back=new BufferedImage("Back",new Image("file:Fruit_Ninja_Materials/back.png"));
   private BufferedImage heart=new BufferedImage("Heart",new Image("file:Fruit_Ninja_Materials/Heart.png"));


 public BufferedImage getHeart() {
  return heart;
 }

 public BufferedImage getBack() {
  return back;
 }

 public BufferedImage getBackground() {
  return background;
 }

 public BufferedImage getLogo() {
  return logo;
 }

 public BufferedImage getExit() {
  return exit;
 }

 public BufferedImage getStartClassic() {
  return startClassic;
 }

 public BufferedImage getHighScore() {
  return highScore;
 }

 public BufferedImage getNinjaMan() {
  return ninjaMan;
 }
}
