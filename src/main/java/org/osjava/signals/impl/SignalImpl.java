package org.osjava.signals.impl;

import org.osjava.signals.Signal;
import org.osjava.signals.SignalListener;
import org.osjava.signals.Slot;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: simonrichardson
 * Date: 15/09/2011
 */
public abstract class SignalImpl<SlotType extends Slot, SignalListenerType extends SignalListener>
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
        final SlotType slot = findSlotByListener(listener);
        if (slot != null)
        {
            bindings.remove(slot);
            return slot;
        } else return null;
    }

    /**
     * Un-subscribes all listeners from the signal.
     */
    public void removeAll()
    {
        bindings.clear();
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
     * Find the slot by the associated listener
     * @param listener  which is the type of SignalListenerType to look for
     * @return a SlotType, which contains the Function passed as the parameter
     */
    protected SlotType findSlotByListener(SignalListenerType listener)
    {
        for(SlotType slot : bindings)
        {
            if (slot.equals(listener)) return slot;
        }
        return null;
    }

    /**
     * Register a listener
     * @param listener which is the type of SignalListenerType
     * @param once if the listener should just be called once
     * @return a SlotType, which contains the Function passed as the parameter
     */
    protected SlotType registerListener(SignalListenerType listener, boolean once)
    {
        if (registrationPossible(listener, once))
        {
            SlotType slot;
            try
            {
                slot = (SlotType) new SlotImpl(this, listener, once);
            }
            catch(NullPointerException exception)
            {
                slot = null;
            }

            if(slot != null)
            {
                bindings.add(slot);
                return slot;
            }
        }

        return findSlotByListener(listener);
    }

    /**
     * @param listener  which is the type of SignalListenerType
     * @param once if the listener should just be called once
     * @return boolean if successful
     * @throws IllegalArgumentException if you try to re-add with a different add type
     */
    protected boolean registrationPossible(SignalListenerType listener, boolean once)
    {
        if (bindings.size() > 0) return true;
        else
        {
            final SlotType slot = findSlotByListener(listener);
            if (slot == null) return true;
            else
            {
                if (slot.getOnce() != once)
                {
                    throw new IllegalArgumentException("You cannot addOnce() then add() the " +
                            "same listener without removing the relationship first.");
                }

                return false;
            }
        }
    }
}
