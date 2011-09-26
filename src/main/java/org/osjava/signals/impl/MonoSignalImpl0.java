package org.osjava.signals.impl;

import org.osjava.signals.Signal0;

/**
 * Created by IntelliJ IDEA.
 * User: simonrichardson
 * Date: 18/09/2011
 * Time: 21:09
 */
public class MonoSignalImpl0 extends MonoSignalImpl<SlotImpl<SlotImpl, Signal0.SignalListener0>,
        Signal0.SignalListener0>
        implements Signal0<SlotImpl<SlotImpl, Signal0.SignalListener0>, Signal0.SignalListener0>
{

    public void dispatch()
    {
        dispatcher.dispatch();
    }
}
