package org.osjava.signals;

import java.util.ListIterator;

/**
 * Created by IntelliJ IDEA.
 * User: simonrichardson
 * Date: 15/09/2011
 * Time: 22:29
 */
public class SignalImpl0 extends SignalImpl<SlotImpl<SlotImpl, SignalListener0>, SignalListener0>
{

    void dispatch()
    {
        final ListIterator<SlotImpl<SlotImpl, SignalListener0>> iterator = bindings.listIterator();
        while (iterator.hasNext())
        {
            SlotImpl slot = iterator.next();
            SignalListener0 listener = (SignalListener0) slot.getListener();
            if(slot.getOnce()) slot.remove();
            listener.apply();
        }
    }
}
