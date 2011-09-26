package org.osjava.signals.impl;

import org.osjava.signals.Signal2;

/**
 * Created by IntelliJ IDEA.
 * User: cereals
 * Date: 16/09/2011
 */
public class SignalImpl2<A, B>
        extends SignalImpl<SlotImpl<SlotImpl, Signal2.SignalListener2>,
        Signal2.SignalListener2>
        implements
        Signal2<A, B, SlotImpl<SlotImpl, Signal2.SignalListener2>, Signal2.SignalListener2>
{

    public void dispatch(A value0,
                         B value1)
    {
        dispatcher.dispatch(value0,
                value1);
    }
}
