package eu.treppi.game.graphics;

import eu.treppi.game.core.Game;
import eu.treppi.game.worlds.MapController;
import eu.treppi.game.worlds.MapTile;
import eu.treppi.game.worlds.World;

import java.awt.*;

public class Camera {
    public static Graphics viewWorldFrom(Graphics g, World world, double cx, double cy) {



        Game game = Game.getGame();
        int gameHeight = game.getHeight();
        int gameWidth = game.getWidth();

        int fov = 11;
        // es sollen 10 Felder in jede Richtung der Welt von der x und y Koordinate aus geladen werden.
        // xr, yr = koordinate der Felder AUF DEM BILD die auf dem Bild angezeigt werden
        // fy, fy = koordinate der Felder die angezeigt werden
        // cx, cy = camera coordinates

        //System.out.println("\n\n\n\n\n\n\n");
        for(int xr = fov*-1; xr < fov; xr++) {
            for(int yr = fov*-1; yr < fov; yr++) {
                double x = cx + xr;
                double y = cy + yr;

                int fx = (int) (xr + cx);
                int fy = (int) (yr + cy);

                double wert = (xr + cx) - fx;

                MapTile maptile = world.getMapTileAt(fx, fy);
                Field field;
                if(maptile == null) {
                    field = MapController.getFieldByName("missing_texture");
                }
                else field = maptile.getField();

                g.drawImage(field.getImage(), (xr + fov) * 80 - (int)(wert * 80), (yr + fov) * 80, null);

                String name = "null";
                if(maptile != null) name = maptile.getName();
                //System.out.println("["+fx+", "+fy+"] ("+xr + ", "+yr +") "+name + " ---> "+wert);
            }
        }


        return g;
    }
}
