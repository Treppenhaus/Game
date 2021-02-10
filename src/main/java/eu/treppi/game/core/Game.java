package eu.treppi.game.core;

import eu.treppi.game.graphics.GraphicsController;
import eu.treppi.game.worlds.MapController;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {

    public static double test = 0;

    private static Game game;
    private MapController mapcontroller;
    private GraphicsController graphicscontroller;


    public Game() {
        super();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        graphicscontroller = new GraphicsController();
        mapcontroller = new MapController(graphicscontroller);
    }

    public void paint(Graphics g) {
        g = game.getGraphicscontroller().drawGraphics(g, test);
    }

    public static void main(String[] args) {

        game = new Game();
        game.setTitle("game lul");
        game.setSize(16 * 100, 9 * 100);

        MapController.loadFields();
        MapController.loadColorConnections();

        game.getMapcontroller().loadMaps();

        game.setResizable(false);

        redrawThread(game);
        game.setVisible(true);
    }

    public static void redrawThread(Game game) {
        int framerate = 60;
        new Thread(() -> {
           while (true) {
                test += 0.01;
                try {
                    Thread.sleep(1000 / framerate);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(test);

                if(test > 10) test = 0;

                game.repaint();
            }
        }).start();
    }

    public MapController getMapcontroller() {
        return mapcontroller;
    }

    public void setMapcontroller(MapController mapcontroller) {
        this.mapcontroller = mapcontroller;
    }

    public GraphicsController getGraphicscontroller() {
        return graphicscontroller;
    }

    public void setGraphicscontroller(GraphicsController graphicscontroller) {
        this.graphicscontroller = graphicscontroller;
    }

    public static Game getGame() {
        return game;
    }

    public static void setGame(Game game) {
        Game.game = game;
    }

    public static void info(String info) {
        System.out.println(info);
    }
}