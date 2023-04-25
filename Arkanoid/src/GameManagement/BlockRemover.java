// 209163708 Bar Aharon

package GameManagement;

import GameSprites.Ball;
import GameSprites.Block;
import Interfaces.HitListener;

/**
 *  a BlockRemover is in charge of removing blocks from the game, as well as keeping count
 *  of the number of blocks that remain.
 *
 * @author Bar Aharon bar.aharon98@gmail.com
 * @version 1.0
 * @since 2022-08-29.
 */
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * Instantiates a new Block remover.
     *
     * @param game          the game
     * @param removedBlocks the removed blocks
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBlocks = removedBlocks;
    }

    /**
     * Blocks that are hit should be removed.
     * remove this listener from the blockt hat is being removed from the game.
     *
     * @param beingHit the block being hit
     * @param hitter   the ball that hit
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeFromGame(game);
        remainingBlocks.decrease(1);
        beingHit.removeHitListener(this);
    }
}
