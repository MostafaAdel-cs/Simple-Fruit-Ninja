package Model.GameObjects;

import View.BufferedImage;

import java.util.ArrayList;
import java.util.Random;

public abstract class GameObject {
    private String name;
    private int xLocation;
    private int yLocation;
    private int maxHeight;
    private int initialVelocity;
    private int fallingVelocity;
    private boolean isSliced;
    private boolean hasMovedOffScreen;

    private BufferedImage unCutBufferedImage;
    private BufferedImage cutBufferedImage;

    public GameObject(String name) {
        Random random=new Random();
        initialVelocity=random.nextInt();
        fallingVelocity=initialVelocity;
        maxHeight= (int) (Math.pow(initialVelocity,2)/(2*10));
        isSliced=false;
        hasMovedOffScreen=false;
        this.name=name;
    }

    public BufferedImage getUnCutBufferedImage() {
        return unCutBufferedImage;
    }

    public void setUnCutBufferedImage(BufferedImage unCutBufferedImage) {
        this.unCutBufferedImage = unCutBufferedImage;
    }

    public BufferedImage getCutBufferedImage() {
        return cutBufferedImage;
    }

    public void setCutBufferedImage(BufferedImage cutBufferedImage) {
        this.cutBufferedImage = cutBufferedImage;
    }

    public void setXLocation(int x){
        xLocation=x;
    }
    public void setYLocation(int y)
    {
        yLocation=y;
    }

    public int getXLocation() {
        return xLocation;
    }

    public int getYLocation() {
        return yLocation;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public int getInitialVelocity() {
        return initialVelocity;
    }

    public int getFallingVelocity() {
        return fallingVelocity;
    }

    public boolean isSliced() {
        return isSliced;
    }

    public boolean isHasMovedOffScreen() {
        return hasMovedOffScreen;
    }

    public void slice(){
        isSliced=true;
    }

    public void move (double time)
    {
        
    }

    public ArrayList<BufferedImage> getBufferedImages()
    {
        ArrayList<BufferedImage> bufferedImages=new ArrayList<>();
        bufferedImages.add(unCutBufferedImage);
        bufferedImages.add(cutBufferedImage);
        return bufferedImages;
    }



}
