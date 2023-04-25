// 209163708 Bar Aharon

package Coordinates;

/**
 * The type Point.
 *
 * @author Bar Aharon bar.aharon98@gmail.com
 * @version 1.0
 * @since 2022 -08-04
 */
public class Point {
    private double x;
    private double y;

    /**
     * Constructor of a point.
     *
     * @param x the x point.
     * @param y the y point.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Return the distance of this point to the other point.
     *
     * @param other another point.
     * @return the distance.
     */
    public double distance(Point other) {
        double pointX = Math.pow(this.x - other.getX(), 2);
        double pointY = Math.pow(this.y - other.getY(), 2);
        return Math.sqrt(pointX + pointY);
    }

    /**
     * Return true is the points are equal, false otherwise.
     *
     * @param other another Point.
     * @return if equals.
     */
    public boolean equals(Point other) {
        return (other.getX() == this.x && other.getY() == this.y);
    }

    /**
     * Return the x of this point.
     *
     * @return x. x
     */
    public double getX() {
        return this.x;
    }

    /**
     * Return the y of this point.
     *
     * @return y. y
     */
    public double getY() {
        return this.y;
    }

    /**
     * Set the x of the point.
     *
     * @param x the x of the point.
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Set the y of the point.
     *
     * @param y the x of the point.
     */
    public void setY(double y) {
        this.y = y;
    }
}