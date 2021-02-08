package eu.treppi.game.core;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Field {
    String name, path;
    BufferedImage image;

    int height, width;

    public Field(int height, int width, String name, String path) {
        this.height = height;
        this.width = width;
        this.name = name;
        this.path = path;

        try {
            this.image = ImageIO.read(new File(path));
        }catch (Exception e1){
            e1.printStackTrace();
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
