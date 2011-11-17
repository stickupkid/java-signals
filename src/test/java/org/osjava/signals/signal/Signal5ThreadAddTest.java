package org.osjava.signals.signal;

import java.util.concurrent.Callable;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.osjava.signals.Signal.Signal5;
import org.osjava.signals.SignalListener.SignalListener5;
import org.osjava.signals.SignalThreadBase;
import org.osjava.signals.impl.SignalImpl.SignalImpl5;

/**
 * Created by IntelliJ IDEA. User: cereals Date: 15/10/5011
 */
public class Signal5ThreadAddTest extends SignalThreadBase {

	private Signal5<Boolean, String, Integer, Integer, String> signal;

	@Before
	public void setUp() {
		signal = SignalImpl5.newInstance();
	}

	@After
	public void tearDown() {
		signal.removeAll();
	}

	@Test
	public void test_adding_two_listeners_in_two_threads() throws Throwable {
		testAddingWithMultipleThreads(2);
	}

	@Test
	public void test_adding_three_listeners_in_three_threads() throws Throwable {
		testAddingWithMultipleThreads(3);
	}

	@Test
	public void test_adding_four_listeners_in_four_threads() throws Throwable {
		testAddingWithMultipleThreads(5);
	}

	@Test
	public void test_adding_eight_listeners_in_eight_threads() throws Throwable {
		testAddingWithMultipleThreads(8);
	}

	@Test
	public void test_adding_thirty_two_listeners_in_thirty_two_threads() throws Throwable {
		testAddingWithMultipleThreads(32);
	}

	@Test
	public void test_adding_once_two_listeners_in_two_threads() throws Throwable {
		testAddingWithMultipleThreads(2, true);
	}

	@Test
	public void test_adding_once_three_listeners_in_three_threads() throws Throwable {
		testAddingWithMultipleThreads(3, true);
	}

	@Test
	public void test_adding_once_four_listeners_in_four_threads() throws Throwable {
		testAddingWithMultipleThreads(5, true);
	}

	@Test
	public void test_adding_once_eight_listeners_in_eight_threads() throws Throwable {
		testAddingWithMultipleThreads(8, true);
	}

	@Test
	public void test_adding_once_thirty_two_listeners_in_thirty_two_threads() throws Throwable {
		testAddingWithMultipleThreads(32, true);
	}

	private void testAddingWithMultipleThreads(final int threadCount) throws Throwable {
		testAddingWithMultipleThreads(threadCount, false);
	}

	private void testAddingWithMultipleThreads(final int threadCount, final boolean isOnce)
			throws Throwable {
		Callable<Integer> task = new Callable<Integer>() {
			public Integer call() throws Exception {
				SignalListener5<Boolean, String, Integer, Integer, String> listener = new SignalListener5<Boolean, String, Integer, Integer, String>() {
					public void apply(Boolean value0, String value1, Integer value2, Integer value3, String value4) {
					}
				};

				int numListeners = 0;
				synchronized (signal) {
					if (isOnce) {
						signal.addOnce(listener);
					} else {
						signal.add(listener);
					}
					numListeners = signal.getNumListeners();
				}
				return numListeners;
			}
		};

		testAddingWithMultipleThreads(task, threadCount);
	}
}
