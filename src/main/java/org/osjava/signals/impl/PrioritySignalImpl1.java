package org.osjava.signals.impl;

import org.osjava.signals.Signal1;
import org.osjava.signals.SignalListener1;

/**
 * Created by IntelliJ IDEA.
 * User: simonrichardson
 * Date: 18/09/2011
 * Time: 22:35
 */
public class PrioritySignalImpl1<A> extends PrioritySignalImpl<PrioritySlotImpl<PrioritySlotImpl,
        SignalListener1>, SignalListener1>
        implements Signal1<A, PrioritySlotImpl<PrioritySlotImpl, SignalListener1>, SignalListener1>
{

    public void dispatch(A value0)
    {
        dispatcher.dispatch(value0);
    }
}
