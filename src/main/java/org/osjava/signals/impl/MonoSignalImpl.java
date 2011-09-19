package org.osjava.signals.impl;

import org.osjava.signals.Signal;
import org.osjava.signals.SignalListener;
import org.osjava.signals.Slot;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: simonrichardson
 * Date: 18/09/2011
 * Time: 21:09
 */
public abstract class MonoSignalImpl<SlotType extends Slot, SignalListenerType extends SignalListener>
        implements Signal<SlotType, SignalListenerType>
{

    public final static boolean DEFAULT_ONCE = false;

    protected final ArrayList<SlotType> bindings = new ArrayList<SlotType>();

    /**
     * @param    listener A function with arguments
     * that matches the value classes dispatched by the signal.
     * If value classes are not specified (e.g. via Signal constructor),
     * dispatch() can be called without arguments.
     * @return a SlotType, which contains the Function passed as the parameter
     */
    public SlotType add(SignalListenerType listener)
    {
        return add(listener, SignalImpl.DEFAULT_ONCE);
    }

    /**
     * @param    listener A function with arguments
     * that matches the value classes dispatched by the signal.
     * If value classes are not specified (e.g. via Signal constructor), dispatch() can be
     * called without arguments.
     * @param once  if required to only call this listener once and then remove it
     * @return a SlotType, which contains the Function passed as the parameter
     */
    public SlotType add(SignalListenerType listener, boolean once)
    {
        return registerListener(listener, once);
    }

    /**
     * Un-subscribes a listener from the signal.
     * @param    listener listener A function with arguments
     * that matches the value classes dispatched by the signal.
     * If value classes are not specified (e.g. via Signal constructor), dispatch() can be
     * called without arguments.
     * @return a SlotType, which contains the Function passed as the parameter
     */
    public SlotType remove(SignalListenerType listener)
    {
        if (bindings.size() > 0)
        {
            final SlotType slot = bindings.get(0);
            if(slot.getListener().equals(listener))
            {
                final SlotType type = slot;
                bindings.remove(0);
                return type;
            }
            else return null;
        } else return null;
    }

    /**
     * Un-subscribes all listeners from the signal.
     */
    public void removeAll()
    {
        if (bindings.size() > 0) bindings.get(0).remove();
    }

    /**
     * The current number of listeners for the signal.
     * @return a int of the number of listeners
     */
    public int getNumListeners()
    {
        return bindings.size();
    }

    /**
     * Register a listener
     * @param listener which is the type of SignalListenerType
     * @param once if the listener should just be called once
     * @return a SlotType, which contains the Function passed as the parameter
     */
    protected SlotType registerListener(SignalListenerType listener, boolean once)
    {
        if(bindings.size() > 0)
        {
            throw new IllegalArgumentException("You cannot add or addOnce with a listener" +
                        " already added, remove the current listener first.");
        }
        return ((SlotType) new SlotImpl(this, listener, once));
    }
}
