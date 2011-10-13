package org.osjava.signals;

/**
 * Created by IntelliJ IDEA.
 * User: simonrichardson
 * Date: 18/09/2011
 * Time: 21:54
 */
public interface PrioritySignal<SlotType extends Slot, SignalListenerType extends Signal.SignalListener>
        extends Signal<SlotType, SignalListenerType>
{
    /**
     * Subscribes a listener for the signal.
     *
     * @param priority The priority level of the event listener.
     *                 The higher the number, the higher the priority.
     *                 All listeners with priority n are processed before listeners of priority n-1.
     * @return a SlotType, which contains the Function passed as the parameter
     * @param    listener A function with arguments
     * that matches the value classes dispatched by the signal.
     * If value classes are not specified (e.g. via Signal constructor),
     * dispatch() can be called without arguments.
     */
    public SlotType add(SignalListenerType listener, int priority);

    /**
     * Subscribes a one-time listener for this signal.
     * The signal will remove the listener automatically the first time it is called,
     * after the dispatch to all listeners is complete.
     *
     * @param once     if required to only call this listener once and then remove it
     * @param priority The priority level of the event listener.
     *                 The higher the number, the higher the priority.
     *                 All listeners with priority n are processed before listeners of priority n-1.
     * @return a SlotType, which contains the Function passed as the parameter
     * @param    listener A function with arguments
     * that matches the value classes dispatched by the signal.
     * If value classes are not specified (e.g. via Signal constructor), dispatch() can be
     * called without arguments.
     */
    public SlotType add(SignalListenerType listener, boolean once, int priority);

}
