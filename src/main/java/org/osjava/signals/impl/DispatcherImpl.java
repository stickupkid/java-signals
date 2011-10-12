package org.osjava.signals.impl;

import org.osjava.signals.Signal0;
import org.osjava.signals.Signal1;
import org.osjava.signals.Signal2;
import org.osjava.signals.Slot;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: simonrichardson
 * Date: 19/09/2011
 * Time: 21:31
 */
public class DispatcherImpl<SlotType extends Slot>
{

    private final List<SlotType> bindings;

    public DispatcherImpl(List<SlotType> bindings)
    {
        this.bindings = bindings;
    }

    final public <SignalListenerType extends Signal0.SignalListener0> void dispatch()
    {
        for (SlotType slot : bindings)
        {
            SignalListenerType listener = (SignalListenerType) slot.getListener();
            if (slot.getEnabled())
            {
                if (slot.getOnce()) slot.remove();
                if (listener != null) listener.apply();
            }
        }
    }

    final public <A, SignalListenerType extends Signal1.SignalListener1> void dispatch(A value0)
    {
        for (SlotType slot : bindings)
        {
            SignalListenerType listener = (SignalListenerType) slot.getListener();
            if (slot.getEnabled())
            {
                if (slot.getOnce()) slot.remove();
                if (listener != null) listener.apply(value0);
            }
        }
    }

    final public <A, B, SignalListenerType extends Signal2.SignalListener2> void dispatch(A value0,
                                                                                          B value1)
    {
        for (SlotType slot : bindings)
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
