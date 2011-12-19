package org.osjava.signals;

import java.util.concurrent.Callable;

import org.junit.After;
import org.junit.Test;
import org.osjava.signals.Signal.Signal4;
import org.osjava.signals.SignalListener.SignalListener4;

public class Signal4ThreadRemoveBase extends SignalThreadBase {

	protected Signal4<Integer, Integer, Integer, Integer> signal;

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
				final SignalListener4<Integer, Integer, Integer, Integer> listener =
						new SignalListener4<Integer, Integer, Integer, Integer>() {

							@Override
							public void apply(Integer value0, Integer value1, Integer value2,
									Integer value3) {
								incrementer.addAndGet(value0);
								incrementer.addAndGet(value1);
								incrementer.addAndGet(value2);
								incrementer.addAndGet(value3);

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
