package eu.treppi.game.core;

import eu.treppi.game.graphics.GraphicsController;
import eu.treppi.game.keylistener.Keyboard;
import eu.treppi.game.player.Player;
import eu.treppi.game.worlds.MapController;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Game extends JFrame {

    private static Game game;
    private MapController mapcontroller;
    private GraphicsController graphicscontroller;

    private ArrayList<Player> players = new ArrayList<>();
    static private int framecount = 0;


    public Game() {
        super();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        graphicscontroller = new GraphicsController();
        mapcontroller = new MapController(graphicscontroller);

        addPlayer(new Player("treppi", "ressources/player/player_animated"));
        this.addKeyListener(new Keyboard());
    }

    public void paint(Graphics g) {
        g = game.getGraphicscontroller().drawGraphics(g);
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

    public Player getMainPlayer() {
        for(Player p : players) {
            if(p.getName().equalsIgnoreCase("treppi")) return p;
        }
        return players.get(0);
    }

    public static void redrawThread(Game game) {
        int framerate = 25;
        new Thread(() -> {
           while (true) {
                try {
                    Thread.sleep(1000 / framerate);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                framecount++;
                game.repaint();
            }
        }).start();
    }
    public static int getCurrentFrameCount() {
        return framecount;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
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

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
}