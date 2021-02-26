package eu.treppi.game.worlds;

import eu.treppi.game.graphics.Field;

public class FieldColorConnector {
    private int red, green, blue;
    private String field;

    public FieldColorConnector(int red, int green, int blue, String field) {
        this.field = field;
        this.red = red;
        this.blue = blue;
        this.green = green;
    }

    public Field getField() {
        for(Field field : MapController.getFields()) {
            if(field.getName().equalsIgnoreCase(this.field)) return field;
        }

        return null;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public String getFieldName() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
