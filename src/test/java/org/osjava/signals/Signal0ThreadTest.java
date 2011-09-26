package org.osjava.signals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.osjava.signals.factories.Signals;
import org.osjava.signals.impl.SignalImpl0;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * Created by IntelliJ IDEA.
 * User: simonrichardson
 * Date: 26/09/2011
 * Time: 09:53
 */
public class Signal0ThreadTest extends SignalThreadTest
{

    private SignalImpl0 signal;

    @Before
    public void setUp()
    {
        signal = Signals.createSignal0();
    }

    @After
    public void tearDown()
    {
        signal.removeAll();
    }

    @Test
    public void test_adding_two_listeners_in_two_threads() throws InterruptedException,
            ExecutionException
    {
        testAddingWithMultipleThreads(2);
    }

    @Test
    public void test_adding_three_listeners_in_three_threads() throws InterruptedException,
            ExecutionException
    {
        testAddingWithMultipleThreads(3);
    }

    @Test
    public void test_adding_four_listeners_in_four_threads() throws InterruptedException,
            ExecutionException
    {
        testAddingWithMultipleThreads(4);
    }

    @Test
    public void test_adding_eight_listeners_in_eight_threads() throws InterruptedException,
            ExecutionException
    {
        testAddingWithMultipleThreads(8);
    }

    @Test
    public void test_adding_thirtytwo_listeners_in_thirtytwo_threads() throws InterruptedException,
            ExecutionException
    {
        testAddingWithMultipleThreads(32);
    }

    private void testAddingWithMultipleThreads(final int threadCount) throws InterruptedException,
            ExecutionException
    {
        Callable<Integer> task = new Callable<Integer>()
        {
            public Integer call() throws Exception
            {
                signal.add(new Signal0.SignalListener0()
                {
                    public void apply()
                    {
                    }
                });
                return signal.getNumListeners();
            }
        };

        testAddingWithMultipleThreads(task, threadCount);
    }

}
