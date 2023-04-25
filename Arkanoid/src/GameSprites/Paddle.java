// 209163708 Bar Aharon

package GameSprites;

import Coordinates.Line;
import Coordinates.Velocity;
import Coordinates.Point;
import GameManagement.GameLevel;
import Interfaces.Collidable;
import Interfaces.Sprite;
import Shapes.Rectangle;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * The type Paddle.
 *
 * @author Bar Aharon bar.aharon98@gmail.com
 * @version 1.0
 * @since 2022 -08-15.
 */
public class Paddle implements Sprite, Collidable {
    private KeyboardSensor keyboard;
    private GUI gui;
    private Rectangle paddle;
    private int width;
    private int speed;

    /**
     * The Paddle height.
     */
    static final double PADDLE_HEIGHT = 10;
    /**
     * The Num regions.
     */
    static final int NUM_REGIONS = 5;
    /**
     * The start Angle.
     */
    static final double ANGLE = 210;
    /**
     * The Right angle.
     */
    static final double RIGHT_ANGLE = 330;
    /**
     * The Paddle color.
     */
    static final Color PADDLE_COLOR = Color.YELLOW;

    /**
     * Instantiates a new Paddle.
     *
     * @param gui   the gui
     * @param width the paddle width
     * @param speed the paddle speed
     */
    public Paddle(GUI gui, int width, int speed) {
        keyboard = gui.getKeyboardSensor();
        this.gui = gui;
        paddle = new Rectangle(new Point((double) gui.getDrawSurface().getWidth() / 2 - (double) width / 2,
                (double) gui.getDrawSurface().getHeight() -  PADDLE_HEIGHT),
                width, PADDLE_HEIGHT);
        this.width = width;
        this.speed = speed;
    }

    /**
     * Move the paddle to left.
     */
    public void moveLeft() {
        if (!(paddle.getUpperLeft().getX() - speed < 0)) {
            paddle.setUpperLeft(new Point(paddle.getUpperLeft().getX() - speed,
                    paddle.getUpperLeft().getY()));
        }
    }

    /**
     * Move the paddle to right.
     */
    public void moveRight() {
        if (!(paddle.getUpperLeft().getX() + paddle.getWidth() + speed > gui.getDrawSurface().getWidth())) {
            paddle.setUpperLeft(new Point(paddle.getUpperLeft().getX() + speed,
                    paddle.getUpperLeft().getY()));
        }
    }


    /**
     * A move to do after time has passed.
     */
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
    }

    /**
     * Draw the paddle.
     *
     * @param d the DrawSurface
     */
    public void drawOn(DrawSurface d) {
        d.setColor(PADDLE_COLOR);
        d.fillRectangle((int) paddle.getUpperLeft().getX(), (int) paddle.getUpperLeft().getY(),
                (int) paddle.getWidth(), (int) paddle.getHeight());
    }

    /**
     * Return the rectangle we collide with.
     *
     * @return rectangle.
     */
    public Rectangle getCollisionRectangle() {
        return paddle;
    }

    /**
     * Return the new velocity after there is a hit.
     *
     * @param collisionPoint  the point of the collision
     * @param currentVelocity the current velocity
     * @param hitter          the ball that hit the paddle
     * @return velocity.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double dx = currentVelocity.getDX(), dy = currentVelocity.getDY();
        // calculates the speed
        double speed = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
        // create 5 regions on the paddle
        Line[] regions = new Line[NUM_REGIONS];
        for (int i = 0; i < NUM_REGIONS; i++) {
            regions[i] = new Line(paddle.getUpperLeft().getX() + (double) width / NUM_REGIONS * i,
                    paddle.getUpperLeft().getY(),
                    paddle.getUpperLeft().getX() + (double) width / NUM_REGIONS * i + (double) width / NUM_REGIONS,
                    paddle.getUpperLeft().getY());
        }
        // if there is a hit on one of the regions
        for (int i = 0; i < NUM_REGIONS; i++) {
            if (regions[i].pointIsOnLine(collisionPoint)) {
                return Velocity.fromAngleAndSpeed(ANGLE + 30 * i, speed);
            }
        }
        // there is a hit on the right side of the paddle
        if (paddle.getRightLine().pointIsOnLine(collisionPoint)) {
            return Velocity.fromAngleAndSpeed(RIGHT_ANGLE, speed);
        }
        // there is a hit on the left side of the paddle
        if (paddle.getLeftLine().pointIsOnLine(collisionPoint)) {
            return Velocity.fromAngleAndSpeed(ANGLE, speed);
        }
        return currentVelocity;
    }

    /**
     * Add the paddle to the game.
     *
     * @param g the game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
}
