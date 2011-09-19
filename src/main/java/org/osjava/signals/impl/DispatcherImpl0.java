package org.osjava.signals.impl;

import org.osjava.signals.SignalListener0;
import org.osjava.signals.Slot;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: cereals
 * Date: 19/09/2011
 */
public class DispatcherImpl0<SlotType extends Slot, SignalListenerType extends SignalListener0>
{

    final private ArrayList<SlotType> bindings;

    public DispatcherImpl0(ArrayList<SlotType> bindings)
    {
        this.bindings = bindings;
    }

    final public void dispatch()
    {
        for(SlotType slot : bindings)
        {
            SignalListenerType listener = (SignalListenerType) slot.getListener();
            if (slot.getEnabled())
            {
                if (slot.getOnce()) slot.remove();
                if (listener != null) listener.apply();
            }
        }
    }
}
