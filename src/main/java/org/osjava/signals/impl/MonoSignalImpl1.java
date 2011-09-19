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

    final private DispatcherImpl1<A, SlotImpl<SlotImpl, SignalListener1>,
            SignalListenerImpl1> dispatcher;

    public MonoSignalImpl1()
    {
        super();

        dispatcher = new DispatcherImpl1<A, SlotImpl<SlotImpl, SignalListener1>,
                SignalListenerImpl1>(bindings);
    }

    public void dispatch(A value0)
    {
        dispatcher.dispatch(value0);
    }
}
