// 209163708 Bar Aharon

package GameSprites;

import GameManagement.GameLevel;
import Interfaces.Sprite;
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * Level 1 background.
 *
 * @author Bar Aharon bar.aharon98@gmail.com
 * @version 1.0
 * @since 2022-09-06.
 */
public class Level1Background implements Sprite {

    /**
     * The Circle radius.
     */
    static final int CIRCLE_RADIUS = 30;
    /**
     * The Block point.
     */
    static final int BLOCK_POINT = 100;
    /**
     * The Line length.
     */
    static final int LINE_LENGTH = 80;
    /**
     * The Block size.
     */
    static final int BLOCK_SIZE = 30;


    @Override
    public void drawOn(DrawSurface d) {
        // draw the background color
        d.setColor(Color.BLACK);
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
        d.setColor(Color.BLUE);
        // draw line on the target
        d.drawLine(d.getWidth() / 2, BLOCK_POINT + BLOCK_SIZE / 2,
                d.getWidth() / 2 - LINE_LENGTH, BLOCK_POINT + BLOCK_SIZE / 2);
        d.drawLine(d.getWidth() / 2 + BLOCK_SIZE / 2, BLOCK_POINT,
                d.getWidth() / 2 + BLOCK_SIZE / 2, BLOCK_POINT - LINE_LENGTH);
        d.drawLine(d.getWidth() / 2 + BLOCK_SIZE, BLOCK_POINT + BLOCK_SIZE / 2,
                d.getWidth() / 2 + BLOCK_SIZE + LINE_LENGTH, BLOCK_POINT + BLOCK_SIZE / 2);
        d.drawLine(d.getWidth() / 2 + BLOCK_SIZE / 2, BLOCK_POINT + BLOCK_SIZE,
                d.getWidth() / 2 + BLOCK_SIZE / 2, BLOCK_POINT + BLOCK_SIZE + LINE_LENGTH);
        // draw circles on the target
        for (int i = 1; i <= 3; i++) {
            d.drawCircle((int) d.getWidth() / 2 + BLOCK_SIZE / 2, BLOCK_POINT +  BLOCK_SIZE / 2,
                    CIRCLE_RADIUS * i);
        }

    }

    @Override
    public void timePassed() {

    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
