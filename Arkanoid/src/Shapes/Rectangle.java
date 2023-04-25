// 209163708 Bar Aharon

package Shapes;

import Coordinates.Line;
import Coordinates.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Rectangle.
 *
 * @author Bar Aharon bar.aharon98@gmail.com
 * @version 1.0
 * @since 2022 -08-15.
 */
public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;
    private Line topLine;
    private Line bottomLine;
    private Line leftLine;
    private Line rightLine;

    /**
     * Instantiates a new Rectangle.
     *
     * @param upperLeft the upper left
     * @param width     the width
     * @param height    the height
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
        createRectangleLines();
    }

    /**
     * Return a (possibly empty) List of intersection points with the specified line.
     *
     * @param line the line
     * @return the list
     */
    public List<Point> intersectionPoints(Line line) {
        List<Point> list = new ArrayList<>();
        list.add(line.intersectionWith(leftLine));
        list.add(line.intersectionWith(rightLine));
        list.add(line.intersectionWith(topLine));
        list.add(line.intersectionWith(bottomLine));
        while (list.contains(null)) {
            list.remove(null);
        }
        return list;
    }

    /**
     * Gets top line.
     *
     * @return the top line
     */
    public Line getTopLine() {
        return topLine;
    }

    /**
     * Gets bottom line.
     *
     * @return the bottom line
     */
    public Line getBottomLine() {
        return bottomLine;
    }

    /**
     * Gets left line.
     *
     * @return the left line
     */
    public Line getLeftLine() {
        return leftLine;
    }

    /**
     * Gets right line.
     *
     * @return the right line
     */
    public Line getRightLine() {
        return rightLine;
    }

    /**
     * Gets width.
     *
     * @return the width
     */
    public double getWidth() {
        return width;
    }

    /**
     * Gets height.
     *
     * @return the height
     */
    public double getHeight() {
        return height;
    }

    /**
     * Gets upper left.
     *
     * @return the upper left
     */
    public Point getUpperLeft() {
        return upperLeft;
    }

    /**
     * Sets upper left.
     *
     * @param upperLeft the upper left
     */
    public void setUpperLeft(Point upperLeft) {
        this.upperLeft = upperLeft;
        createRectangleLines();
    }

    /**
     * Create rectangle lines.
     */
    public void createRectangleLines() {
        double x = upperLeft.getX();
        double y = upperLeft.getY();
        this.topLine = new Line(x, y, x + width, y);
        this.bottomLine = new Line(x, y + height, x + width, y + height);
        this.leftLine = new Line(x, y, x, y + height);
        this.rightLine = new Line(x + width, y, x + width, y + height);
    }
}

