package eu.treppi.game.player;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.Buffer;
import java.util.ArrayList;

public class Player {
    double x, y;
    String name;

    ArrayList<BufferedImage> texture;

    ArrayList<BufferedImage> texture_walking_right;
    ArrayList<BufferedImage> texture_walking_left;
    ArrayList<BufferedImage> texture_walking_up;
    ArrayList<BufferedImage> texture_walking_down;
    ArrayList<BufferedImage> texture_standing_still;


    String texturePath;

    public Player(String name, String texturePath) {
        x = y = 10d;
        this.name = name;
        this.texturePath = texturePath;

        try {
            texture_walking_right = new ArrayList<BufferedImage>();
            for(int i = 1; i < 100; i++) {
                String path = texturePath+"_"+i+".png";

                File f = new File(path);
                if(f.exists())
                    texture_walking_right.add(ImageIO.read(f));
            }

            texture_walking_left = new ArrayList<BufferedImage>();
            for(BufferedImage text : texture_walking_right) {
                texture_walking_left.add(mirrorImage(text));
            }

            texture_standing_still = texture_walking_right;
            texture_walking_up = texture_walking_right;
            texture_walking_down = texture_walking_right;
            texture = texture_standing_still;



        }catch (Exception e1) {
            e1.printStackTrace();
        }
    }
    private static BufferedImage mirrorImage(BufferedImage simg) {
        int width = simg.getWidth();
        int height = simg.getHeight();

        BufferedImage mimg = new BufferedImage(width*2, height, BufferedImage.TYPE_INT_ARGB);
        //create mirror image pixel by pixel
        for(int y = 0; y < height; y++){
            for(int lx = 0, rx = width*2 - 1; lx < width; lx++, rx--){
                //lx starts from the left side of the image
                //rx starts from the right side of the image
                //get source pixel value
                int p = simg.getRGB(lx, y);
                //set mirror image pixel value - both left and right
                mimg.setRGB(lx, y, p);
                mimg.setRGB(rx, y, p);
            }
        }
        return mimg;
    }


    public void move(String direction) {

        double speed = 0.2;
        double x = getX();
        double y = getY();

        if(direction.equalsIgnoreCase("w")) {
            setY(y - speed);
            texture = texture_walking_up;
        }
        else if(direction.equalsIgnoreCase("a")) {
            setX(x - speed);
            texture = texture_walking_left;
        }
        else if(direction.equalsIgnoreCase("s")) {
            setY(y + speed);
            texture = texture_walking_down;
        }
        else if(direction.equalsIgnoreCase("d")) {
            setX(x + speed);
            texture = texture_walking_right;
        }
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

    public BufferedImage getTexture(int framerate) {
        ArrayList<BufferedImage> list = texture;
        int count = list.size();

        if(count == 0) count = 1;
        int item = framerate % count;

        return list.get(item);
    }

    public void setTexturePath(String texturePath) {
        this.texturePath = texturePath;
    }
}
