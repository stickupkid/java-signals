package org.osjava.signals;

/**
 * Created by IntelliJ IDEA.
 * User: cereals
 * Date: 16/09/2011
 */
public interface Signal0<SlotType extends Slot, SignalListenerType extends Signal0.SignalListener0>
        extends Signal<SlotType, SignalListenerType>
{
    /**
     * Dispatches an object to listeners.
     */
    public void dispatch();

    public interface SignalListener0 extends SignalListener
    {
        /**
         * Listener called when dispatch on the signal is called.
         */
        public void apply();
    }
}
