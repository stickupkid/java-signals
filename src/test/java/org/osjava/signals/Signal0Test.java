//
// java-signals - Simple, type-safe event dispatching
// Copyright (c) 2011, Three Rings Design, Inc. - All rights reserved.
// https://github.com/osjava/java-signals/blob/master/LICENSE

package org.osjava.signals;

import org.junit.Assert;
import org.junit.Test;
import org.osjava.signals.factories.Signals;
import org.osjava.signals.impl.SignalListenerImpl0;

public class Signal0Test
{
    @Test
    public void verify_that_getNumListeners_is_zero()
    {
        final Signal signal = Signals.createSignal0();

        Assert.assertEquals("Signal getNumListeners should be zero", 0, signal.getNumListeners());
    }

    @Test
    public void verify_that_add_makes_getNumListeners_equal_one()
    {
        final Signal signal = Signals.createSignal0();

        signal.add(new SignalListenerImpl0()
        {

            @Override
            public void apply()
            {
            }
        });

        Assert.assertEquals("Signal getNumListeners should equal one after add", 1,
                signal.getNumListeners());
    }

    @Test
    public void verify_that_add_once_makes_getNumListeners_equal_one()
    {
        final Signal signal = Signals.createSignal0();

        signal.add(new SignalListenerImpl0()
        {

            @Override
            public void apply()
            {
            }
        }, true);

        Assert.assertEquals("Signal getNumListeners should equal one after add once", 1,
                signal.getNumListeners());
    }

    @Test
    public void verify_that_after_add_that_getNumListeners_equal_one_after_dispatch()
    {
        final Signal0 signal = Signals.createSignal0();

        signal.add(new SignalListenerImpl0()
        {

            @Override
            public void apply()
            {
            }
        });

        signal.dispatch();

        Assert.assertEquals("Signal getNumListeners should equal one after add and then dispatch",
                1, signal.getNumListeners());
    }

    @Test
    public void verify_that_after_add_once_that_getNumListeners_equal_one_after_dispatch()
    {
        final Signal0 signal = Signals.createSignal0();

        signal.add(new SignalListenerImpl0()
        {

            @Override
            public void apply()
            {
            }
        }, true);

        signal.dispatch();

        Assert.assertEquals("Signal getNumListeners should equal one after add once and then " +
                "dispatch", 1, signal.getNumListeners());
    }
}
