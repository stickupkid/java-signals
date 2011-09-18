package org.osjava.signals.impl;

import org.osjava.signals.Signal0;
import org.osjava.signals.SignalListener0;

/**
 * Created by IntelliJ IDEA.
 * User: simonrichardson
 * Date: 15/09/2011
 */
public class SignalImpl0 extends SignalImpl<SlotImpl<SlotImpl, SignalListener0>, SignalListener0>
        implements Signal0<SlotImpl<SlotImpl, SignalListener0>, SignalListener0>
{

    public void dispatch()
    {
        for(SlotImpl slot : bindings)
        {
            SignalListener0 listener = (SignalListener0) slot.getListener();
            if (slot.getEnabled())
            {
                if (slot.getOnce()) slot.remove();
                if (listener != null) listener.apply();
            }
        }
    }
}
