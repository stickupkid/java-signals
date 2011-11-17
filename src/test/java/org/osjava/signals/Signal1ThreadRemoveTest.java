package org.osjava.signals;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.osjava.signals.Signal.Signal1;
import org.osjava.signals.SignalListener.SignalListener1;
import org.osjava.signals.impl.SignalImpl.SignalImpl1;

public class Signal1ThreadRemoveTest extends SignalThreadBase {

	private Signal1<Integer> signal;

	@Before
	public void setUp() {
		signal = SignalImpl1.newInstance();
		incrementer = new AtomicInteger();
	}

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
				final SignalListener1<Integer> listener = new SignalListener1<Integer>() {

					@Override
					public void apply(Integer value0) {
						incrementer.addAndGet(value0);

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
