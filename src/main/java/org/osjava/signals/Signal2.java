package org.osjava.signals;

/**
 * Created by IntelliJ IDEA.
 * User: cereals
 * Date: 16/09/2011
 */
public interface Signal2<A, B, SlotType extends Slot, SignalListenerType extends SignalListener>
        extends Signal<SlotType, SignalListenerType>
{
    /**
	 * Dispatches an object to listeners.
     * @param value0 which is the first passed argument
     * @param value1 which is the second passed argument
     */
    public void dispatch(A value0, B value1);
}
