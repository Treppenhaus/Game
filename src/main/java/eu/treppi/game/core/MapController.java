package eu.treppi.game.core;

import java.util.ArrayList;
import java.util.Random;

public class MapController {
    private static ArrayList<Map> maps;

    public static void loadMaps() {
        maps = new ArrayList<>();

        Map map = new Map("default");
        ArrayList<MapTile> tiles = new ArrayList<>();

        for(int x = 0; x < 100; x++)
            for(int y = 0; y < 100; y++)
                if(new Random().nextBoolean()) tiles.add(new MapTile(x, y, GraphicsController.getFieldByName("Grass")));
                else tiles.add(new MapTile(x, y, GraphicsController.getFieldByName("Random")));

        map.setTiles(tiles);
        maps.add(map);

    }

    public static Map getMapByName(String name) {
        for(Map map : maps)
            if(map.getName().equalsIgnoreCase(name)) return map;

        return null;
    }

    public static Boolean mapExists(String name) {
        return getMapByName(name) != null;
    }
}
