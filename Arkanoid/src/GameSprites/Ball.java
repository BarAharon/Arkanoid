// 209163708 Bar Aharon

package GameSprites;

import Coordinates.Line;
import Coordinates.Point;
import Coordinates.Velocity;
import GameManagement.CollisionInfo;
import GameManagement.GameLevel;
import GameManagement.GameEnvironment;
import Interfaces.Sprite;
import biuoop.DrawSurface;
import java.awt.Color;
import java.util.ArrayList;

/**
 * The type Ball.
 *
 * @author Bar Aharon bar.aharon98@gmail.com
 * @version 1.0
 * @since 2022 -08-15.
 */
public class Ball implements Sprite {
    private Point center;
    private int radius;
    private Color color;
    private Velocity velocity;
    private int leftScreen;
    private int topScreen;
    private GameEnvironment gameEnvironment;

    /**
     * The Default right screen.
     */
    static final int DEFAULT_RIGHT_SCREEN = 400;
    /**
     * The Default bottom screen.
     */
    static final int DEFAULT_BOTTOM_SCREEN = 400;
    /**
     * The Max speed radius.
     */
    static final int MAX_SPEED_RADIUS = 50;
    /**
     * The Slowest velocity.
     */
    static final Velocity SLOWEST_VELOCITY = new Velocity(1, 1);

    /**
     * Constructor of a ball.
     *
     * @param center the center point of the ball.
     * @param radius the radius of the ball.
     * @param color  the color of the ball.
     */
    public Ball(Point center, int radius, Color color) {
        this.center = center;
        this.radius = radius;
        this.color = color;
        this.velocity = makeBallVelocityByRadius();
        this.leftScreen = 0;
        this.topScreen = 0;
        this.gameEnvironment = new GameEnvironment(new ArrayList<>());
    }

    /**
     * Constructor of a ball.
     *
     * @param x      the x point of the center of the ball.
     * @param y      the y point of the center of the ball.
     * @param radius the radius of the ball.
     * @param color  the color of the ball.
     */
    public Ball(int x, int y, int radius, Color color) {
        this.center.setX(x);
        this.center.setY(y);
        this.radius = radius;
        this.color = color;
        this.velocity = makeBallVelocityByRadius();
        this.leftScreen = 0;
        this.topScreen = 0;
        this.gameEnvironment = new GameEnvironment(new ArrayList<>());
    }

    /**
     * Return the x point of the center of the ball.
     *
     * @return x point.
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * Return the y point of the center of the ball.
     *
     * @return y point.
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * Set the x point of the center of the ball.
     *
     * @param x the x point.
     */
    public void setX(double x) {
        this.center.setX(x);
    }

    /**
     * Set the y point of the center of the ball.
     *
     * @param y the x point.
     */
    public void setY(double y) {
        this.center.setY(y);
    }

    /**
     * Return the radius of the ball.
     *
     * @return radius. size
     */
    public int getSize() {
        return this.radius;
    }

    /**
     * Return the color of the ball.
     *
     * @return color. color
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Return the left limit of the screen of the ball.
     *
     * @return left limit.
     */
    public int getLeftScreen() {
        return this.leftScreen;
    }

    /**
     * Set the left limit of the screen of the ball.
     *
     * @param leftScreen the left limit.
     */
    public void setLeftScreen(int leftScreen) {
        this.leftScreen = leftScreen;
    }

    /**
     * Return the top limit of the screen of the ball.
     *
     * @return top limit.
     */
    public int getTopScreen() {
        return this.topScreen;
    }

    /**
     * Set the top limit of the screen of the ball.
     *
     * @param topScreen the top limit.
     */
    public void setTopScreen(int topScreen) {
        this.topScreen = topScreen;
    }

    /**
     * Set the radius of the ball.
     *
     * @param radius the new radius.
     */
    public void setSize(int radius) {
        this.radius = radius;
    }

    /**
     * Set the velocity of the ball.
     *
     * @param velocity the new velocity.
     */
    public void setVelocity(Velocity velocity) {
        this.velocity = velocity;
    }

    /**
     * Set the velocity of the ball.
     *
     * @param dx the new dx point of the velocity.
     * @param dy the new dy point of the velocity.
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }

    /**
     * Return the velocity of the ball.
     *
     * @return the velocity of the ball.
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * Gets game environment.
     *
     * @return the game environment
     */
    public GameEnvironment getGameEnvironment() {
        return gameEnvironment;
    }

    /**
     * Sets game environment.
     *
     * @param gameEnvironment the game environment
     */
    public void setGameEnvironment(GameEnvironment gameEnvironment) {
        this.gameEnvironment = gameEnvironment;
    }

    /**
     * Draw the ball on the given DrawSurface.
     * @param surface the given DrawSurface.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.getColor());
        surface.fillCircle(this.getX(), this.getY(), this.getSize());
        surface.setColor(Color.BLACK);
        surface.drawCircle(this.getX(), this.getY(), this.getSize());
    }

    /**
     * Make a move once time has passed.
     */
    @Override
    public void timePassed() {
        moveOneStep();
    }

    /**
     * Make the ball to move one step.
     */
    public void moveOneStep() {
        Point nextStep = this.velocity.applyToPoint(this.center);
        // check if there is a collision in the ball trajectory
        CollisionInfo collisionInfo = this.gameEnvironment.getClosestCollision(this.getBallTrajectory());

        // there isn't a collision
        if (collisionInfo == null) {
            // can move to the next point
            this.center = nextStep;
            return;
        } else {
            // set the new velocity after the hit
            this.setVelocity(collisionInfo.collisionObject().hit(this,
                    collisionInfo.collisionPoint(), this.velocity));
        }
    }

    /**
     * Check if the ball is out of screen in the next step.
     *
     * @param nextStep the next step
     * @return if the ball is out of screen in the next step.
     */

    /**
     * Gets ball trajectory.
     *
     * @return the ball trajectory
     */
    public Line getBallTrajectory() {
        return new Line(center, new Point(center.getX() + this.getVelocity().getDX(),
                center.getY() + this.getVelocity().getDY()));
    }

    /**
     * Create the velocity of the ball by his radius.
     *
     * @return the new velocity of the ball.
     */
    public Velocity makeBallVelocityByRadius() {
        // all balls over 50 radius shall have the same velocity
        if (this.radius >= MAX_SPEED_RADIUS) {
            return SLOWEST_VELOCITY;
        }
        // make the ball velocity by his radius
        return new Velocity(MAX_SPEED_RADIUS - this.radius, MAX_SPEED_RADIUS - this.radius);
    }

    /**
     * Add the ball to the game.
     *
     * @param g the game.
     */
    @Override
    public  void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * Remove ball from game.
     *
     * @param g the game
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }
}
