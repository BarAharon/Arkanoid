// 209163708 Bar Aharon

package GameManagement;

/**
 * The type Counter.
 *
 * @author Bar Aharon bar.aharon98@gmail.com
 * @version 1.0
 * @since 2022-08-29.
 */
public class Counter {
    private int counter;

    /**
     * Instantiates a new Counter.
     */
    public Counter() {
        counter = 0;
    }

    /**
     * dd number to current count.
     *
     * @param number the number to add
     */
    public void increase(int number) {
        counter += number;
    }

    /**
     * subtract number from current count.
     *
     * @param number the number to decrease
     */
    public void decrease(int number) {
        counter -= number;
    }

    /**
     * Gets the counter value.
     *
     * @return the value
     */
    public int getValue() {
        return counter;
    }
}
