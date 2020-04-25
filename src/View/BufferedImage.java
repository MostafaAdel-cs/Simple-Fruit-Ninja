package View;

import javafx.scene.image.Image;

public class BufferedImage {
    String name;
    Image image;


    public BufferedImage (String name, Image image)
    {
        this.name=name;
        this.image=image;
    }

    public String getName() {
        return name;
    }

    public Image getImage() {
        return image;
    }
}
