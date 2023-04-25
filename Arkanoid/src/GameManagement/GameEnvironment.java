// 209163708 Bar Aharon

package GameManagement;

import Coordinates.Line;
import Coordinates.Point;
import Interfaces.Collidable;
import java.util.List;

/**
 * The type Game environment.
 *
 * @author Bar Aharon bar.aharon98@gmail.com
 * @version 1.0
 * @since 2022 -08-15.
 */
public class GameEnvironment {
    private List<Collidable> objects;

    /**
     * Instantiates a new Game environment.
     *
     * @param objects the objects
     */
    public GameEnvironment(List<Collidable> objects) {
        this.objects = objects;
    }

    /**
     * Add collidable.
     *
     * @param c the collidable
     */
    public void addCollidable(Collidable c) {
        this.objects.add(c);
    }

    /**
     * Remove collidable.
     *
     * @param c the collidable
     */
    public void removeCollidable(Collidable c) {
        this.objects.remove(c);
    }

    /**
     * Gets closest collision.
     *
     * @param trajectory the trajectory
     * @return the closest collision
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        CollisionInfo closestCollision = null;
        for (Collidable object : this.objects) {
            // get a collision point
            Point collisionPoint = trajectory.closestIntersectionToStartOfLine(object.getCollisionRectangle());
            // get the closest collision point there is
            if (collisionPoint != null) {
                if (closestCollision == null
                        || trajectory.start().distance(closestCollision.collisionPoint())
                        > trajectory.start().distance(collisionPoint)) {
                    closestCollision = new CollisionInfo(collisionPoint, object);
                }
            }
        }
        return closestCollision;
    }

    /**
     * Gets the game environment objects.
     *
     * @return the objects
     */
    public List<Collidable> getObjects() {
        return objects;
    }
}
