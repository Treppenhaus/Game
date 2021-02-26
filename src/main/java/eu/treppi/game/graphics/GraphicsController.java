package eu.treppi.game.graphics;

import eu.treppi.game.core.Game;
import eu.treppi.game.player.Player;
import eu.treppi.game.worlds.MapController;
import eu.treppi.game.worlds.MapTile;
import eu.treppi.game.worlds.World;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class GraphicsController {
    private ArrayList<Field> fields;


    public Graphics drawGraphics(Graphics g) {
        for(Player player : Game.getGame().getPlayers()) {
            if(player.getName().equalsIgnoreCase("treppi")) {
                g = Camera.viewWorldFrom(g, Game.getGame().getMapcontroller().getMapByName("testworld"), player.getX(), player.getY());
            }
        }

        //draw world

        return g;
    }

    public static int randInt(int min, int max) {
        Random rand = new Random();

        return rand.nextInt((max - min) + 1) + min;
    }
}
