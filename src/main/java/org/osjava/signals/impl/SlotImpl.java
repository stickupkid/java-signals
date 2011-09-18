package org.osjava.signals.impl;

import org.osjava.signals.Signal;
import org.osjava.signals.SignalListener;
import org.osjava.signals.Slot;

/**
 * Created by IntelliJ IDEA.
 * User: simonrichardson
 * Date: 15/09/2011
 */
public class SlotImpl<SlotType extends Slot, SignalListenerType extends SignalListener>
        implements Slot<SignalListenerType>
{

    private final Signal<SlotType, SignalListenerType> signal;

    private SignalListenerType listener;

    private boolean once;

    private boolean enabled;

    public SlotImpl(Signal<SlotType, SignalListenerType> signal,
                    SignalListenerType listener,
                    boolean once)
    {
        this.signal = signal;
        this.enabled = true;

        setListener(listener);
        setOnce(once);
    }

    public void remove()
    {
        signal.remove(getListener());
    }

    public SignalListenerType getListener()
    {
        return listener;
    }

    public void setListener(SignalListenerType value)
    {
        listener = value;
    }

    public boolean getOnce()
    {
        return once;
    }

    public void setOnce(boolean value)
    {
        once = value;
    }

    public boolean getEnabled()
    {
        return enabled;
    }

    public void setEnabled(boolean value)
    {
        enabled = value;
    }
}
