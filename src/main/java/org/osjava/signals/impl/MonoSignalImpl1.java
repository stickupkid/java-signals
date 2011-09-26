package org.osjava.signals.impl;

import org.osjava.signals.Signal1;

/**
 * Created by IntelliJ IDEA.
 * User: simonrichardson
 * Date: 18/09/2011
 * Time: 21:19
 */
public class MonoSignalImpl1<A> extends MonoSignalImpl<SlotImpl<SlotImpl, Signal1.SignalListener1>,
        Signal1.SignalListener1>
        implements Signal1<A, SlotImpl<SlotImpl, Signal1.SignalListener1>, Signal1.SignalListener1>
{

    public void dispatch(A value0)
    {
        dispatcher.dispatch(value0);
    }
}
