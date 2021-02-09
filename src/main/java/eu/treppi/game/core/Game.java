package eu.treppi.game.core;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {

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
        g = game.getGraphicscontroller().drawGraphics(g);
    }

    public static void main(String[] args) {

        game = new Game();
        game.setTitle("game lul");
        game.setSize(16 * 100, 9 * 100);

        game.getGraphicscontroller().loadGraphics();
        game.getMapcontroller().loadMaps();

        game.setResizable(false);

        redrawThread(game);
        game.setVisible(true);
    }

    public static void redrawThread(Game game) {
        new Thread(() -> {
           // while (true) {

                try {
                    Thread.sleep(1000 / 1);
                } catch (Exception e) {
                    e.printStackTrace();
                }


                game.repaint();
            //}
            game.repaint();
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
}