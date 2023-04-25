// 209163708 Bar Aharon

package Interfaces;

import Coordinates.Point;
import Coordinates.Velocity;
import GameSprites.Ball;
import Shapes.Rectangle;

/**
 * The interface Collidable.
 *
 * @author Bar Aharon bar.aharon98@gmail.com
 * @version 1.0
 * @since 2022-08-15.
 */
public interface Collidable {
    /**
     * Return the collision shape of the object.
     *
     * @return the collision rectangle
     */
    Rectangle getCollisionRectangle();

    /**
     * Notify the object that we collided with it at collisionPoint with a given velocity,
     * The return is the new velocity expected after the hit.
     *
     * @param collisionPoint  the collision point
     * @param currentVelocity the current velocity
     * @param hitter          the ball that hit
     * @return the velocity
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}

