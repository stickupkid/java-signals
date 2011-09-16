package org.osjava.signals.impl;

import org.osjava.signals.SignalListener1;

/**
 * Created by IntelliJ IDEA.
 * User: cereals
 * Date: 16/09/2011
 */
public abstract class SignalListenerImpl1<A> implements SignalListener1<A>
{

    /**
     * Listener called when dispatch on the signal is called.
     * @param value which is the first passed argument
     */
    public void apply(A value)
    {
    }
}
