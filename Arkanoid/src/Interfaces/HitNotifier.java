// 209163708 Bar Aharon

package Interfaces;

/**
 * The interface Hit notifier.
 *
 * @author Bar Aharon bar.aharon98@gmail.com
 * @version 1.0
 * @since 2022-08-29.
 */
public interface HitNotifier {
    /**
     * Add hl as a listener to hit events.
     *
     * @param hl the HitListener
     */
    void addHitListener(HitListener hl);

    /**
     * Remove hl from the list of listeners to hit events.
     *
     * @param hl the HitListener
     */
    void removeHitListener(HitListener hl);
}
