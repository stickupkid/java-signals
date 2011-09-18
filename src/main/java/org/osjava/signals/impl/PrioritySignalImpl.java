package org.osjava.signals.impl;

import org.osjava.signals.PrioritySignal;
import org.osjava.signals.PrioritySlot;
import org.osjava.signals.SignalListener;

/**
 * Created by IntelliJ IDEA.
 * User: simonrichardson
 * Date: 18/09/2011
 * Time: 22:03
 */
public abstract class PrioritySignalImpl<SlotType extends PrioritySlot,
                SignalListenerType extends SignalListener>
                extends SignalImpl<SlotType, SignalListenerType>
                implements PrioritySignal<SlotType, SignalListenerType>
{

    public final static int DEFAULT_PRIORITY = 0;

    /**
     * Subscribes a one-time listener for this signal.
     * The signal will remove the listener automatically the first time it is called,
     * after the dispatch to all listeners is complete.
     *
     * @param once     if required to only call this listener once and then remove it
     * @param priority The priority level of the event listener.
     *                 The higher the number, the higher the priority.
     *                 All listeners with priority n are processed before listeners of priority n-1.
     * @return a SlotType, which contains the Function passed as the parameter
     * @param    listener A function with arguments
     * that matches the value classes dispatched by the signal.
     * If value classes are not specified (e.g. via Signal constructor), dispatch() can be
     * called without arguments.
     */
    public SlotType add(SignalListenerType listener, boolean once, int priority)
    {
        return registerListener(listener, once, priority);
    }

    /**
     * Subscribes a listener for the signal.
     *
     * @param priority The priority level of the event listener.
     *                 The higher the number, the higher the priority.
     *                 All listeners with priority n are processed before listeners of priority n-1.
     * @return a SlotType, which contains the Function passed as the parameter
     * @param    listener A function with arguments
     * that matches the value classes dispatched by the signal.
     * If value classes are not specified (e.g. via Signal constructor),
     * dispatch() can be called without arguments.
     */
    public SlotType add(SignalListenerType listener, int priority)
    {
        return registerListener(listener, DEFAULT_ONCE, priority);
    }

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
        return registerListener(listener, once, DEFAULT_PRIORITY);
    }

    /**
     * Register a listener
     *
     * @param listener which is the type of SignalListenerType
     * @param once     if the listener should just be called once
     * @param priority the priority at which to add the listener
     * @return a SlotType, which contains the Function passed as the parameter
     */
    protected SlotType registerListener(SignalListenerType listener, boolean once, int priority)
    {
        if (registrationPossible(listener, once))
        {
            SlotType slot;
            try
            {
                slot = (SlotType) new PrioritySlotImpl(this, listener, once, priority);
            }
            catch(NullPointerException exception)
            {
                slot = null;
            }

            if(slot != null)
            {
                if(bindings.size() == 0) bindings.add(slot);
                else
                {
                    int position = 0;
                    for(SlotType type : bindings)
                    {
                        // If the priority is greater than the one in the bindings, insert it
                        // nearer to the head. That way they get executed first.
                        if(priority > type.getPriority())
                        {
                            bindings.add(position, slot);
                            break;
                        }
                        position++;
                    }
                }

                return slot;
            }
        }

        return findSlotByListener(listener);
    }
}
