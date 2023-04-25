// 209163708 Bar Aharon

package Levels;

import Coordinates.Point;
import Coordinates.Velocity;
import GameSprites.Block;
import GameSprites.Level2Background;
import Interfaces.LevelInformation;
import Interfaces.Sprite;
import Shapes.Rectangle;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The Level 2.
 *
 * @author Bar Aharon bar.aharon98@gmail.com
 * @version 1.0
 * @since 2022-09-06.
 */
public class Level2 implements LevelInformation {
    /**
     * The Balls num.
     */
    static final int BALLS_NUM = 10;
    /**
     * The Width.
     */
    static final int WIDTH = 800;
    /**
     * The Border size.
     */
    static final double BORDER_SIZE = 10;
    /**
     * The Paddle speed.
     */
    static final int PADDLE_SPEED = 2;
    /**
     * The Paddle width.
     */
    static final int PADDLE_WIDTH = WIDTH - 300;
    /**
     * The Block to remove.
     */
    static final int BLOCK_TO_REMOVE = 15;
    /**
     * The Block width.
     */
    static final double BLOCK_WIDTH = (WIDTH - BORDER_SIZE * 2) / BLOCK_TO_REMOVE;
    /**
     * The Block height.
     */
    static final double BLOCK_HEIGHT = 20;
    /**
     * The Level name.
     */
    static final String LEVEL_NAME = "Wide Easy";
    /**
     * The Ball start angle.
     */
    static final int BALL_START_ANGLE = 270;
    /**
     * The Ball speed.
     */
    static final int BALL_SPEED = 5;
    /**
     * The Block y coordinate.
     */
    static final int BLOCK_Y = 250;
    @Override
    public int numberOfBalls() {
        return BALLS_NUM;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> list = new ArrayList<>();
        for (int i = 0, j = 0; i < numberOfBalls(); i++) {
            if (numberOfBalls() / 2 > i) {
                list.add(Velocity.fromAngleAndSpeed(BALL_START_ANGLE + 10 * (i + 1), BALL_SPEED));
            } else if (numberOfBalls() % 2 == 1 && numberOfBalls() / 2 + 1 == i) {
                list.add(Velocity.fromAngleAndSpeed(BALL_START_ANGLE, BALL_SPEED));
            } else {
                list.add(Velocity.fromAngleAndSpeed(BALL_START_ANGLE - 10 * (j + 1), BALL_SPEED));
                j++;
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
        return new Level2Background();
    }

    @Override
    public List<Block> blocks() {
        List<Block> list = new ArrayList<>();
        // create the blocks
        for (int i = 0; i < numberOfBlocksToRemove(); i++) {
            Block block = new Block(new Rectangle(new Point(
                    BORDER_SIZE + BLOCK_WIDTH * i, BLOCK_Y),
                    BLOCK_WIDTH, BLOCK_HEIGHT));
            list.add(block);
            // set the blocks color
            switch (i) {
                case 0:
                    block.setColor(Color.RED);
                    break;
                case 1:
                    block.setColor(Color.RED);
                    break;
                case 2:
                    block.setColor(Color.ORANGE);
                    break;
                case 3:
                    block.setColor(Color.ORANGE);
                    break;
                case 4:
                    block.setColor(Color.YELLOW);
                    break;
                case 5:
                    block.setColor(Color.YELLOW);
                    break;
                case 6:
                    block.setColor(Color.GREEN);
                    break;
                case 7:
                    block.setColor(Color.GREEN);
                    break;
                case 8:
                    block.setColor(Color.GREEN);
                    break;
                case 9:
                    block.setColor(Color.BLUE);
                    break;
                case 10:
                    block.setColor(Color.BLUE);
                    break;
                case 11:
                    block.setColor(Color.PINK);
                    break;
                case 12:
                    block.setColor(Color.PINK);
                    break;
                case 13:
                    block.setColor(Color.CYAN);
                    break;
                case 14:
                    block.setColor(Color.CYAN);
                    break;
                default:
                    break;
            }
        }
        return list;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return BLOCK_TO_REMOVE;
    }
}
