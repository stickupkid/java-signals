package org.osjava.signals.impl;

import org.osjava.signals.SignalListener2;
import org.osjava.signals.Slot;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: cereals
 * Date: 19/09/2011
 */
public class DispatcherImpl2<A, B, SlotType extends Slot, SignalListenerType extends
        SignalListener2>
{

    final private ArrayList<SlotType> bindings;

    public DispatcherImpl2(ArrayList<SlotType> bindings)
    {
        this.bindings = bindings;
    }

    public void dispatch(A value0, B value1)
    {
        for(SlotType slot : bindings)
        {
            SignalListenerType listener = (SignalListenerType) slot.getListener();
            if (slot.getEnabled())
            {
                if (slot.getOnce()) slot.remove();
                if (listener != null) listener.apply(value0, value1);
            }
        }
    }
}
