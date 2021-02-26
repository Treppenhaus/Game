package eu.treppi.game.keylistener;

import eu.treppi.game.core.Game;
import eu.treppi.game.player.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {
    public void keyTyped(KeyEvent e) {
        String input = String.valueOf(e.getKeyChar());

        Player p = Game.getGame().getMainPlayer();
        p.move(input);
    }
    public void keyPressed(KeyEvent e) {
    }
    public void keyReleased(KeyEvent e) {
    }

}
