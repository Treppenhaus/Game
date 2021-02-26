package eu.treppi.game.graphics;

import eu.treppi.game.core.Game;
import eu.treppi.game.player.Player;
import eu.treppi.game.worlds.MapController;
import eu.treppi.game.worlds.MapTile;
import eu.treppi.game.worlds.World;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Camera {
    public static Graphics viewWorldFrom(Graphics g, World world, double cx, double cy) {

        Game game = Game.getGame();


        // es sollen 10 Felder in jede Richtung der Welt von der x und y Koordinate aus geladen werden.
        // xr, yr = koordinate der Felder AUF DEM BILD die auf dem Bild angezeigt werden
        // fy, fy = koordinate der Felder die angezeigt werden
        // cx, cy = camera coordinates

        //System.out.println("\n\n\n\n\n\n\n");
        int fov = 11;
        for(int xr = fov*-1; xr < fov; xr++) {
            for(int yr = fov*-1; yr < fov; yr++) {

                int fx = (int) (xr + cx);
                int fy = (int) (yr + cy);

                double frameoffset = (xr + cx) - fx;
                MapTile maptile = world.getMapTileAt(fx, fy);

                BufferedImage texture = maptile == null ? MapController.getFieldByName("missing_texture").getImage() : maptile.getField().getImage();
                g.drawImage(texture, (xr + fov) * 80 - (int)(frameoffset * 80), (yr + fov) * 80, null);
            }
        }

        ArrayList<Player> players = game.getPlayers();
        for(Player player : players) {
            BufferedImage texture = player.getTexture();
            //     cx
            //     cy
            double px = player.getX();
            double py = player.getY();

            double dx = px - cx;
            double dy = py - cy;
            g.drawImage(texture, Game.getGame().getWidth() / 2 - texture.getHeight() / 2, Game.getGame().getHeight() / 2 - texture.getHeight() / 2, null);
        }
        return g;
    }
}
