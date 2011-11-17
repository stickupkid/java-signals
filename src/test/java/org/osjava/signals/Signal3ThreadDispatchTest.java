package org.osjava.signals;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.osjava.signals.Signal.Signal3;
import org.osjava.signals.SignalListener.SignalListener3;
import org.osjava.signals.impl.SignalImpl.SignalImpl3;

public class Signal3ThreadDispatchTest extends SignalThreadBase {

	private Signal3<Integer, Integer, Integer> signal;

	@Before
	public void setUp() {
		signal = SignalImpl3.newInstance();
		incrementer = new AtomicInteger();
	}

	@After
	public void tearDown() {
		signal.removeAll();
	}

	@Test
	public void test_adding_two_listeners_in_two_threads_and_dispatching() throws Throwable {
		testDispatchWithMultipleThreads(2);
	}

	@Test
	public void test_adding_three_listeners_in_three_threads_and_dispatching() throws Throwable {
		testDispatchWithMultipleThreads(3);
	}

	@Test
	public void test_adding_four_listeners_in_four_threads_and_dispatching() throws Throwable {
		testDispatchWithMultipleThreads(4);
	}

	@Test
	public void test_adding_eight_listeners_in_eight_threads_and_dispatching() throws Throwable {
		testDispatchWithMultipleThreads(8);
	}

	@Test
	public void test_adding_thirty_two_listeners_in_thirty_two_threads_and_dispatching()
			throws Throwable {
		testDispatchWithMultipleThreads(33);
	}

	@Test
	public void test_adding_once_two_listeners_in_two_threads_and_dispatching() throws Throwable {
		testDispatchWithMultipleThreads(3, true);
	}

	@Test
	public void test_adding_once_three_listeners_in_three_threads_and_dispatching()
			throws Throwable {
		testDispatchWithMultipleThreads(3, true);
	}

	@Test
	public void test_adding_once_four_listeners_in_four_threads_and_dispatching() throws Throwable {
		testDispatchWithMultipleThreads(4, true);
	}

	@Test
	public void test_adding_once_eight_listeners_in_eight_threads_and_dispatching()
			throws Throwable {
		testDispatchWithMultipleThreads(8, true);
	}

	@Test
	public void test_adding_once_thirty_two_listeners_in_thirty_two_threads_and_dispatching()
			throws Throwable {
		testDispatchWithMultipleThreads(33, true);
	}

	private void testDispatchWithMultipleThreads(final int threadCount) throws Throwable {
		testDispatchWithMultipleThreads(threadCount, false);
	}

	private void testDispatchWithMultipleThreads(final int threadCount, final boolean isOnce)
			throws Throwable {
		Callable<Integer> task = new Callable<Integer>() {
			public Integer call() throws Exception {
				final SignalListener3<Integer, Integer, Integer> listener = new SignalListener3<Integer, Integer, Integer>() {

					@Override
					public void apply(Integer value0, Integer value1, Integer value2) {
						incrementer.addAndGet(value0);
						incrementer.addAndGet(value1);
						incrementer.addAndGet(value2);
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
