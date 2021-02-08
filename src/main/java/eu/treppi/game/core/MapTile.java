package eu.treppi.game.core;

public class MapTile {
    Field field;
    int x;
    int y;

    public MapTile(int x, int y, Field field) {
        this.field = field;
        this.x = x;
        this.y = y;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
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
}
