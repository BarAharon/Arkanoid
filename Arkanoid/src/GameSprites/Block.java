// 209163708 Bar Aharon

package GameSprites;

import Coordinates.Point;
import Coordinates.Velocity;
import GameManagement.GameLevel;
import Interfaces.Collidable;
import Interfaces.HitListener;
import Interfaces.HitNotifier;
import Interfaces.Sprite;
import Shapes.Rectangle;
import biuoop.DrawSurface;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Block.
 *
 * @author Bar Aharon bar.aharon98@gmail.com
 * @version 1.0
 * @since 2022 -08-15.
 */
public class Block implements Collidable, Sprite, HitNotifier {

    private Rectangle block;
    private Color color;
    private List<HitListener> hitListeners;

    /**
     * Instantiates a new Block.
     *
     * @param block the block
     */
    public Block(Rectangle block) {
        this.block = block;
        this.color = Color.GRAY;
        this.hitListeners = new ArrayList<>();
    }

    /**
     * Return the rectangle we collide with.
     *
     * @return rectangle.
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return block;
    }

    /**
     * Return the new velocity after there is a hit.
     *
     * @param collisionPoint  the point of the collision
     * @param currentVelocity the current velocity
     * @return velocity.
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double dx = currentVelocity.getDX(), dy = currentVelocity.getDY();
        // there is hit on the left or right lines
        if (block.getLeftLine().pointIsOnLine(collisionPoint) || block.getRightLine().pointIsOnLine(collisionPoint)) {
            dx = -currentVelocity.getDX();
        }
        // there is hit on the top or bottom lines
        if (block.getTopLine().pointIsOnLine(collisionPoint) || block.getBottomLine().pointIsOnLine(collisionPoint)) {
            dy = -currentVelocity.getDY();
        }
        this.notifyHit(hitter);
        return new Velocity(dx, dy);
    }

    /**
     * Draw the block.
     *
     * @param surface the DrawSurface
     */
    public void drawOn(DrawSurface surface) {
        // draw the block
        surface.setColor(color);
        surface.fillRectangle((int) block.getUpperLeft().getX(), (int) block.getUpperLeft().getY(),
                (int) block.getWidth(), (int) block.getHeight());
        // draw the block border
        surface.setColor(Color.BLACK);
        surface.drawRectangle((int) block.getUpperLeft().getX(), (int) block.getUpperLeft().getY(),
                (int) block.getWidth(), (int) block.getHeight());
    }

    /**
     * A move to do after time has passed.
     */
    @Override
    public void timePassed() {

    }

    /**
     * Add the block to the game.
     *
     * @param g the game.
     */
    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * Sets color.
     *
     * @param color the color
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Remove block from game.
     *
     * @param game the game
     */
    public void removeFromGame(GameLevel game) {
        game.removeCollidable(this);
        game.removeSprite(this);
    }

    /**
     * Add hit listener to block.
     *
     * @param hl the hit listener
     */
    @Override
    public void addHitListener(HitListener hl) {
        hitListeners.add(hl);
    }

    /**
     * Remove hit listener from block.
     *
     * @param hl the hit listener
     */
    @Override
    public void removeHitListener(HitListener hl) {
        hitListeners.remove(hl);
    }

    /**
     * Notify that this block was hit.
     *
     * @param hitter the ball that hit the block
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
}

