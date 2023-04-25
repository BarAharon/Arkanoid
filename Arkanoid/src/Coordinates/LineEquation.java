// 209163708 Bar Aharon

package Coordinates;

/**
 * The type Line equation.
 *
 * @author Bar Aharon bar.aharon98@gmail.com
 * @version 1.0
 * @since 2022 -08-04
 */
public class LineEquation {
    private double slope;
    private double freeMember;
    private VerticalLine verticalLine;

    /**
     * Constructor of a line equation.
     *
     * @param slope      the slope of the equation.
     * @param freeMember the free member of the equation.
     */
    public LineEquation(double slope, double freeMember) {
        this.slope = slope;
        this.freeMember = freeMember;
        this.verticalLine = null;
    }

    /**
     * Constructor of a line equation.
     *
     * @param line the line to base the equation.
     */
    public LineEquation(Line line) {
        // if the equation is a vertical line
        if (line.start().getX() - line.end().getX() == 0) {
            this.verticalLine = new VerticalLine(line.start().getX());
            this.slope = 0;
            this.freeMember = 0;
        } else {
            // calculate the slope
            this.slope = (line.start().getY() - line.end().getY()) / (line.start().getX() - line.end().getX());
            // calculate the free member
            this.freeMember = line.start().getY() - this.slope * line.start().getX();
            this.verticalLine = null;
        }
    }

    /**
     * Check if the lines are parallels.
     *
     * @param other another line equation.
     * @return true if parallels, else false.
     */
    public boolean isLinesParallels(LineEquation other) {
        // if one of the lines is vertical
        if (this.verticalLine != null) {
            // check if parallels vertical lines
            return  (other.verticalLine != null);
        } else {
            if (other.verticalLine != null) {
                return false;
            } else {
                // if the lines are not vertical check if parallels
                return (this.slope == other.getSlope());
            }
        }
    }

    /**
     * Check the intersection point of two lines.
     *
     * @param other another line equation.
     * @return intersection point.
     */
    public Point getIntersectionPoint(LineEquation other) {
        if (this.isLinesParallels(other)) {
            return null;
        }
        // calculate the intersection point
        double intersectionSlope = this.slope - other.getSlope();
        double intersectionSlopeFreeMember = other.getFreeMember() - this.getFreeMember();
        // this line is vertical
        if (verticalLine != null) {
            return new Point(verticalLine.getXLine(), other.slope * verticalLine.getXLine() + other.freeMember);
        }
        // the other line is vertical
        if (other.getVerticalLine() != null) {
            return new Point(other.getVerticalLine().getXLine(),
                    slope * other.getVerticalLine().getXLine() + freeMember);
        }
        // the two lines are normal line equations
        double intersectionX = intersectionSlopeFreeMember / intersectionSlope;
        double intersectionY = this.slope * intersectionX + this.getFreeMember();
        return new Point(intersectionX, intersectionY);
    }

    /**
     * Returns the slope point of the equation.
     *
     * @return slope. slope
     */
    public double getSlope() {
        return this.slope;
    }

    /**
     * Returns the free member point of the equation.
     *
     * @return free member.
     */
    public double getFreeMember() {
        return this.freeMember;
    }

    /**
     * Gets vertical line.
     *
     * @return the vertical line
     */
    public VerticalLine getVerticalLine() {
        return verticalLine;
    }
}

