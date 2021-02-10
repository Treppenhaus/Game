package eu.treppi.game.worlds;

import eu.treppi.game.graphics.Field;

public class MapTile {
    String name;
    int x;
    int y;

    public MapTile(int x, int y, String name) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Field getField() {
        return MapController.getFieldByName(this.name);
    }
}
