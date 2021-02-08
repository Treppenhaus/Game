package eu.treppi.game.core;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {
    public Game() {
        super();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g) {
        g = GraphicsController.drawGraphics(g);
    }

    public static void main(String[] args) {

        GraphicsController.loadGraphics();
        MapController.loadMaps();

        Game g = new Game();
        g.setTitle("game lul");
        g.setSize(16*50, 9*50);
        g.setResizable(false);
        g.setVisible(true);

        redraw(g);
    }

    public static void redraw(Game game) {
        new Thread(() -> {
            while(true) {

                try {
                    Thread.sleep(1000 / 35);
                }catch (Exception e) {
                    e.printStackTrace();
                }


                game.repaint();
            }
        }).start();
    }
}
