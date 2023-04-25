// 209163708 Bar Aharon

package Coordinates;

/**
 * The type Velocity.
 *
 * @author Bar Aharon bar.aharon98@gmail.com
 * @version 1.0
 * @since 2022 -08-04
 */
public class Velocity {
    private double dx;
    private double dy;

    /**
     * Constructor of velocity.
     *
     * @param dx the speed in x direction.
     * @param dy the speed in y direction.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * Static function that changes the velocity by angle and speed.
     *
     * @param angle the angle.
     * @param speed the speed.
     * @return velocity. velocity
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        angle = Math.toRadians(angle);
        double dx = Math.cos(angle) * speed;
        double dy = Math.sin(angle) * speed;
        return new Velocity(dx, dy);
    }

    /**
     * Take a point with position (x,y) and return a new point with position (x+dx, y+dy).
     *
     * @param p the current point.
     * @return new point to stand.
     */
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + this.dx, p.getY() + this.dy);
    }

    /**
     * Return the dx of this velocity.
     *
     * @return dx. dx
     */
    public double getDX() {
        return this.dx;
    }

    /**
     * Return the dy of this velocity.
     *
     * @return dy. dy
     */
    public double getDY() {
        return this.dy;
    }

    /**
     * Set the dx of the velocity.
     *
     * @param dx the x of the velocity.
     */
    public void setDX(double dx) {
        this.dx = dx;
    }

    /**
     * Set the dy of the velocity.
     *
     * @param dy the x of the velocity.
     */
    public void setDY(double dy) {
        this.dy = dy;
    }
}
