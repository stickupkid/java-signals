package org.osjava.signals;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.osjava.signals.Signal2.SignalListener2;
import org.osjava.signals.impl.SignalImpl2;


public class Signal2ThreadDispatchTest extends SignalThreadTest {
	
	private Signal2<Integer, Integer> signal;

	@Before
	public void setUp() {
		signal = SignalImpl2.newInstance();
		incrementer = new AtomicInteger();
	}

	@After
	public void tearDown() {
		signal.removeAll();
	}

	@Test
	public void test_adding_two_listeners_in_two_threads_and_dispatching()
			throws InterruptedException, ExecutionException {
		testDispatchWithMultipleThreads(2);
	}

	@Test
	public void test_adding_three_listeners_in_three_threads_and_dispatching()
			throws InterruptedException, ExecutionException {
		testDispatchWithMultipleThreads(3);
	}
	
	@Test
	public void test_adding_four_listeners_in_four_threads_and_dispatching()
			throws InterruptedException, ExecutionException {
		testDispatchWithMultipleThreads(4);
	}

	@Test
	public void test_adding_eight_listeners_in_eight_threads_and_dispatching()
			throws InterruptedException, ExecutionException {
		testDispatchWithMultipleThreads(8);
	}

	@Test
	public void test_adding_thirty_two_listeners_in_thirty_two_threads_and_dispatching()
			throws InterruptedException, ExecutionException {
		testDispatchWithMultipleThreads(32);
	}

	@Test
	public void test_adding_once_two_listeners_in_two_threads_and_dispatching()
			throws InterruptedException, ExecutionException {
		testDispatchWithMultipleThreads(2, true);
	}

	@Test
	public void test_adding_once_three_listeners_in_three_threads_and_dispatching()
			throws InterruptedException, ExecutionException {
		testDispatchWithMultipleThreads(3, true);
	}

	@Test
	public void test_adding_once_four_listeners_in_four_threads_and_dispatching()
			throws InterruptedException, ExecutionException {
		testDispatchWithMultipleThreads(4, true);
	}

	@Test
	public void test_adding_once_eight_listeners_in_eight_threads_and_dispatching()
			throws InterruptedException, ExecutionException {
		testDispatchWithMultipleThreads(8, true);
	}

	@Test
	public void test_adding_once_thirty_two_listeners_in_thirty_two_threads_and_dispatching()
			throws InterruptedException, ExecutionException {
		testDispatchWithMultipleThreads(32, true);
	}

	private void testDispatchWithMultipleThreads(final int threadCount)
			throws InterruptedException, ExecutionException {
		testDispatchWithMultipleThreads(threadCount, false);
	}

	private void testDispatchWithMultipleThreads(final int threadCount, final boolean isOnce)
			throws InterruptedException, ExecutionException {
		Callable<Integer> task = new Callable<Integer>() {
			public Integer call() throws Exception {
				final SignalListener2<Integer, Integer> listener = new SignalListener2<Integer, Integer>() {
					
					@Override
					public void apply(Integer value0, Integer value1) {
						incrementer.addAndGet(value0);
						incrementer.addAndGet(value1);
					}
				};
				if (isOnce) {
					signal.addOnce(listener);
				} else {
					signal.add(listener);
				}

				return incrementer.get();
			}
		};

		testDispatchWithMultipleThreads(signal, task, threadCount);
	}
}
