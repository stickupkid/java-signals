package org.osjava.signals;


/**
 * Created by IntelliJ IDEA.
 * User: simonrichardson
 * Date: 18/09/2011
 * Time: 22:01
 */
public interface PrioritySignal0<SlotType extends Slot, SignalListenerType extends Signal0.SignalListener0>
        extends PrioritySignal<SlotType, SignalListenerType>
{
    /**
     * Dispatches an object to listeners.
     */
    public void dispatch();
}
