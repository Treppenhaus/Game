package eu.treppi.game.worlds;

import eu.treppi.game.graphics.Field;
import eu.treppi.game.core.Game;
import eu.treppi.game.graphics.GraphicsController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class MapController {

    private static ArrayList<Field> fields;
    private static ArrayList<FieldColorConnector> colorConnections;
    private ArrayList<World> worlds;
    GraphicsController gc;

    public MapController(GraphicsController gc) {
        this.gc = gc;
    }

    public static void loadFields() {
        Game.info("loading fields...");
        fields = new ArrayList<>();
        fields.add(new Field(80, 80, "grass", "ressources/fields/grass_theto.png"));
        fields.add(new Field(80, 80, "rock", "ressources/fields/rock_full.png"));
        fields.add(new Field(80, 80, "tree", "ressources/fields/grass_with_tree.png"));
        fields.add(new Field(80, 80, "missing_texture", "ressources/fields/missing.png"));

        Game.info("...loaded a total of "+fields.size()+" fields!");
    }

    public static void loadColorConnections() {
        Game.info("loading color connections...");
        colorConnections = new ArrayList<>();

        colorConnections.add(new FieldColorConnector(0, 182, 0, "grass"));
        colorConnections.add(new FieldColorConnector(128, 128, 128, "rock"));
        colorConnections.add(new FieldColorConnector(38, 105, 0, "tree"));

        Game.info("...loaded a total of "+colorConnections.size()+" color connectors!");
    }

    public void loadMaps() {
        Game.info("loading maps..");
        worlds = new ArrayList<>();

        World testworld = loadWorldFromImage("Testworld", new File("ressources/worlds/testworld3.png"));
        worlds.add(testworld);


        Game.info("...loaded a total of "+worlds.size() + " worlds!");
    }

    public World loadWorldFromImage(String name, File file) {

        try {
            ArrayList<MapTile> worldTiles = new ArrayList<>();
            BufferedImage image = ImageIO.read(file);

            for(int x = 0; x < image.getWidth(); x++) {
                for(int y = 0; y < image.getHeight(); y++) {

                    int color = image.getRGB(x, y);
                    int red = (color & 0x00ff0000) >> 16;
                    int green = (color & 0x0000ff00) >> 8;
                    int blue =   color & 0x000000ff;

                    //check for valid field
                    MapTile tile = null;
                    for(FieldColorConnector connector : colorConnections) {
                        if((red == connector.getRed()) && (green == connector.getGreen()) && (blue == connector.getBlue())) {
                            tile = new MapTile(x, y, connector.getFieldName());
                            break;
                        }
                    }
                    if(tile == null)
                        tile = new MapTile(x, y, "missing_texture");


                    worldTiles.add(tile);
                }
            }

            return new World(name, worldTiles);

        }catch (Exception e) {
            System.out.print("Couldn't load world "+name + "("+file+")");
            return null;
        }
    }

    public World getMapByName(String name) {

        if(worlds == null) System.out.print("0 maps loaded!");

        for(World world : worlds)
            if(world.getName().equalsIgnoreCase(name)) return world;

        return null;
    }

    public Boolean worldExists(String name) {
        return getMapByName(name) != null;
    }

    public static ArrayList<Field> getFields() {
        return fields;
    }

    public static Field getFieldByName(String name) {
        for(Field field : fields)
            if(field.getName().equalsIgnoreCase(name)) return field;

        return null;
    }
}
