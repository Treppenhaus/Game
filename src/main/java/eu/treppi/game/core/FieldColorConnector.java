package eu.treppi.game.core;

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

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public String getFieldName() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
