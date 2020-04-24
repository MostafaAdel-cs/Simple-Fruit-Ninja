package Model.GameObjects;

public abstract class GameObject {
    private int xLocation;
    private int yLocation;
    private int maxHeight;
    private int initialVelocity;
    private int fallingVelocity;
    private boolean isSliced;
    private boolean hasMovedOffScreen;

    public int getxLocation() {
        return xLocation;
    }

    public int getyLocation() {
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




}
