// 209163708 Bar Aharon

package GameManagement;

import Coordinates.Point;
import Interfaces.Collidable;

/**
 * The type Collision info.
 *
 * @author Bar Aharon bar.aharon98@gmail.com
 * @version 1.0
 * @since 2022 -08-15.
 */
public class CollisionInfo {

    private Point collisionPoint;
    private Collidable collisionObject;

    /**
     * Instantiates a new Collision info.
     *
     * @param collisionPoint  the collision point
     * @param collisionObject the collision object
     */
    public CollisionInfo(Point collisionPoint, Collidable collisionObject) {
        this.collisionPoint = collisionPoint;
        this.collisionObject = collisionObject;
    }

    /**
     * Collision point point.
     *
     * @return the point
     */
// the point at which the collision occurs.
    public Point collisionPoint() {
        return this.collisionPoint;
    }

    /**
     * The collidable object involved in the collision.
     *
     * @return the collidable
     */
    public Collidable collisionObject() {
        return this.collisionObject;
    }
}
