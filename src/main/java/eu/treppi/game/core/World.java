package eu.treppi.game.core;

import java.util.ArrayList;

public class World {
    String name;
    ArrayList<MapTile> tiles;

    public World(String name, ArrayList<MapTile> tiles) {
        this.name = name;
        this.tiles = tiles;
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
}
