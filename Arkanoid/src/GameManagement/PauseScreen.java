// 209163708 Bar Aharon

package GameManagement;

import Interfaces.Animation;
import biuoop.DrawSurface;

/**
 * The Pause screen.
 */
public class PauseScreen implements Animation {
    private boolean stop;
    /**
     * The Font.
     */
    static final int FONT = 32;
    /**
     * The X coordinates to start draw the text.
     */
    static final int X_COORDINATES = 10;

    /**
     * Instantiates a new Pause screen.
     */
    public PauseScreen() {
        this.stop = false;
    }

    /**
     *
     * @param d the DrawSurface
     */
    public void doOneFrame(DrawSurface d) {
        d.drawText(X_COORDINATES, d.getHeight() / 2, "paused -- press space to continue", FONT);
    }

    /**
     * Check if the animation should stop.
     *
     * @return stop
     */
    public boolean shouldStop() {
        return this.stop;
    }
}
