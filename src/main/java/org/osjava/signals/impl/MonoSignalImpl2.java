package org.osjava.signals.impl;

import org.osjava.signals.Signal2;
import org.osjava.signals.SignalListener2;

/**
 * Created by IntelliJ IDEA.
 * User: simonrichardson
 * Date: 18/09/2011
 * Time: 21:19
 */
public class MonoSignalImpl2<A, B> extends MonoSignalImpl<SlotImpl<SlotImpl, SignalListener2>,
        SignalListener2>
        implements Signal2<A, B, SlotImpl<SlotImpl, SignalListener2>, SignalListener2>
{

    public void dispatch(A value0, B value1)
    {
        SignalListener2 listener = slot.getListener();
        if (slot.getEnabled())
        {
            if (slot.getOnce()) slot.remove();
            if (listener != null) listener.apply(value0, value1);
        }
    }
}
