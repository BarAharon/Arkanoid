// 209163708 Bar Aharon

package GameManagement;

import Interfaces.LevelInformation;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import java.util.List;

/**
 * The type Game flow.
 * basically run the levels.
 *
 * @author Bar Aharon bar.aharon98@gmail.com
 * @version 1.0
 * @since 2022-09-06.
 */
public class GameFlow {
    private AnimationRunner runner;
    private KeyboardSensor keyboardSensor;
    private Counter blockCounter;
    private Counter ballCounter;
    private Counter score;
    private Counter lives;
    private GUI gui;

    /**
     * increase the score by winning a level.
     */
    static final int WIN_LEVEL_SCORE = 100;
    /**
     * The Num of lives.
     */
    static final int NUM_OF_LIVES = 3;

    /**
     * Instantiates a new Game flow.
     *
     * @param ar  the AnimationRunner
     * @param ks  the keyboard
     * @param gui the gui
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks, GUI gui) {
        runner = ar;
        keyboardSensor = ks;
        this.blockCounter = new Counter();
        this.ballCounter = new Counter();
        this.score = new Counter();
        this.lives = new Counter();
        this.gui = gui;
    }

    /**
     * Run the levels.
     *
     * @param levels list of all the level to do
     */
    public void runLevels(List<LevelInformation> levels) {
        // init the lives
        lives.increase(NUM_OF_LIVES);
        for (LevelInformation levelInfo : levels) {
            ballCounter = new Counter();
            // create new level
            GameLevel level = new GameLevel(levelInfo, ballCounter, blockCounter, score, lives, runner, gui);
            blockCounter.increase(levelInfo.numberOfBlocksToRemove());
            ballCounter.increase(levelInfo.numberOfBalls());
            // init the level
            level.initialize();
            // while the player didn't lose
            while (lives.getValue() != 0) {
                // while the number of balls did not drop to 0 or there are still blocks
                while (blockCounter.getValue() != 0 && ballCounter.getValue() != 0) {
                    level.run();
                }
                // the player won the level
                if (blockCounter.getValue() == 0) {
                    score.increase(WIN_LEVEL_SCORE);
                    break;
                }
                // the player lost 1 life
                if (ballCounter.getValue() == 0) {
                    lives.decrease(1);
                    ballCounter.increase(levelInfo.numberOfBalls());
                }
            }
            // the player lost
            if (lives.getValue() == 0) {
                runner.run(new KeyPressStoppableAnimation(keyboardSensor, new EndScreen(false, score)));
                gui.close();
            }
        }
        // the player won
        if (lives.getValue() != 0) {
            runner.run(new KeyPressStoppableAnimation(keyboardSensor, new EndScreen(true, score)));
            gui.close();
        }
    }
}
