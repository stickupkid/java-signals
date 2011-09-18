package org.osjava.signals.impl;

import org.osjava.signals.Signal0;
import org.osjava.signals.SignalListener0;

/**
 * Created by IntelliJ IDEA.
 * User: simonrichardson
 * Date: 18/09/2011
 * Time: 21:09
 */
public class MonoSignalImpl0 extends MonoSignalImpl<SlotImpl<SlotImpl, SignalListener0>, SignalListener0>
        implements Signal0<SlotImpl<SlotImpl, SignalListener0>, SignalListener0>
{

    public void dispatch()
    {
        SignalListener0 listener = slot.getListener();
        if (slot.getEnabled())
        {
            if (slot.getOnce()) slot.remove();
            if (listener != null) listener.apply();
        }
    }
}
