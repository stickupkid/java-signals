package org.osjava.signals;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.osjava.signals.factories.Signals;
import org.osjava.signals.impl.SignalImpl0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by IntelliJ IDEA.
 * User: simonrichardson
 * Date: 26/09/2011
 * Time: 09:53
 */
public class Signal0ThreadTest
{

    private SignalImpl0 signal;

    @Before
    public void setUp() {
        signal = Signals.createSignal0();
    }

    @After
    public void tearDown() {
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

    private void testAddingWithMultipleThreads(final int threadCount)
            throws InterruptedException, ExecutionException
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

        List<Callable<Integer>> tasks = Collections.nCopies(threadCount, task);
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        List<Future<Integer>> futures = executorService.invokeAll(tasks);
        List<Integer> resultList = new ArrayList<Integer>(futures.size());

        // Check for exceptions
        for (Future<Integer> future : futures) {
            // Throws an exception if an exception was thrown by the task.
            resultList.add(future.get());
        }

        Assert.assertEquals(futures.size(), threadCount);

        List<Integer> expectedList = new ArrayList<Integer>(threadCount);
        for (int i = 1; i <= threadCount; i++)
        {
            expectedList.add(i);
        }

        Collections.sort(resultList);
        Assert.assertEquals(expectedList, resultList);
    }
}
