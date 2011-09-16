package org.osjava.signals.factories;

import org.osjava.signals.Signal;
import org.osjava.signals.impl.SignalImpl0;

/**
 * Created by IntelliJ IDEA.
 * User: simonrichardson
 * Date: 15/09/2011
 */
enum SignalType
{
    ZERO
}

public class Signals
{

    public static Signal create(SignalType type)
    {
        switch (type)
        {
            case ZERO:
            default:
                return createSignal0();
        }
    }

    public static SignalImpl0 createSignal0()
    {
        return new SignalImpl0();
    }
}
