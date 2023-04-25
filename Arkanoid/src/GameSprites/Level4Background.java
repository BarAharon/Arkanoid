// 209163708 Bar Aharon

package GameSprites;

import GameManagement.GameLevel;
import Interfaces.Sprite;
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * Level 4 background.
 *
 * @author Bar Aharon bar.aharon98@gmail.com
 * @version 1.0
 * @since 2022-09-06.
 */
public class Level4Background implements Sprite {
    /**
     * The Background color.
     */
    static final Color BACKGROUND_COLOR = new Color(51, 204, 255);
    /**
     * The Gray color.
     */
    static final Color GRAY = new Color(204, 204, 204);
    /**
     * The Grayer color.
     */
    static final Color GRAYER = new Color(180, 180, 180);
    /**
     * The Grayest color.
     */
    static final Color GRAYEST = new Color(153, 153, 153);
    /**
     * The First cloud top start x coordinate.
     */
    static final int FIRST_CLOUD_TOP_START_X = 85;
    /**
     * The First cloud bottom start x coordinate.
     */
    static final int FIRST_CLOUD_BOTTOM_START_X = 65;
    /**
     * The First cloud start y coordinate.
     */
    static final int FIRST_CLOUD_START_Y = 390;
    /**
     * The Second cloud top start x coordinate.
     */
    static final int SECOND_CLOUD_TOP_START_X = 605;
    /**
     * The Second cloud bottom start x coordinate.
     */
    static final int SECOND_CLOUD_BOTTOM_START_X = 585;
    /**
     * The Second cloud start y coordinate.
     */
    static final int SECOND_CLOUD_START_Y = 500;
    /**
     * The Rain gap.
     */
    static final int RAIN_GAP = 7;
    @Override
    public void drawOn(DrawSurface d) {
        // draw the background color
        d.setColor(BACKGROUND_COLOR);
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());

        // draw the rain
        for (int i = 1; i <= 10; i++) {
            d.setColor(Color.WHITE);
            d.drawLine(FIRST_CLOUD_TOP_START_X + RAIN_GAP * i, FIRST_CLOUD_START_Y,
                    FIRST_CLOUD_BOTTOM_START_X + RAIN_GAP * i, d.getHeight());
            d.drawLine(SECOND_CLOUD_TOP_START_X + RAIN_GAP * i, SECOND_CLOUD_START_Y,
                    SECOND_CLOUD_BOTTOM_START_X + RAIN_GAP * i, d.getHeight());
        }

        // draw the first cloud
        d.setColor(GRAY);
        d.fillCircle(80, 390, 20);
        d.fillCircle(100, 410, 25);
        d.setColor(GRAYER);
        d.fillCircle(115, 380, 25);
        d.setColor(GRAYEST);
        d.fillCircle(130, 410, 20);
        d.fillCircle(145, 385, 25);

        // draw the second cloud
        d.setColor(GRAY);
        d.fillCircle(600, 500, 20);
        d.fillCircle(620, 530, 25);
        d.setColor(GRAYER);
        d.fillCircle(635, 510, 25);
        d.setColor(GRAYEST);
        d.fillCircle(650, 520, 20);
        d.fillCircle(665, 515, 25);
    }

    @Override
    public void timePassed() {

    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
