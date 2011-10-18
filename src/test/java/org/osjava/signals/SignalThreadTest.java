package org.osjava.signals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Assert;

/**
 * Created by IntelliJ IDEA. User: simonrichardson Date: 26/09/2011 Time: 12:01
 */
public abstract class SignalThreadTest {

	protected void testAddingWithMultipleThreads(final Callable<Integer> task, final int threadCount)
			throws InterruptedException, ExecutionException {
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
		for (int i = 1; i <= threadCount; i++) {
			expectedList.add(i);
		}

		Collections.sort(resultList);
		Assert.assertEquals(expectedList, resultList);
	}

	protected void testDispatchWithMultipleThreads(final Signal0 signal, final Callable<SignalDispatchRunnable> task,
			final int threadCount) throws InterruptedException, ExecutionException {

		List<Callable<SignalDispatchRunnable>> tasks = Collections.nCopies(threadCount, task);
		ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
		List<Future<SignalDispatchRunnable>> futures = executorService.invokeAll(tasks);
		List<Integer> resultList = new ArrayList<Integer>(futures.size());
		
		signal.dispatch();
				
		// Check for exceptions
		for (Future<SignalDispatchRunnable> future : futures) {
			// Throws an exception if an exception was thrown by the task.
			resultList.add(future.get().getNumListeners());
		}

		Assert.assertEquals(futures.size(), threadCount);

		List<Integer> expectedList = new ArrayList<Integer>(threadCount);
		for (int i = 1; i <= threadCount; i++) {
			expectedList.add(i);
		}

		Collections.sort(resultList);
		Assert.assertEquals(expectedList, resultList);
	}
}
