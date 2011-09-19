package org.osjava.signals.impl;

import org.osjava.signals.Signal2;
import org.osjava.signals.SignalListener2;

/**
 * Created by IntelliJ IDEA.
 * User: simonrichardson
 * Date: 18/09/2011
 * Time: 22:36
 */
public class PrioritySignalImpl2<A,
        B> extends PrioritySignalImpl<PrioritySlotImpl<PrioritySlotImpl,
        SignalListener2>, SignalListener2>
        implements Signal2<A, B, PrioritySlotImpl<PrioritySlotImpl, SignalListener2>,
        SignalListener2>
{

    final private DispatcherImpl2<A, B, PrioritySlotImpl<PrioritySlotImpl, SignalListener2>,
            SignalListenerImpl2> dispatcher;

    public PrioritySignalImpl2()
    {
        super();

        dispatcher = new DispatcherImpl2<A, B, PrioritySlotImpl<PrioritySlotImpl, SignalListener2>,
                SignalListenerImpl2>(bindings);
    }

    public void dispatch(A value0, B value1)
    {
        dispatcher.dispatch(value0, value1);
    }
}
