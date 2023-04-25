// 209163708 Bar Aharon

package Coordinates;

import Shapes.Rectangle;

import java.util.List;

/**
 * The type Line.
 *
 * @author Bar Aharon bar.aharon98@gmail.com
 * @version 1.0
 * @since 2022 -08-04
 */
public class Line {
    private Point start;
    private Point end;

    /**
     * The Epsilon.
     */
    static final double EPSILON = 0.000001;

    /**
     * Constructor of a line.
     *
     * @param start the start point of the line.
     * @param end   the end point of the line.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Constructor of a line.
     *
     * @param x1 the x start point of the line.
     * @param y1 the y start point of the line.
     * @param x2 the x end point of the line.
     * @param y2 the y end point of the line.
     */
    public Line(double x1, double y1, double x2, double y2) {
        Point start = new Point(x1, y1);
        Point end = new Point(x2, y2);
        this.start = start;
        this.end = end;
    }

    /**
     * Return the length of the line.
     *
     * @return length. double
     */
    public double length() {
        return this.start.distance(this.end);
    }

    /**
     * Returns the middle point of the line.
     *
     * @return middle. point
     */
    public Point middle() {
        double middleX = (this.start.getX() + this.end.getX()) / 2;
        double middleY = (this.start.getY() + this.end.getY()) / 2;
        return new Point(middleX, middleY);
    }

    /**
     * Returns the start point of the line.
     *
     * @return start. point
     */
    public Point start() {
        return this.start;
    }

    /**
     * Returns the end point of the line.
     *
     * @return end. point
     */
    public Point end() {
        return this.end;
    }

    /**
     * Check whether the given point is on the line or not.
     *
     * @param p the given point.
     * @return true if on the point, false if not.
     */
    public boolean pointIsOnLine(Point p) {
        double dxc = p.getX() - start.getX();
        double dyc = p.getY() - start.getY();

        double dxl = end.getX() - start.getX();
        double dyl = end.getY() - start.getY();

        double cross = dxc * dyl - dyc * dxl;

        // make calculate less precise
        if (Math.abs(cross) > EPSILON) {
            return false;
        }

        // if the point is on the line
        if (Math.abs(dxl) >= Math.abs(dyl)) {
            return dxl > 0
                    ? start.getX() <= p.getX() && p.getX() <= end.getX()
                    : end.getX() <= p.getX() && p.getX() <= start.getX();
        } else {
            return dyl > 0
                    ? start.getY() <= p.getY() && p.getY() <= end.getY()
                    : end.getY() <= p.getY() && p.getY() <= start.getY();
        }
    }

    /**
     * Check the direction of 3 parameters of point of lines.
     *
     * @param a the given point.
     * @param b the given point.
     * @param c the given point.
     * @return true if on the point, false if not.
     */
    int direction(Point a, Point b, Point c) {
        double val = (b.getY() - a.getY()) * (c.getX() - b.getX()) - (b.getX() - a.getX()) * (c.getY() - b.getY());
        if (val == 0) {
            // collinear
            return 0;
        } else if (val < 0) {
            // anti-clockwise direction
            return 2;
        }
        // clockwise direction
        return 1;
    }

    /**
     * Check if this line is intersecting with the given one.
     *
     * @param other the given line.
     * @return true if intersecting, false if not.
     */
    public boolean isIntersecting(Line other) {
        // four direction for two lines and points of other line
        int dir1 = direction(this.start(), this.end(), other.start());
        int dir2 = direction(this.start(), this.end(), other.end());
        int dir3 = direction(other.start(), other.end(), this.start());
        int dir4 = direction(other.start(), other.end(), this.end());

        if (dir1 != dir2 && dir3 != dir4) {
            return true; // they are intersecting
        }
        if (dir1 == 0 && pointIsOnLine(other.start())) {
            // when p2 of line2 are on the line1
            return true;
        }
        if (dir2 == 0 && pointIsOnLine(other.end())) {
            // when p1 of line2 are on the line1
            return true;
        }
        if (dir3 == 0 && other.pointIsOnLine(this.start())) {
            // when p2 of line1 are on the line2
            return true;
        }
        if (dir4 == 0 && other.pointIsOnLine(this.end())) {
            // when p1 of line1 are on the line2
            return true;
        }
        return false;
    }

    /**
     * Returns the intersection point of two lines if they are intersecting else null.
     *
     * @param other the given line.
     * @return intersection point.
     */
    public Point intersectionWith(Line other) {
        LineEquation thisLine = new LineEquation(this);
        LineEquation otherLine = new LineEquation(other);
        if (this.isIntersecting(other)) {
            Point p = thisLine.getIntersectionPoint(otherLine);
            if (p != null) {
                if (pointIsOnLine(p) || other.pointIsOnLine(p)) {
                    return p;
                } else {
                    return null;
                }
            }
        }
        return null;
    }

    /**
     * Return true is the lines are equal, false otherwise.
     *
     * @param other the given line.
     * @return true if equal, else false.
     */
    public boolean equals(Line other) {
        return (this.start.equals(other.start) && this.end.equals(other.end));
    }

    /**
     * Closest intersection to start of line.
     *
     * @param rect the rect
     * @return the point
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> list = rect.intersectionPoints(this);
        if (list.isEmpty()) {
            return null;
        }
        Point closestIntersectionPoint = list.get(0);
        // move on all the possible intersections point and get the closest one
        for (int i = 1; i < list.size(); i++) {
            if (this.start.distance(list.get(i)) < this.start.distance(closestIntersectionPoint)) {
                closestIntersectionPoint = list.get(i);
            }
        }
        return closestIntersectionPoint;
    }
}
