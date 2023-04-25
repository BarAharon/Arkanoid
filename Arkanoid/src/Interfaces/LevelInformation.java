// 209163708 Bar Aharon

package Interfaces;

import GameSprites.Block;
import Coordinates.Velocity;
import java.util.List;

/**
 * The interface Level information.
 *
 * @author Bar Aharon bar.aharon98@gmail.com
 * @version 1.0
 * @since 2022-09-06.
 */
public interface LevelInformation {
    /**
     * Number of balls in this level.
     *
     * @return the number of balls
     */
    int numberOfBalls();

    /**
     * The initial velocity of each ball.
     *
     * @return the list of balls velocities
     */
    List<Velocity> initialBallVelocities();

    /**
     * The paddle speed.
     *
     * @return the speed
     */
    int paddleSpeed();

    /**
     * The paddle width.
     *
     * @return the width
     */
    int paddleWidth();

    /**
     * The level name.
     *
     * @return the name
     */
    String levelName();

    /**
     * Gets background.
     *
     * @return the background
     */
    Sprite getBackground();

    /**
     * Blocks list.
     *
     * @return the list
     */
    List<Block> blocks();

    /**
     * Number of blocks to remove.
     *
     * @return the number of blocks to remove
     */
    int numberOfBlocksToRemove();
}
