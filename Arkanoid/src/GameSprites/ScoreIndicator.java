// 209163708 Bar Aharon

package GameSprites;

import GameManagement.Counter;
import GameManagement.GameLevel;
import Interfaces.LevelInformation;
import Interfaces.Sprite;
import Shapes.Rectangle;
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * The type Score indicator.
 *
 * @author Bar Aharon bar.aharon98@gmail.com
 * @version 1.0
 * @since 2022 -08-29.
 */
public class ScoreIndicator implements Sprite {
    private LevelInformation levelInformation;
    private Counter score;
    private Rectangle scoreRect;
    private Counter lives;

    /**
     * The Font size.
     */
    static final int FONT_SIZE = 15;
    /**
     * The Fix coordinates x.
     */
    static final int FIX_COORDINATES_X = 35;
    /**
     * The Fix coordinates y.
     */
    static final int FIX_COORDINATES_Y = 5;

    /**
     * Instantiates a new Score indicator.
     *
     * @param score            the score
     * @param scoreRect        the score rect
     * @param levelInformation the level information
     * @param lives            the lives remaining
     */
    public ScoreIndicator(Counter score, Rectangle scoreRect, LevelInformation levelInformation, Counter lives) {
        this.score = score;
        this.scoreRect = scoreRect;
        this.levelInformation = levelInformation;
        this.lives = lives;
    }

    /**
     * Draw the score.
     *
     * @param d the DrawSurface
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.WHITE);
        d.fillRectangle(0, 0,
                (int) scoreRect.getWidth(), (int) scoreRect.getHeight());
        d.setColor(Color.BLACK);
        // draw lives
        d.drawText((int) scoreRect.getWidth() / 4 - FIX_COORDINATES_X,
                (int) scoreRect.getHeight() / 2 + FIX_COORDINATES_Y,
                "Lives:" + lives.getValue(), FONT_SIZE);
        // draw score
        d.drawText((int) scoreRect.getWidth() / 2 - FIX_COORDINATES_X,
                (int) scoreRect.getHeight() / 2 + FIX_COORDINATES_Y,
                "Score:" + score.getValue(), FONT_SIZE);
        // draw level name
        d.drawText((int) scoreRect.getWidth() / 4 * 3 - FIX_COORDINATES_X,
                (int) scoreRect.getHeight() / 2 + FIX_COORDINATES_Y,
                "Level Name:" + levelInformation.levelName(), FONT_SIZE);
    }

    /**
     * A move to do after time has passed.
     */
    @Override
    public void timePassed() {

    }

    /**
     * Add the score to the game.
     *
     * @param g the game.
     */
    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * Sets score.
     *
     * @param score the score
     */
    public void setScore(Counter score) {
        this.score = score;
    }
}
