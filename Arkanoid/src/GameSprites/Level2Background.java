// 209163708 Bar Aharon

package GameSprites;

import GameManagement.GameLevel;
import Interfaces.Sprite;
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * Level 2 background.
 *
 * @author Bar Aharon bar.aharon98@gmail.com
 * @version 1.0
 * @since 2022-09-06.
 */
public class Level2Background implements Sprite {
    /**
     * The Circle radius.
     */
    static final int CIRCLE_RADIUS = 30;
    /**
     * The Second circle radius.
     */
    static final int SECOND_RADIUS = 35;
    /**
     * The Third circle radius.
     */
    static final int THIRD_RADIUS = 40;
    /**
     * The Yellow color.
     */
    static final Color YELLOW = new Color(255, 220, 0);
    /**
     * The Yellower color.
     */
    static final Color YELLOWER = new Color(255, 255, 0);
    /**
     * The Yellowest color.
     */
    static final Color YELLOWEST = new Color(255, 255, 130);
    /**
     * The Middle x point of the circles.
     */
    static final int MIDDLE_X = 100;
    /**
     * The Middle y point of the circles.
     */
    static final int MIDDLE_Y = 100;
    /**
     * Num points to draw rays.
     */
    static final int NUM_POINTS = 1000;
    /**
     * The Block y coordinate.
     */
    static final int BLOCK_Y = 250;
    @Override
    public void drawOn(DrawSurface d) {
        // draw the bigger sun aura
        d.setColor(YELLOWEST);
        d.fillCircle(MIDDLE_X, MIDDLE_Y, THIRD_RADIUS);
        for (int i = 0; i < NUM_POINTS; i += 10) {
            // draw the sun rays
            d.drawLine(MIDDLE_X, MIDDLE_Y, i, BLOCK_Y);
        }
        // draw the smaller sun aura
        d.setColor(YELLOWER);
        d.fillCircle(MIDDLE_X, MIDDLE_Y, SECOND_RADIUS);
        d.setColor(YELLOW);
        // draw the bigger sun aura
        d.fillCircle(MIDDLE_X, MIDDLE_Y, CIRCLE_RADIUS);
    }

    @Override
    public void timePassed() {

    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
