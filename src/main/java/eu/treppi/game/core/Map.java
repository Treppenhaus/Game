package eu.treppi.game.core;

import java.util.ArrayList;

public class Map {
    String name;
    ArrayList<MapTile> tiles;

    public Map(String name) {
        this.name = name;
    }


    public ArrayList<MapTile> getTiles() {
        return tiles;
    }

    public void setTiles(ArrayList<MapTile> tiles) {
        this.tiles = tiles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MapTile getMaptileByName(String name) {
        for(MapTile tile : tiles) {
            if(tile.getName().equalsIgnoreCase(name)) return tile;
        }
        return null;
    }
}
