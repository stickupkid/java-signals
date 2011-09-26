package org.osjava.signals;

/**
 * Created by IntelliJ IDEA.
 * User: simonrichardson
 * Date: 15/09/2011
 */
public interface Signal<SlotType extends Slot, SignalListenerType extends SignalListener>
{
    /**
     * Subscribes a listener for the signal.
     *
     * @return a SlotType, which contains the Function passed as the parameter
     * @param    listener A function with arguments
     * that matches the value classes dispatched by the signal.
     * If value classes are not specified (e.g. via Signal constructor),
     * dispatch() can be called without arguments.
     */
    public SlotType add(SignalListenerType listener);

    /**
     * Subscribes a one-time listener for this signal.
     * The signal will remove the listener automatically the first time it is called,
     * after the dispatch to all listeners is complete.
     *
     * @param once if required to only call this listener once and then remove it
     * @return a SlotType, which contains the Function passed as the parameter
     * @param    listener A function with arguments
     * that matches the value classes dispatched by the signal.
     * If value classes are not specified (e.g. via Signal constructor), dispatch() can be
     * called without arguments.
     */
    public SlotType add(SignalListenerType listener, boolean once);

    /**
     * Un-subscribes a listener from the signal.
     *
     * @return a SlotType, which contains the Function passed as the parameter
     * @param    listener A function with arguments
     */
    public SlotType remove(SignalListenerType listener);

    /**
     * Un-subscribes all listeners from the signal.
     */
    public void removeAll();

    /**
     * The current number of listeners for the signal.
     *
     * @return a int of the number of listeners
     */
    public int getNumListeners();
}
