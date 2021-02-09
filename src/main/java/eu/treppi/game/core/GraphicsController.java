package eu.treppi.game.core;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class GraphicsController {
    private ArrayList<Field> fields;

    public void loadGraphics() {
        fields = loadFields();
    }

    private ArrayList<Field> loadFields() {
        ArrayList<Field> fields = new ArrayList<Field>();

        fields.add(new Field(80, 80, "Grass", "ressources/fields/grass_theto.png"));
        fields.add(new Field(80, 80, "Rock", "ressources/fields/rock.png"));
        fields.add(new Field(80, 80, "Tree", "ressources/fields/tree.png"));
        fields.add(new Field(80, 80, "Trees", "ressources/fields/trees.png"));

        return fields;
    }

    public Field getFieldByName(String name) {
        for(Field field : fields)
            if(field.getName().equalsIgnoreCase(name)) return field;

        return null;
    }

    public Graphics drawGraphics(Graphics g) {

        int gameHeight = Game.getGame().getHeight(); //default: 1600e
        int gameWidth = Game.getGame().getWidth();

        int tilelength = gameHeight / 20;

        MapController mapController = Game.getGame().getMapcontroller();
        Map map = mapController.getMapByName("default");

        g.setColor(Color.pink);
        g.drawRect(0, 0, gameWidth, gameHeight);

        /*


        DRAW MAP


         */
        for(MapTile tile : map.getTiles()) {
            Field f = getFieldByName(tile.getName());
            BufferedImage graphics = f.getImage();

            //g.drawImage(f.getImage(), f.getWidth() * tile.getX(), f.getHeight() * tile.getY(), null);
            //int x = tilelength * tile.getX();
            //int y = tilelength * tile.getY();

            //static but works (lmao)
            g.drawImage(graphics, tile.getX() * 80, tile.getY() * 80, null);
        }




        /*


        POPULATE MAP


         */

        for(MapTile tile : map.getTiles()) {
            int x = tile.getX();
            int y = tile.getY();

            if(new Random().nextDouble() < 0.3) {

                int offset1 = randInt(0, 100);
                int offset2 = randInt(0, 100);

                int offset3 = randInt(0, 100);
                int offset4 = randInt(0, 100);

                Game game = Game.getGame();
                Field rock = getFieldByName("rock");

                double r = new Random().nextDouble();
                if(r > 0.85) {
                    //g.drawImage(rock.getImage(), tile.getX() * 80 + offset1, tile.getY() * 80 + offset2, null);
                }
                if(r > 0.3) {
                    g.drawImage(getFieldByName("tree").getImage(), tile.getX() * 80 + offset1, tile.getY() * 80 + offset2, null);
                }
                if(r > 0.3) {
                    g.drawImage(getFieldByName("tree").getImage(), tile.getX() * 80 + offset3, tile.getY() * 80 + offset4, null);
                }
                if(r > 0.2) {
                    //g.drawImage(getFieldByName("trees").getImage(), tile.getX() * 80 + offset1, tile.getY() * 80 + offset2, null);
                    //System.out.println("Bäume gepaintet bei x: "+x+", y: "+y);
                }
            }
        }

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
