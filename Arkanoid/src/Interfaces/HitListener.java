// 209163708 Bar Aharon

package Interfaces;

import GameSprites.Ball;
import GameSprites.Block;

/**
 * The interface Hit listener.
 *
 * @author Bar Aharon bar.aharon98@gmail.com
 * @version 1.0
 * @since 2022-08-29.
 */
public interface HitListener {
    /**
     * This method is called whenever the beingHit object is hit.
     *
     * @param beingHit the being hit
     * @param hitter   the hitter
     */
    void hitEvent(Block beingHit, Ball hitter);
}
