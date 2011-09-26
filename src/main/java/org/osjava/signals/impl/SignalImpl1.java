package org.osjava.signals.impl;

import org.osjava.signals.Signal1;

/**
 * Created by IntelliJ IDEA.
 * User: cereals
 * Date: 16/09/2011
 */
public class SignalImpl1<A>
        extends SignalImpl<SlotImpl<SlotImpl, Signal1.SignalListener1>,
        Signal1.SignalListener1>
        implements Signal1<A, SlotImpl<SlotImpl, Signal1.SignalListener1>, Signal1.SignalListener1>
{

    public void dispatch(A value0)
    {
        dispatcher.dispatch(value0);
    }
}
