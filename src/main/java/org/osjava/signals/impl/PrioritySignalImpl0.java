package org.osjava.signals.impl;

import org.osjava.signals.Signal0;

/**
 * Created by IntelliJ IDEA.
 * User: simonrichardson
 * Date: 18/09/2011
 * Time: 22:29
 */
public class PrioritySignalImpl0 extends PrioritySignalImpl<PrioritySlotImpl<PrioritySlotImpl,
        Signal0.SignalListener0>, Signal0.SignalListener0>
        implements Signal0<PrioritySlotImpl<PrioritySlotImpl, Signal0.SignalListener0>, Signal0.SignalListener0>
{

    public void dispatch()
    {
        dispatcher.dispatch();
    }
}
