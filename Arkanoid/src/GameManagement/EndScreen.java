// 209163708 Bar Aharon

package GameManagement;

import Interfaces.Animation;
import biuoop.DrawSurface;

/**
 * The End screen animation.
 *
 * @author Bar Aharon bar.aharon98@gmail.com
 * @version 1.0
 * @since 2022-09-06.
 */
public class EndScreen implements Animation {
    private boolean hasWon;
    private Counter score;

    /**
     * The Font.
     */
    static final int FONT = 32;
    /**
     * The X coordinates to start draw the text.
     */
    static final int X_COORDINATES = 10;

    /**
     * Instantiates a new End screen.
     *
     * @param hasWon if the player won the game
     * @param score  the score
     */
    public EndScreen(boolean hasWon, Counter score) {
        this.hasWon = hasWon;
        this.score = score;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        if (hasWon) {
            // the player won
            d.drawText(X_COORDINATES, d.getHeight() / 2, "You Win! Your score is " + score.getValue(), FONT);
        } else {
            // the player lose
            d.drawText(X_COORDINATES, d.getHeight() / 2, "Game Over. Your score is " + score.getValue(), FONT);
        }
    }

    @Override
    public boolean shouldStop() {
        return false;
    }
}
