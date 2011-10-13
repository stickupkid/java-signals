package org.osjava.signals;

/**
 * Created by IntelliJ IDEA.
 * User: simonrichardson
 * Date: 15/09/2011
 */
public interface Slot<SignalListenerType extends Signal.SignalListener>
{

    /**
     * Removes the slot from its signal.
     */
    public void remove();

    /**
     * Get the listener associated with this slot.
     *
     * @return SignalListener associated with the slot
     */
    public SignalListenerType getListener();

    /**
     * Set the listener associated with this slot.
     *
     * @param value which is a type SignalListener
     */
    public void setListener(SignalListenerType value);

    /**
     * Get whether this slot is automatically removed after it has been used once.
     *
     * @return boolean
     */
    public boolean getOnce();

    /**
     * Set whether this slot is automatically removed after it has been used. This doesn't take
     * note if this has been called, it will take affect the next time around.
     *
     * @param value which is to set wheter the slot will be removed after use.
     */
    public void setOnce(boolean value);

    public boolean getEnabled();

    public void setEnabled(boolean value);
}
