package org.osjava.signals.impl;

import org.osjava.signals.Signal;
import org.osjava.signals.Slot;

/**
 * Created by IntelliJ IDEA.
 * User: simonrichardson
 * Date: 18/09/2011
 * Time: 21:09
 */
public abstract class MonoSignalImpl<SlotType extends Slot,
        SignalListenerType extends Signal.SignalListener>
        extends SignalImpl<SlotType, SignalListenerType>
        implements Signal<SlotType, SignalListenerType>
{

    /**
     * Register a listener
     *
     * @param listener which is the type of SignalListenerType
     * @param once     if the listener should just be called once
     * @return a SlotType, which contains the Function passed as the parameter
     */
    @Override
    protected SlotType registerListener(SignalListenerType listener, boolean once)
    {
        if (!registrationPossible(listener, once))
        {
            throw new IllegalArgumentException("You cannot add or addOnce with a listener" +
                    " already added, remove the current listener first.");
        } else return ((SlotType) new SlotImpl(this, listener, once));
    }

    /**
     * @param listener which is the type of SignalListenerType
     * @param once     if the listener should just be called once
     * @return boolean if successful
     */
    @Override
    protected boolean registrationPossible(SignalListenerType listener, boolean once)
    {
        return (bindings.size() == 0);
    }
}
