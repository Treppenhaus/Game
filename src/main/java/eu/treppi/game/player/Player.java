package eu.treppi.game.player;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Player {
    double x, y;
    String name;

    BufferedImage texture;
    String texturePath;

    public Player(String name, String texturePath) {
        x = y = 10d;
        this.name = name;
        this.texturePath = texturePath;

        try {
            this.texture = ImageIO.read(new File(texturePath));
        }catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void move(String direction) {

        double speed = 0.2;
        double x = getX();
        double y = getY();

        if(direction.equalsIgnoreCase("w")) setY(y - speed);
        else if(direction.equalsIgnoreCase("a")) setX(x - speed);
        else if(direction.equalsIgnoreCase("s")) setY(y + speed);
        else if(direction.equalsIgnoreCase("d")) setX(x + speed);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BufferedImage getTexture() {
        return texture;
    }

    public void setTexture(BufferedImage texture) {
        this.texture = texture;
    }

    public String getTexturePath() {
        return texturePath;
    }

    public void setTexturePath(String texturePath) {
        this.texturePath = texturePath;
    }
}
