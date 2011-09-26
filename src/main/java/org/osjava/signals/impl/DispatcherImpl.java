package org.osjava.signals.impl;

import org.osjava.signals.SignalListener0;
import org.osjava.signals.SignalListener1;
import org.osjava.signals.SignalListener2;
import org.osjava.signals.Slot;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: simonrichardson
 * Date: 19/09/2011
 * Time: 21:31
 */
public class DispatcherImpl<SlotType extends Slot>
{

    private final ArrayList<SlotType> bindings;

    public DispatcherImpl(ArrayList<SlotType> bindings)
    {
        this.bindings = bindings;
    }

    final synchronized public <SignalListenerType extends SignalListener0> void dispatch()
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

    final synchronized public <A, SignalListenerType extends SignalListener1>
            void dispatch(A value0)
    {
        for(SlotType slot : bindings)
        {
            SignalListenerType listener = (SignalListenerType) slot.getListener();
            if (slot.getEnabled())
            {
                if (slot.getOnce()) slot.remove();
                if (listener != null) listener.apply(value0);
            }
        }
    }

    final synchronized public <A, B, SignalListenerType extends SignalListener2>
            void dispatch(A value0, B value1)
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
