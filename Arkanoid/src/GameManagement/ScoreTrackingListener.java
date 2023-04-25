// 209163708 Bar Aharon

package GameManagement;

import GameSprites.Ball;
import GameSprites.Block;
import Interfaces.HitListener;

/**
 * The type Score tracking listener.
 *
 * @author Bar Aharon bar.aharon98@gmail.com
 * @version 1.0
 * @since 2022-08-29.
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * The Remove score.
     */
    static final int ADD_SCORE = 5;

    /**
     * Instantiates a new Score tracking listener.
     *
     * @param scoreCounter the score counter
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * Add score by hitting a block.
     *
     * @param beingHit the block being hit
     * @param hitter   the ball that hit
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        currentScore.increase(ADD_SCORE);
        beingHit.removeHitListener(this);
    }
}
