package org.osjava.signals;

/**
 * Created by IntelliJ IDEA.
 * User: simonrichardson
 * Date: 15/09/2011
 * Time: 22:17
 */
public interface Signal<SlotType extends Slot, SignalListenerType extends SignalListener>
{

    SlotType add(SignalListenerType listener);

    SlotType add(SignalListenerType listener, boolean once);

    SlotType remove(SignalListenerType listener);

    void removeAll();

    int getNumListeners();
}
