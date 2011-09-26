package org.osjava.signals;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by IntelliJ IDEA.
 * User: simonrichardson
 * Date: 26/09/2011
 * Time: 12:01
 */
public abstract class SignalThreadTest
{

    protected void testAddingWithMultipleThreads(final Callable<Integer> task,
                                                 final int threadCount)
            throws InterruptedException,
            ExecutionException
    {
        List<Callable<Integer>> tasks = Collections.nCopies(threadCount, task);
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        List<Future<Integer>> futures = executorService.invokeAll(tasks);
        List<Integer> resultList = new ArrayList<Integer>(futures.size());

        // Check for exceptions
        for (Future<Integer> future : futures)
        {
            // Throws an exception if an exception was thrown by the task.
            resultList.add(future.get());
        }

        Assert.assertEquals(futures.size(), threadCount);

        List<Integer> expectedList = new ArrayList<Integer>(threadCount);
        for (int i = 1;
             i <= threadCount;
             i++)
        {
            expectedList.add(i);
        }

        Collections.sort(resultList);
        Assert.assertEquals(expectedList, resultList);
    }
}
