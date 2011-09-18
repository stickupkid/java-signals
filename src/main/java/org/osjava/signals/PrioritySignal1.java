package org.osjava.signals;

/**
 * Created by IntelliJ IDEA.
 * User: simonrichardson
 * Date: 18/09/2011
 * Time: 22:02
 */
public interface PrioritySignal1<A, SlotType extends Slot, SignalListenerType extends SignalListener>
        extends PrioritySignal<SlotType, SignalListenerType>
{
    /**
	 * Dispatches an object to listeners.
     * @param value which is the first passed argument
     */
    public void dispatch(A value);
}
