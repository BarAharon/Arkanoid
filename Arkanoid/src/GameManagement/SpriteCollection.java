// 209163708 Bar Aharon

package GameManagement;

import Interfaces.Sprite;
import biuoop.DrawSurface;
import java.util.ConcurrentModificationException;
import java.util.List;

/**
 * The type Sprite collection.
 *
 * @author Bar Aharon bar.aharon98@gmail.com
 * @version 1.0
 * @since 2022 -08-15.
 */
public class SpriteCollection {
    private List<Sprite> spriteList;

    /**
     * Instantiates a new Sprite collection.
     *
     * @param sprites the sprites
     */
    public SpriteCollection(List<Sprite> sprites) {
        spriteList = sprites;
    }

    /**
     * Add sprite.
     *
     * @param s the sprite
     */
    public void addSprite(Sprite s) {
        spriteList.add(s);
    }

    /**
     * Remove sprite.
     *
     * @param s the sprite
     */
    public void removeSprite(Sprite s) {
        spriteList.remove(s);
    }

    /**
     * Notify all sprites time passed.
     */
    public void notifyAllTimePassed() {
        try {
            for (Sprite sprite : spriteList) {
                sprite.timePassed();
            }
        } catch (ConcurrentModificationException ex) {
            System.out.println("block was removed");
        }
    }

    /**
     * Draw all the sprites.
     *
     * @param d the DrawSurface
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite sprite : spriteList) {
            sprite.drawOn(d);
        }
    }
}

