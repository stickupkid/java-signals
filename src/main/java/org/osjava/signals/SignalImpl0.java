package org.osjava.signals;

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
        for(SlotImpl slot : bindings)
        {
            SignalListener0 listener = (SignalListener0) slot.getListener();
            if(slot.getOnce()) slot.remove();
            listener.apply();
        }
    }
}
