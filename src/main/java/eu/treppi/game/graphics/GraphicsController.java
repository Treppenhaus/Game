package eu.treppi.game.graphics;

import eu.treppi.game.core.Game;
import eu.treppi.game.worlds.MapController;
import eu.treppi.game.worlds.MapTile;
import eu.treppi.game.worlds.World;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class GraphicsController {
    private ArrayList<Field> fields;


    public Graphics drawGraphics(Graphics g, double test) {

        g = Camera.viewWorldFrom(g, Game.getGame().getMapcontroller().getMapByName("testworld"), 10.0 + test, 14.0);
        return g;
    }

    public static Graphics resizeGraphics(Graphics graphics, int dimension) {


        return graphics;
    }

    public static int randInt(int min, int max) {
        Random rand = new Random();

        return rand.nextInt((max - min) + 1) + min;
    }
}
