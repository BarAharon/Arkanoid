// 209163708 Bar Aharon

package GameManagement;

import Coordinates.Point;
import Coordinates.Velocity;
import GameSprites.Ball;
import GameSprites.Block;
import GameSprites.Paddle;
import GameSprites.ScoreIndicator;
import Interfaces.Animation;
import Interfaces.Collidable;
import Interfaces.LevelInformation;
import Interfaces.Sprite;
import Shapes.Rectangle;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Some level of the game.
 *
 * @author Bar Aharon bar.aharon98@gmail.com
 * @version 1.0
 * @since 2022-08-15.
 */
public class GameLevel implements Animation {
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private GUI gui;
    private Counter blockCounter;
    private Counter ballCounter;
    private Counter score;
    private Counter lives;
    private List<Ball> balls;
    private AnimationRunner runner;
    private KeyboardSensor keyboard;
    private boolean running;
    private LevelInformation levelInformation;

    /**
     * The Width of the screen.
     */
    static final int WIDTH = 800;
    /**
     * The Height of the screen.
     */
    static final int HEIGHT = 600;
    /**
     * The Ball radius.
     */
    static final int BALL_RADIUS = 5;
    /**
     * The Ball velocity.
     */
    static final Velocity BALL_VELOCITY = new Velocity(5, 6);
    /**
     * The Border size.
     */
    static final double BORDER_SIZE = 10;
    /**
     * The Bottom block height.
     */
    static final double BOTTOM_BLOCK_HEIGHT = 10;
    /**
     * The Ball 1 start y.
     */
    static final int BALL_START_Y = 575;
    /**
     * The Score rectangle height.
     */
    static final int SCORE_RECTANGLE_HEIGHT = 20;
    /**
     * The number to count from in the start of the game.
     */
    static final int COUNT_FROM = 3;
    /**
     * The Num of seconds to count.
     */
    static final int NUM_SECONDS_COUNT = 2;

    /**
     * Instantiates a new Game.
     *
     * @param levelInformation the level information
     * @param ballCounter      the ball counter
     * @param blockCounter     the block counter
     * @param score            the score
     * @param lives            the lives remaining
     * @param runner           the AnimationRunner
     * @param gui              the gui
     */
    public GameLevel(LevelInformation levelInformation, Counter ballCounter, Counter blockCounter, Counter score,
                     Counter lives, AnimationRunner runner, GUI gui) {
        this.sprites = new SpriteCollection(new ArrayList<>());
        this.environment = new GameEnvironment(new ArrayList<>());
        this.blockCounter = blockCounter;
        this.ballCounter = ballCounter;
        this.score = score;
        this.lives = lives;
        this.balls = new ArrayList<>();
        this.gui = gui;
        this.keyboard = gui.getKeyboardSensor();
        this.levelInformation = levelInformation;
        this.runner = runner;
    }

    /**
     * Add collidable.
     *
     * @param c the collidable
     */
    public void addCollidable(Collidable c) {
        environment.addCollidable(c);
    }

    /**
     * Add sprite.
     *
     * @param s the sprite
     */
    public void addSprite(Sprite s) {
        sprites.addSprite(s);
    }

    /**
     * Initialize the game.
     */
    public void initialize() {
        // add the background
        addSprite(levelInformation.getBackground());
        // create and add the paddle
        Paddle paddle = new Paddle(gui, levelInformation.paddleWidth(), levelInformation.paddleSpeed());
        paddle.addToGame(this);
        BlockRemover blockRemover = new BlockRemover(this, blockCounter);
        ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(score);
        BallRemover ballRemover = new BallRemover(this, ballCounter);
        // add the blocks to the game
        for (Block block : levelInformation.blocks()) {
            block.addToGame(this);
            block.addHitListener(blockRemover);
            block.addHitListener(scoreTrackingListener);
        }
        // create borders
        createBorders(ballRemover);
        // create the score indicator
        ScoreIndicator scoreIndicator = new ScoreIndicator(score, new Rectangle(new Point(0, 0),
                WIDTH, SCORE_RECTANGLE_HEIGHT), levelInformation, lives);
        scoreIndicator.addToGame(this);
    }

    /**
     * Run the game.
     */
    public void run() {
        createBalls();
        // run the countdown
        runner.run(new CountdownAnimation(NUM_SECONDS_COUNT, COUNT_FROM, sprites));
        // use our runner to run the current animation -- which is one turn of the game.
        running = true;
        runner.run(this);
    }

    /**
     * Gets the game gui.
     *
     * @return the gui
     */
    public GUI getGui() {
        return gui;
    }

    /**
     * Remove collidable.
     *
     * @param c the ccollidable
     */
    public void removeCollidable(Collidable c) {
        environment.removeCollidable(c);
        setBallsEnviroment(balls);
    }

    /**
     * Remove sprite.
     *
     * @param s the sprite
     */
    public void removeSprite(Sprite s) {
        sprites.removeSprite(s);
    }

    /**
     * Sets balls enviroment.
     *
     * @param balls the balls
     */
    public void setBallsEnviroment(List<Ball> balls) {
        for (Ball ball : balls) {
            ball.setGameEnvironment(environment);
        }
    }

    /**
     * Init the balls.
     */
    public void initBalls() {
        for (Ball ball : balls) {
            ball.setVelocity(BALL_VELOCITY);
            ball.addToGame(this);
        }
        setBallsEnviroment(balls);
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        sprites.drawAllOn(d);
        sprites.notifyAllTimePassed();
        if (keyboard.isPressed("p")) {
            runner.run(new KeyPressStoppableAnimation(keyboard, new PauseScreen()));
        }
    }

    @Override
    public boolean shouldStop() {
        if (blockCounter.getValue() == 0 || ballCounter.getValue() == 0) {
            return true;
        }
        return !this.running;
    }

    /**
     * Create balls.
     */
    public void createBalls() {
        // create the balls of the current level
        for (int i = 0; i < levelInformation.numberOfBalls(); i++) {
            Ball ball = new Ball(new Point((double) WIDTH / 2, BALL_START_Y), BALL_RADIUS, Color.WHITE);
            ball.setVelocity(levelInformation.initialBallVelocities().get(i));
            ball.addToGame(this);
            balls.add(ball);
        }
        setBallsEnviroment(balls);
    }

    /**
     * Create borders.
     *
     * @param ballRemover the ball remover
     */
    public void createBorders(BallRemover ballRemover) {
        Block blockTop = new Block(new Rectangle(new Point(0, SCORE_RECTANGLE_HEIGHT), WIDTH, BORDER_SIZE));
        Block blockLeft = new Block(new Rectangle(new Point(0, 0), BORDER_SIZE, HEIGHT));
        Block blockRight = new Block(new Rectangle(new Point(WIDTH - BORDER_SIZE, 0), BORDER_SIZE, HEIGHT));
        Block blockBottom = new Block(new Rectangle(new Point(0, HEIGHT + BOTTOM_BLOCK_HEIGHT),
                WIDTH, BOTTOM_BLOCK_HEIGHT));
        blockTop.addToGame(this);
        blockLeft.addToGame(this);
        blockRight.addToGame(this);
        blockBottom.addToGame(this);
        blockBottom.addHitListener(ballRemover);
    }
}

