package org.osjava.signals;

/**
 * Created by IntelliJ IDEA.
 * User: cereals
 * Date: 16/09/2011
 */
public interface SignalListener1<A> extends SignalListener
{
    /**
     * Listener called when dispatch on the signal is called.
     * @param value which is the first passed argument
     */
    public void apply(A value);
}
