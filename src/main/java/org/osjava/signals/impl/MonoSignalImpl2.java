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

    final private DispatcherImpl2<A, B, SlotImpl<SlotImpl, SignalListener2>,
            SignalListenerImpl2> dispatcher;

    public MonoSignalImpl2()
    {
        super();

        dispatcher = new DispatcherImpl2<A, B, SlotImpl<SlotImpl, SignalListener2>,
                SignalListenerImpl2>(bindings);
    }

    public void dispatch(A value0, B value1)
    {
        dispatcher.dispatch(value0, value1);
    }
}
