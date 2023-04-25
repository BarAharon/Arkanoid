// 209163708 Bar Aharon

package GameManagement;

import GameSprites.Ball;
import GameSprites.Block;
import Interfaces.HitListener;

/**
 *  a BallRemover is in charge of removing balls from the game, as well as keeping count
 *  of the number of balls that remain.
 *
 * @author Bar Aharon bar.aharon98@gmail.com
 * @version 1.0
 * @since 2022-08-29.
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;

    /**
     * Instantiates a new Ball remover.
     *
     * @param game         the game
     * @param removedBalls the removed balls
     */
    public BallRemover(GameLevel game, Counter removedBalls) {
        this.game = game;
        this.remainingBalls = removedBalls;
    }

    /**
     * Balls that are hit the bottom block should be removed from the game.
     *
     * @param beingHit the block being hit
     * @param hitter   the ball that hit
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(game);
        remainingBalls.decrease(1);
    }
}
