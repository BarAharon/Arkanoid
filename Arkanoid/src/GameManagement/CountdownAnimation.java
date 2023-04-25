// 209163708 Bar Aharon

package GameManagement;

import Interfaces.Animation;
import biuoop.DrawSurface;
import biuoop.Sleeper;
import java.awt.Color;

/**
 * The Countdown animation.
 *
 * @author Bar Aharon bar.aharon98@gmail.com
 * @version 1.0
 * @since 2022-09-06.
 */
public class CountdownAnimation implements Animation {
    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private boolean stop;

    /**
     * The Font size.
     */
    static final int FONT_SIZE = 30;

    /**
     * The Milliseconds per frame.
     */
    static final int MILLISECONDS_PER_FRAME = 1500;

    /**
     * Instantiates a new Countdown animation.
     *
     * @param numOfSeconds the num of seconds of each count
     * @param countFrom    the number to count from to zero
     * @param gameScreen   all the game sprites
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        stop = false;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        Sleeper sleeper = new Sleeper();
        double millisecondsPerFrame = MILLISECONDS_PER_FRAME / numOfSeconds;
        long startTime = System.currentTimeMillis();
        // draw all the sprites
        gameScreen.drawAllOn(d);
        d.setColor(Color.RED);
        // draw the count
        d.drawText(d.getWidth() / 2, d.getHeight() / 2, String.valueOf(countFrom), FONT_SIZE);
        long usedTime = System.currentTimeMillis() - startTime;
        long milliSecondLeftToSleep = (long) millisecondsPerFrame - usedTime;
        if (milliSecondLeftToSleep > 0) {
            sleeper.sleepFor(milliSecondLeftToSleep);
        }
        countFrom--;
        // the animation needs to stop
        if (countFrom == -1) {
            stop = true;
        }
    }

    @Override
    public boolean shouldStop() {
        return stop;
    }
}
