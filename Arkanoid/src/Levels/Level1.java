// 209163708 Bar Aharon

package Levels;

import Coordinates.Point;
import Coordinates.Velocity;
import GameSprites.Block;
import GameSprites.Level1Background;
import Interfaces.LevelInformation;
import Interfaces.Sprite;
import Shapes.Rectangle;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The Level 1.
 *
 * @author Bar Aharon bar.aharon98@gmail.com
 * @version 1.0
 * @since 2022-09-06.
 */
public class Level1 implements LevelInformation {
    /**
     * The Balls num.
     */
    static final int BALLS_NUM = 1;
    /**
     * The Paddle speed.
     */
    static final int PADDLE_SPEED = 10;
    /**
     * The Paddle width.
     */
    static final int PADDLE_WIDTH = 60;
    /**
     * The number of Block to remove.
     */
    static final int BLOCK_TO_REMOVE = 1;
    /**
     * The Level name.
     */
    static final String LEVEL_NAME = "Direct Hit";
    /**
     * The Block y coordinate.
     */
    static final int BLOCK_Y = 100;
    /**
     * The Block size.
     */
    static final int BLOCK_SIZE = 30;
    /**
     * The Width.
     */
    static final int WIDTH = 800;
    /**
     * The Ball start angle.
     */
    static final int BALL_START_ANGLE = 270;
    /**
     * The Ball speed.
     */
    static final int BALL_SPEED = 5;

    @Override
    public int numberOfBalls() {
        return BALLS_NUM;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> list = new ArrayList<>();
        if (numberOfBalls() == 1) {
            list.add(new Velocity(0, BALL_SPEED));
        } else {
            for (int i = 0, j = 0; i < numberOfBalls(); i++) {
                // first half balls move to the right
                if (numberOfBalls() / 2 > i) {
                    list.add(Velocity.fromAngleAndSpeed(BALL_START_ANGLE + 10 * (i + 1), BALL_SPEED));
                } else if (numberOfBalls() % 2 == 1 && numberOfBalls() / 2 + 1 == i) {
                    // middle ball move upwards
                    list.add(Velocity.fromAngleAndSpeed(BALL_START_ANGLE, BALL_SPEED));
                } else {
                    // second half balls move to the left
                    list.add(Velocity.fromAngleAndSpeed(BALL_START_ANGLE - 10 * (j + 1), BALL_SPEED));
                    j++;
                }
            }
        }
        return list;
    }

    @Override
    public int paddleSpeed() {
        return PADDLE_SPEED;
    }

    @Override
    public int paddleWidth() {
        return PADDLE_WIDTH;
    }

    @Override
    public String levelName() {
        return LEVEL_NAME;
    }

    @Override
    public Sprite getBackground() {
        return new Level1Background();
    }

    @Override
    public List<Block> blocks() {
        List<Block> list = new ArrayList<>();
        for (int i = 0; i < numberOfBlocksToRemove(); i++) {
            Block block = new Block(new Rectangle(new Point(
                    (double) WIDTH / 2, BLOCK_Y),
                    BLOCK_SIZE, BLOCK_SIZE));
            list.add(block);
            block.setColor(Color.RED);
        }
        return list;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return BLOCK_TO_REMOVE;
    }
}
