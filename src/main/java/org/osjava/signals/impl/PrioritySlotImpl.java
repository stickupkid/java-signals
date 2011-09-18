package org.osjava.signals.impl;

import org.osjava.signals.PrioritySlot;
import org.osjava.signals.Signal;
import org.osjava.signals.SignalListener;
import org.osjava.signals.Slot;

/**
 * Created by IntelliJ IDEA.
 * User: simonrichardson
 * Date: 18/09/2011
 * Time: 22:16
 */
public class PrioritySlotImpl<SlotType extends Slot, SignalListenerType extends SignalListener>
        extends SlotImpl<SlotType, SignalListenerType>
        implements PrioritySlot<SignalListenerType>
{

    private final int priority;

    public PrioritySlotImpl(Signal<SlotType, SignalListenerType> signal,
                            SignalListenerType listener,
                            boolean once,
                            int priority)
    {
        super(signal, listener, once);

        this.priority = priority;
    }

    public int getPriority()
    {
        return priority;
    }
}
