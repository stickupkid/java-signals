package org.osjava.signals.impl;

import org.osjava.signals.Signal0;
import org.osjava.signals.SignalListener0;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: simonrichardson
 * Date: 18/09/2011
 * Time: 21:09
 */
public class MonoSignalImpl0 extends MonoSignalImpl<SlotImpl<SlotImpl, SignalListener0>,
        SignalListener0>
        implements Signal0<SlotImpl<SlotImpl, SignalListener0>, SignalListener0>
{

    final private DispatcherImpl0<SlotImpl<SlotImpl, SignalListener0>,
            SignalListenerImpl0> dispatcher;

    public MonoSignalImpl0()
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
