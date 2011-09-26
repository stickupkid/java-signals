package org.osjava.signals;

/**
 * Created by IntelliJ IDEA.
 * User: simonrichardson
 * Date: 18/09/2011
 * Time: 22:20
 */
public interface PrioritySlot<SignalListenerType extends SignalListener>
        extends Slot<SignalListenerType>
{

    public int getPriority();
}
