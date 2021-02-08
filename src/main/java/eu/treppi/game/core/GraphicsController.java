package eu.treppi.game.core;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class GraphicsController {
    private static ArrayList<Field> fields;

    public static void loadGraphics() {
        fields = loadFields();
    }

    private static ArrayList<Field> loadFields() {
        ArrayList<Field> fields = new ArrayList<Field>();

        fields.add(new Field(80, 80, "Grass", "ressources/fields/grass2.png"));
        fields.add(new Field(80, 80, "Random", "ressources/fields/random.png"));

        return fields;
    }

    public static Field getFieldByName(String name) {
        for(Field field : fields)
            if(field.getName().equalsIgnoreCase(name)) return field;

        return null;
    }

    public static Graphics drawGraphics(Graphics g) {

        Map map = MapController.getMapByName("default");
        for(MapTile tile : map.getTiles()) {
            Field f = tile.getField();

            g.drawImage(f.getImage(), f.getWidth() * tile.getX(), f.getHeight() * tile.getY(), null);
        }
        //draw fields;
        /*
        for(int x = 0; x < 10; x++) {
            for(int y = 0; y < 10; y++) {
                Field f = fields.get(0);
                g.drawImage(f.getImage(), f.getWidth() * x, f.getHeight() * y, null);
            }
        }*/

        return g;
    }
}
