package org.osjava.signals;

import java.util.concurrent.Callable;

import org.junit.After;
import org.junit.Test;
import org.osjava.signals.Signal.Signal2;
import org.osjava.signals.SignalListener.SignalListener2;

public class Signal2ThreadDispatchBase extends SignalThreadBase {

	protected Signal2<Integer, Integer> signal;

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
		testDispatchWithMultipleThreads(32);
	}

	@Test
	public void test_adding_once_two_listeners_in_two_threads_and_dispatching() throws Throwable {
		testDispatchWithMultipleThreads(2, true);
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
		testDispatchWithMultipleThreads(32, true);
	}

	private void testDispatchWithMultipleThreads(final int threadCount) throws Throwable {
		testDispatchWithMultipleThreads(threadCount, false);
	}

	private void testDispatchWithMultipleThreads(final int threadCount, final boolean isOnce)
			throws Throwable {
		Callable<Integer> task = new Callable<Integer>() {
			public Integer call() throws Exception {
				final SignalListener2<Integer, Integer> listener =
						new SignalListener2<Integer, Integer>() {

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
