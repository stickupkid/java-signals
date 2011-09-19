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

    final private DispatcherImpl0<SlotImpl<SlotImpl, SignalListener0>,
            SignalListenerImpl0> dispatcher;

    public SignalImpl0()
    {
        super();

        dispatcher = new DispatcherImpl0<SlotImpl<SlotImpl, SignalListener0>,
                SignalListenerImpl0>(bindings);
    }

    public void dispatch()
    {
        dispatcher.dispatch();
    }
}
