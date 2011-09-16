package org.osjava.signals;

/**
 * Created by IntelliJ IDEA.
 * User: cereals
 * Date: 16/09/2011
 */
public interface Signal0<SlotType extends Slot, SignalListenerType extends SignalListener>
        extends Signal<SlotType, SignalListenerType>
{

    void dispatch();
}
