package org.osjava.signals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.osjava.signals.factories.Signals;
import org.osjava.signals.impl.SignalImpl0;

/**
 * Created by IntelliJ IDEA.
 * User: simonrichardson
 * Date: 26/09/2011
 * Time: 09:53
 */
public class Signal0ThreadTest
{

    private
    SignalImpl0
            signal;

    @Before
    public void setUp() {
        signal = Signals.createSignal0();
    }

    @After
    public void tearDown() {
        signal.removeAll();
    }

    @Test
    private void test_dispatching_from_multiple_threads() {
        signal.add(new SignalListener0()
        {
            public void apply()
            {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });
    }

}
