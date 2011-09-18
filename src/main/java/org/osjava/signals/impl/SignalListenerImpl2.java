package org.osjava.signals.impl;

import org.osjava.signals.SignalListener2;

/**
 * Created by IntelliJ IDEA.
 * User: cereals
 * Date: 16/09/2011
 */
public abstract class SignalListenerImpl2<A, B> implements SignalListener2<A, B>
{

    /**
     * Listener called when dispatch on the signal is called.
     * @param value0 which is the first passed argument
     * @param value1 which is the second passed argument
     */
    public void apply(A value0, B value1)
    {
    }
}
