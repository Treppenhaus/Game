package eu.treppi.game.graphics;

import eu.treppi.game.core.Game;
import eu.treppi.game.worlds.MapController;
import eu.treppi.game.worlds.MapTile;
import eu.treppi.game.worlds.World;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class GraphicsController {
    private ArrayList<Field> fields;


    public Graphics drawGraphics(Graphics g, double test) {

        /*

        int gameHeight = Game.getGame().getHeight(); //default: 1600e
        int gameWidth = Game.getGame().getWidth();

        int tilelength = gameHeight / 20;

        MapController mapController = Game.getGame().getMapcontroller();
        World world = mapController.getMapByName("testworld");

        g.setColor(Color.pink);
        g.drawRect(0, 0, gameWidth, gameHeight);

        DRAW MAP
        for(MapTile tile : world.getTiles()) {

            int yoffset = 18;

            Field f = MapController.getFieldByName(tile.getName());
            BufferedImage graphics = f.getImage();

            g.drawImage(graphics, tile.getX() * 80, tile.getY() * 80 + yoffset, null);
        }




        for(MapTile tile : world.getTiles()) {
            int x = tile.getX();
            int y = tile.getY();

            if(new Random().nextDouble() < 0.3) {

                int offset1 = randInt(0, 100);
                int offset2 = randInt(0, 100);

                int offset3 = randInt(0, 100);
                int offset4 = randInt(0, 100);

                Game game = Game.getGame();
                Field rock = MapController.getFieldByName("rock");

                double r = new Random().nextDouble();
                if(r > 0.85) {
                    //g.drawImage(rock.getImage(), tile.getX() * 80 + offset1, tile.getY() * 80 + offset2, null);
                }
                if(r > 0.3) {
                    //g.drawImage(MapController.getFieldByName("tree").getImage(), tile.getX() * 80 + offset1, tile.getY() * 80 + offset2, null);
                }
                if(r > 0.3) {
                    //g.drawImage(MapController.getFieldByName("tree").getImage(), tile.getX() * 80 + offset3, tile.getY() * 80 + offset4, null);
                }
                if(r > 0.2) {
                    //g.drawImage(getFieldByName("trees").getImage(), tile.getX() * 80 + offset1, tile.getY() * 80 + offset2, null);
                    //System.out.println("Bäume gepaintet bei x: "+x+", y: "+y);
                }
            }
        }


        */
        g = Camera.viewWorldFrom(g, Game.getGame().getMapcontroller().getMapByName("testworld"), 10.0 + test, 14.0);
        return g;
    }

    public static Graphics resizeGraphics(Graphics graphics, int dimension) {


        return graphics;
    }

    public static int randInt(int min, int max) {
        Random rand = new Random();

        return rand.nextInt((max - min) + 1) + min;
    }
}
