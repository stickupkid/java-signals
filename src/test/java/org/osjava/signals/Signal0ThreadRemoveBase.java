package org.osjava.signals;

import java.util.concurrent.Callable;

import org.junit.After;
import org.junit.Test;
import org.osjava.signals.Signal.Signal0;
import org.osjava.signals.SignalListener.SignalListener0;

public class Signal0ThreadRemoveBase extends SignalThreadBase {

	protected Signal0 signal;

	@After
	public void tearDown() {
		signal.removeAll();
	}

	@Test
	public void test_adding_two_listeners_in_two_threads_and_removing() throws Throwable {
		testRemoveWithMultipleThreads(2);
	}

	@Test
	public void test_adding_three_listeners_in_three_threads_and_removing() throws Throwable {
		testRemoveWithMultipleThreads(3);
	}

	@Test
	public void test_adding_four_listeners_in_four_threads_and_removing() throws Throwable {
		testRemoveWithMultipleThreads(4);
	}

	@Test
	public void test_adding_eight_listeners_in_eight_threads_and_removing() throws Throwable {
		testRemoveWithMultipleThreads(8);
	}

	@Test
	public void test_adding_thirty_two_listeners_in_thirty_two_threads_and_removing()
			throws Throwable {
		testRemoveWithMultipleThreads(32);
	}

	private void testRemoveWithMultipleThreads(final int threadCount) throws Throwable {
		Callable<Integer> task = new Callable<Integer>() {
			public Integer call() throws Exception {
				final SignalListener0 listener = new SignalListener0() {

					@Override
					public void apply() {
						incrementer.incrementAndGet();

						signal.remove(this);
					}
				};

				signal.add(listener);

				return incrementer.get();
			}
		};

		testRemoveWithMultipleThreads(signal, task, threadCount);
	}
}
