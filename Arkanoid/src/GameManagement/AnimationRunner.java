// 209163708 Bar Aharon

package GameManagement;

import Interfaces.Animation;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * Run the animation.
 *
 * @author Bar Aharon bar.aharon98@gmail.com
 * @version 1.0
 * @since 2022-09-06.
 */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;

    /**
     * The Milliseconds per frame.
     */
    static final int MILLISECONDS_PER_FRAME = 1000;

    /**
     * Instantiates a new Animation runner.
     *
     * @param framesPerSecond the frames per second
     * @param gui             the gui
     */
    public AnimationRunner(int framesPerSecond, GUI gui) {
        this.framesPerSecond = framesPerSecond;
        this.gui = gui;
    }

    /**
     * Run the animation.
     *
     * @param animation the animation to run
     */
    public void run(Animation animation) {
        Sleeper sleeper = new Sleeper();
        int millisecondsPerFrame = MILLISECONDS_PER_FRAME / framesPerSecond;
        while (!animation.shouldStop()) {
            // timing
            long startTime = System.currentTimeMillis();
            DrawSurface d = gui.getDrawSurface();
            animation.doOneFrame(d);
            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}
