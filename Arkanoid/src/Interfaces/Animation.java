// 209163708 Bar Aharon

package Interfaces;

import biuoop.DrawSurface;

/**
 * The interface Animation.
 *
 * @author Bar Aharon bar.aharon98@gmail.com
 * @version 1.0
 * @since 2022-09-06.
 */
public interface Animation {
    /**
     * Do one frame of the animation.
     *
     * @param d the DrawSurface
     */
    void doOneFrame(DrawSurface d);

    /**
     * Should stop the animation.
     *
     * @return the if the animation should stop
     */
    boolean shouldStop();
}
