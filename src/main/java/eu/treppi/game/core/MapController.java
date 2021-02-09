package eu.treppi.game.core;

import java.util.ArrayList;
import java.util.Random;

public class MapController {
    private ArrayList<Map> maps;
    GraphicsController gc;

    public MapController(GraphicsController gc) {
        this.gc = gc;
    }

    public void loadMaps() {
        maps = new ArrayList<>();

        Map map = new Map("default");
        ArrayList<MapTile> tiles = new ArrayList<>();

        for(int x = 0; x < 50; x++)
            for(int y = 0; y < 50; y++)
                tiles.add(new MapTile(x, y, "Grass"));

        map.setTiles(tiles);
        maps.add(map);

    }

    public Map getMapByName(String name) {

        if(maps == null) System.out.print("0 maps loaded!");

        for(Map map : maps)
            if(map.getName().equalsIgnoreCase(name)) return map;

        return null;
    }

    public Boolean mapExists(String name) {
        return getMapByName(name) != null;
    }
}
