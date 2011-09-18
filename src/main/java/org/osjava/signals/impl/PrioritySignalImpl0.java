package org.osjava.signals.impl;

import org.osjava.signals.Signal0;
import org.osjava.signals.SignalListener0;

/**
 * Created by IntelliJ IDEA.
 * User: simonrichardson
 * Date: 18/09/2011
 * Time: 22:29
 */
public class PrioritySignalImpl0 extends PrioritySignalImpl<PrioritySlotImpl<PrioritySlotImpl,
        SignalListener0>, SignalListener0>
        implements Signal0<PrioritySlotImpl<PrioritySlotImpl, SignalListener0>, SignalListener0>
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
