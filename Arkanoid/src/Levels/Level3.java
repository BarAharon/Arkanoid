// 209163708 Bar Aharon

package Levels;

import Coordinates.Point;
import Coordinates.Velocity;
import GameSprites.Block;
import GameSprites.Level3Background;
import Interfaces.LevelInformation;
import Interfaces.Sprite;
import Shapes.Rectangle;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The Level 3.
 *
 * @author Bar Aharon bar.aharon98@gmail.com
 * @version 1.0
 * @since 2022-09-06.
 */
public class Level3 implements LevelInformation {
    /**
     * The Balls num.
     */
    static final int BALLS_NUM = 2;
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
    static final int PADDLE_SPEED = 7;
    /**
     * The Paddle width.
     */
    static final int PADDLE_WIDTH = 100;
    /**
     * The Block to remove.
     */
    static final int BLOCK_TO_REMOVE = 40;
    /**
     * The Block height.
     */
    static final double BLOCK_HEIGHT = 20;
    /**
     * The Level name.
     */
    static final String LEVEL_NAME = "Green 3";
    /**
     * The Ball start angle.
     */
    static final int BALL_START_ANGLE = 270;
    /**
     * The Ball speed.
     */
    static final int BALL_SPEED = 5;
    /**
     * The Block start y coordinate.
     */
    static final int BLOCK_START_Y = 150;
    /**
     * The Block rows.
     */
    static final int BLOCK_ROWS = 5;
    /**
     * The Block columns.
     */
    static final int BLOCK_COLUMNS = 10;
    /**
     * The Block width.
     */
    static final double BLOCK_WIDTH = 40;
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
        return new Level3Background();
    }

    @Override
    public List<Block> blocks() {
        List<Block> list = new ArrayList<>();
        for (int i = 0; i < BLOCK_ROWS; i++) {
            // set the blocks color
            Color color = Color.BLACK;
            switch (i) {
                case 0:
                    color = Color.GRAY;
                    break;
                case 1:
                    color = Color.RED;
                    break;
                case 2:
                    color = Color.YELLOW;
                    break;
                case 3:
                    color = Color.BLUE;
                    break;
                case 4:
                    color = Color.WHITE;
                    break;
                default:
                    break;
            }
            // create the blocks
            for (int j = 0; j < BLOCK_COLUMNS - i; j++) {
                Block block = new Block(new Rectangle(
                        new Point((WIDTH - BORDER_SIZE - BLOCK_WIDTH) - j * BLOCK_WIDTH,
                                BLOCK_START_Y + i * BLOCK_HEIGHT),
                        BLOCK_WIDTH, BLOCK_HEIGHT));
                block.setColor(color);
                list.add(block);
            }
        }
        return list;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return BLOCK_TO_REMOVE;
    }
}
