package org.osjava.signals;

/**
 * Created by IntelliJ IDEA.
 * User: cereals
 * Date: 16/09/2011
 */
public interface Signal1<A, SlotType extends Slot, SignalListenerType extends SignalListener>
        extends Signal<SlotType, SignalListenerType>
{
    /**
	 * Dispatches an object to listeners.
     */
    public void dispatch(A value);
}
