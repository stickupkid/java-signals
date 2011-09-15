package org.osjava.signals;

/**
 * Created by IntelliJ IDEA.
 * User: simonrichardson
 * Date: 15/09/2011
 * Time: 22:18
 */
public interface Slot<SignalListenerType extends SignalListener>
{

    void remove();

    SignalListenerType getListener();
    void setListener(SignalListenerType value);

    boolean getOnce();
    void setOnce(boolean value);
}
