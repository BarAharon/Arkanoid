// 209163708 Bar Aharon

package GameSprites;

import GameManagement.GameLevel;
import Interfaces.Sprite;
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * Level 3 background.
 *
 * @author Bar Aharon bar.aharon98@gmail.com
 * @version 1.0
 * @since 2022-09-06.
 */
public class Level3Background implements Sprite {
    /**
     * The Building start x coordinate.
     */
    static final int BUILDING_START_X = 80;
    /**
     * The Building width.
     */
    static final int BUILDING_WIDTH = 100;
    /**
     * The Building height.
     */
    static final int BUILDING_HEIGHT = 180;
    /**
     * The Middle building width.
     */
    static final int MIDDLE_BUILDING_WIDTH = 30;
    /**
     * The Middle building height.
     */
    static final int MIDDLE_BUILDING_HEIGHT = 50;
    /**
     * The Top width.
     */
    static final int TOP_WIDTH = 15;
    /**
     * The Top height.
     */
    static final int TOP_HEIGHT = 250;
    /**
     * Num of windows.
     */
    static final int NUM_WINDOWS = 5;
    /**
     * The Windows start x coordinate.
     */
    static final int WINDOWS_START_X = BUILDING_START_X + 5;
    /**
     * The Windows gap.
     */
    static final int WINDOWS_GAP = 10;
    /**
     * The Windows height.
     */
    static final int WINDOWS_HEIGHT = BUILDING_HEIGHT / NUM_WINDOWS - WINDOWS_GAP;
    /**
     * The Windows width.
     */
    static final int WINDOWS_WIDTH = BUILDING_WIDTH / NUM_WINDOWS - WINDOWS_GAP;
    /**
     * The Light start radius.
     */
    static final int LIGHT_START_RADIUS = 3;
    /**
     * The Light num.
     */
    static final int LIGHT_NUM = 3;
    /**
     * The Fix coordinates light.
     */
    static final int FIX_COORDINATES_LIGHT = 8;
    /**
     * The Dark.
     */
    static final Color DARK = new Color(50, 50, 50);
    /**
     * The Light dark.
     */
    static final Color LIGHT_DARK = new Color(100, 100, 100);
    /**
     * The Background color.
     */
    static final Color BACKGROUND_COLOR = new Color(0, 102, 0);
    @Override
    public void drawOn(DrawSurface d) {
        // draw the background color
        d.setColor(BACKGROUND_COLOR);
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
        // draw the building
        d.setColor(Color.BLACK);
        d.fillRectangle(BUILDING_START_X, d.getHeight() - BUILDING_HEIGHT, BUILDING_WIDTH, BUILDING_HEIGHT);
        // draw the windows
        d.setColor(Color.WHITE);
        for (int i = 0; i < NUM_WINDOWS; i++) {
            for (int j = 0; j < NUM_WINDOWS; j++) {
                d.fillRectangle(WINDOWS_START_X + WINDOWS_WIDTH * j + WINDOWS_GAP * j,
                        d.getHeight() - WINDOWS_HEIGHT * (i + 1) - WINDOWS_GAP * (i + 1) + WINDOWS_GAP,
                        WINDOWS_WIDTH, WINDOWS_HEIGHT);
            }
        }
        // draw the middle building
        d.setColor(DARK);
        d.fillRectangle((BUILDING_START_X + BUILDING_WIDTH / 2) - (MIDDLE_BUILDING_WIDTH / 2),
                d.getHeight() - BUILDING_HEIGHT - MIDDLE_BUILDING_HEIGHT,
                MIDDLE_BUILDING_WIDTH, MIDDLE_BUILDING_HEIGHT);
        // draw the top
        d.setColor(LIGHT_DARK);
        d.fillRectangle(((BUILDING_START_X + BUILDING_WIDTH / 2) - (MIDDLE_BUILDING_WIDTH / 2)) + (TOP_WIDTH / 2),
                d.getHeight() - BUILDING_HEIGHT - MIDDLE_BUILDING_HEIGHT - TOP_HEIGHT, TOP_WIDTH, TOP_HEIGHT);
        Color color = Color.BLACK;
        // draw the building light
        for (int i = 1; i <= LIGHT_NUM; i++) {
            switch (i) {
                case 1:
                    color = Color.ORANGE;
                    break;
                case 2:
                    color = Color.RED;
                    break;
                case 3:
                    color = Color.WHITE;
                    break;
                default:
                    break;
            }
            d.setColor(color);
            d.fillCircle(((BUILDING_START_X + BUILDING_WIDTH / 2) - (MIDDLE_BUILDING_WIDTH / 2)) + (TOP_WIDTH / 2)
                            + FIX_COORDINATES_LIGHT,
                    d.getHeight() - BUILDING_HEIGHT - MIDDLE_BUILDING_HEIGHT - TOP_HEIGHT - LIGHT_START_RADIUS,
                    LIGHT_START_RADIUS * (LIGHT_NUM + 1 - i));
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
