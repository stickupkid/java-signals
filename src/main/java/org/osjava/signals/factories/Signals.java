package org.osjava.signals.factories;

import org.osjava.signals.impl.*;

/**
 * Created by IntelliJ IDEA.
 * User: simonrichardson
 * Date: 15/09/2011
 */
public class Signals
{

    public static SignalImpl0 createSignal0()
    {
        return new SignalImpl0();
    }

    public static <A> SignalImpl1<A> createSignal1()
    {
        return new SignalImpl1<A>();
    }

    public static <A, B> SignalImpl2<A, B> createSignal2()
    {
        return new SignalImpl2<A, B>();
    }

    public static PrioritySignalImpl0 createPrioritySignal0()
    {
        return new PrioritySignalImpl0();
    }

    public static <A> PrioritySignalImpl1<A> createPrioritySignal1()
    {
        return new PrioritySignalImpl1<A>();
    }

    public static <A, B> PrioritySignalImpl2<A, B> createPrioritySignal2()
    {
        return new PrioritySignalImpl2<A, B>();
    }

    public static MonoSignalImpl0 createMonoSignal0()
    {
        return new MonoSignalImpl0();
    }

    public static <A> MonoSignalImpl1<A> createMonoSignal1()
    {
        return new MonoSignalImpl1<A>();
    }

    public static <A, B> MonoSignalImpl2<A, B> createMonoSignal2()
    {
        return new MonoSignalImpl2<A, B>();
    }
}
