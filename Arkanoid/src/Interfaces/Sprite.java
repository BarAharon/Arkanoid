// 209163708 Bar Aharon

package Interfaces;

import GameManagement.GameLevel;
import biuoop.DrawSurface;

/**
 * The interface Sprite.
 *
 * @author Bar Aharon bar.aharon98@gmail.com
 * @version 1.0
 * @since 2022-08-15.
 */
public interface Sprite {
    /**
     * Draw the sprite in the DrawSurface.
     *
     * @param d the DrawSurface
     */
    void drawOn(DrawSurface d);

    /**
     * Notify the sprite that time has passed.
     */
    void timePassed();

    /**
     * Add the sprite game.
     *
     * @param g the game
     */
    void addToGame(GameLevel g);
}

