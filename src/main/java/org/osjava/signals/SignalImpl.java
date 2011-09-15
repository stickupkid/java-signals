package org.osjava.signals;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Created by IntelliJ IDEA.
 * User: simonrichardson
 * Date: 15/09/2011
 * Time: 22:33
 */
public abstract class SignalImpl<SlotType extends Slot, SignalListenerType extends SignalListener>
                            implements Signal<SlotType, SignalListenerType>
{

    public final static boolean DEFAULT_ONCE = false;

    protected final ArrayList<SlotType> bindings = new ArrayList<SlotType>();

    public SlotType add(SignalListenerType listener)
    {
        return add(listener, SignalImpl.DEFAULT_ONCE);
    }

    public SlotType add(SignalListenerType listener, boolean once)
    {
        return registerListener(listener, once);
    }

    public SlotType remove(SignalListenerType listener)
    {
        final SlotType slot = findSlotByListener(listener);
        if(slot != null)
        {
            bindings.remove(slot);
            return slot;
        }
        else return null;
    }

    public void removeAll()
    {
        bindings.clear();
    }

    public int getNumListeners()
    {
        return bindings.size();
    }

    protected SlotType findSlotByListener(SignalListenerType listener)
    {
        final ListIterator<SlotType> iterator = bindings.listIterator() ;
        while(iterator.hasNext())
        {
            SlotType slot = iterator.next();
            if(slot.equals(listener)) return slot;
        }
        return null;
    }

    protected SlotType registerListener(SignalListenerType listener, boolean once)
    {
        if(registrationPossible(listener, once))
        {
            final SlotType slot = (SlotType) new SlotImpl(this, listener, once);
            if(slot != null)
            {
                bindings.add(slot);
                return slot;
            }
            else throw new NullPointerException("SlotType can not be null");
        }

        return findSlotByListener(listener);
    }

    protected boolean registrationPossible(SignalListenerType listener, boolean once)
    {
        if(bindings.size() > 0) return true;
        else
        {
            final SlotType slot = findSlotByListener(listener);
            if(slot == null) return true;
            else
            {
                if(slot.getOnce() != once)
                {
                    throw new IllegalArgumentException("You cannot addOnce() then add() the " +
                                        "same listener without removing the relationship first.");
                }

                return false;
            }
        }
    }
}
