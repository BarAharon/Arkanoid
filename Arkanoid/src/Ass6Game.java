// 209163708 Bar Aharon

import GameManagement.AnimationRunner;
import GameManagement.GameFlow;
import Interfaces.LevelInformation;
import Levels.Level1;
import Levels.Level2;
import Levels.Level3;
import Levels.Level4;
import biuoop.GUI;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Ass 6 game.
 *
 * @author Bar Aharon bar.aharon98@gmail.com
 * @version 1.0
 * @since 2022-09-06.
 */
public class Ass6Game {
    /**
     * The Width of the screen.
     */
    static final int WIDTH = 800;
    /**
     * The Height of the screen.
     */
    static final int HEIGHT = 600;
    /**
     * The Frames per second.
     */
    static final int FRAMES_PER_SECOND = 60;

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        GUI gui = new GUI("game", WIDTH, HEIGHT);
        GameFlow gameFlow = new GameFlow(new AnimationRunner(FRAMES_PER_SECOND, gui), gui.getKeyboardSensor(), gui);
        List<LevelInformation> list = new ArrayList<>();
        list.add(new Level1());
        list.add(new Level2());
        list.add(new Level3());
        list.add(new Level4());
        /*
        // An option to add the level to the list in each order you want
        for (String arg : args) {
            switch (arg) {
                case "1":
                    list.add(new Level1());
                    break;
                case "2":
                    list.add(new Level2());
                    break;
                case "3":
                    list.add(new Level3());
                    break;
                case "4":
                    list.add(new Level4());
                    break;
                default:
                    break;
            }
        }
        */
        // run the levels
        gameFlow.runLevels(list);
    }
}

