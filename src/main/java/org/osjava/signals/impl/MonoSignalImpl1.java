package org.osjava.signals.impl;

import org.osjava.signals.Signal1;
import org.osjava.signals.SignalListener1;

/**
 * Created by IntelliJ IDEA.
 * User: simonrichardson
 * Date: 18/09/2011
 * Time: 21:19
 */
public class MonoSignalImpl1<A> extends MonoSignalImpl<SlotImpl<SlotImpl, SignalListener1>,
        SignalListener1>
        implements Signal1<A, SlotImpl<SlotImpl, SignalListener1>, SignalListener1>
{

    public void dispatch(A value)
    {
        SignalListener1 listener = slot.getListener();
        if (slot.getEnabled())
        {
            if (slot.getOnce()) slot.remove();
            if (listener != null) listener.apply(value);
        }
    }
}
