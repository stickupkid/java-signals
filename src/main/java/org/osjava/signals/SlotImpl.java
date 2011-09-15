package org.osjava.signals;

/**
 * Created by IntelliJ IDEA.
 * User: simonrichardson
 * Date: 15/09/2011
 * Time: 23:09
 */
public class SlotImpl<SlotType extends Slot, SignalListenerType extends SignalListener>
                                       implements Slot<SignalListenerType>
{

    private Signal<SlotType, SignalListenerType> signal;

    private SignalListenerType listener;

    private boolean once;

    public SlotImpl(Signal<SlotType, SignalListenerType> signal,
                    SignalListenerType listener,
                    boolean once)
    {
        this.signal = signal;

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
}
