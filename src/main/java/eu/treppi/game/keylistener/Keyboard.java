package eu.treppi.game.keylistener;

import eu.treppi.game.core.Game;
import eu.treppi.game.player.DIRECTION;
import eu.treppi.game.player.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {
    public void keyTyped(KeyEvent e) {
        String input = String.valueOf(e.getKeyChar());
        Game.info(input);

        Player p = Game.getGame().getMainPlayer();
        p.move(input);
    }
    public void keyPressed(KeyEvent e) {
    }

    /** Handle the key-released event from the text field. */
    public void keyReleased(KeyEvent e) {
    }
    /** Handle the key-pressed event from the text field. */

}
