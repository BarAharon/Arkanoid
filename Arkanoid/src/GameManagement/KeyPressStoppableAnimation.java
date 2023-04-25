// 209163708 Bar Aharon

package GameManagement;

import Interfaces.Animation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * The type Key press stoppable animation.
 * When an animation of which is not the game is played,
 * make the choice to do with that animation with the keyboard.
 *
 * @author Bar Aharon bar.aharon98@gmail.com
 * @version 1.0
 * @since 2022-09-06.
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor keyboard;
    private Animation animation;
    private boolean stop;
    private boolean isAlreadyPressed;

    /**
     * Instantiates a new Key press stoppable animation.
     *
     * @param sensor    the keyboard sensor
     * @param animation the animation
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, Animation animation) {
        this.keyboard = sensor;
        this.animation = animation;
        stop = animation.shouldStop();
        isAlreadyPressed = true;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        animation.doOneFrame(d);
        if (keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            // stop this animation
            if (!isAlreadyPressed) {
                stop = true;
            }
        } else {
            // can stop the next stopping animation
            isAlreadyPressed = false;
        }
    }

    @Override
    public boolean shouldStop() {
        return stop;
    }
}
