package org.osjava.signals.selective;

import java.util.concurrent.atomic.AtomicInteger;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.osjava.signals.SelectiveSignal.SelectiveSignal1.SelectiveSignalComparator1;
import org.osjava.signals.SelectiveSignal.SelectiveSignal2;
import org.osjava.signals.SelectiveSignal.SelectiveSignal2.SelectiveSignalComparator2;
import org.osjava.signals.SignalListener.SignalListener2;
import org.osjava.signals.impl.SelectiveSignalImpl.SelectiveSignalImpl2;

public class SelectiveSignal2Test {

	private SelectiveSignal2<String, String, Integer> signal;

	@Before
	public void setUp() {
		signal = SelectiveSignalImpl2.newInstance();
	}

	@After
	public void tearDown() {
		signal.removeAll();
	}
	
	@Test
	public void verify_signal_comparator_is_null() {
		Assert.assertNull(signal.getComparator());
	}

	@Test
	public void verify_signal_comparator_is_not_null() {
		signal.setComparator(new SelectiveSignalComparator1<String, String>() {
			public boolean compare(String key, String value0) {
				return true;
			}
		});

		Assert.assertNotNull(signal.getComparator());
	}

	@Test(expected = AssertionError.class)
	public void verify_signal_comparator_can_not_null() {
		signal.setComparator(null);

		Assert.assertNull(signal.getComparator());
	}
	
	@Test
	public void verify_add_is_called_with_Integer_value() throws Throwable {

		final AtomicInteger atomicInt = new AtomicInteger();

		final String keyValue = "Hello";

		signal.setComparator(new SelectiveSignalComparator2<String, String, Integer>() {
			public boolean compare(String key, String value0, Integer value1) {
				return key.equals(keyValue);
			}
		});

		signal.add(new SignalListener2<String, Integer>() {
			public void apply(String value0, Integer value1) {
				atomicInt.incrementAndGet();
			}
		});

		signal.dispatch(keyValue, 42);

		Assert.assertEquals(atomicInt.get(), 1);
		Assert.assertEquals(signal.getNumListeners(), 1);
	}
	
	@Test
	public void verify_addOnce_is_called_with_Integer_value() throws Throwable {

		final AtomicInteger atomicInt = new AtomicInteger();

		final String keyValue = "Hello";

		signal.setComparator(new SelectiveSignalComparator2<String, String, Integer>() {
			public boolean compare(String key, String value0, Integer value1) {
				return key.equals(keyValue);
			}
		});

		signal.addOnce(new SignalListener2<String, Integer>() {
			public void apply(String value0, Integer value1) {
				atomicInt.incrementAndGet();
			}
		});

		signal.dispatch(keyValue, 42);

		Assert.assertEquals(atomicInt.get(), 1);
		Assert.assertEquals(signal.getNumListeners(), 0);
	}
	
	@Test
	public void verify_addFor_is_called_with_Integer_value() throws Throwable {
		final AtomicInteger atomicInt = new AtomicInteger();

		final String keyValue = "Hello";

		signal.setComparator(new SelectiveSignalComparator2<String, String, Integer>() {
			public boolean compare(String key, String value0, Integer value1) {
				return value0.equals(key);
			}
		});

		signal.addFor(keyValue, new SignalListener2<String, Integer>() {
			public void apply(String value0, Integer value1) {
				atomicInt.incrementAndGet();
			}
		});

		signal.addFor("World", new SignalListener2<String, Integer>() {
			public void apply(String value0, Integer value1) {
				Assert.fail("This listener should not be called.");
			}
		});

		signal.dispatch(keyValue, 42);
		
		Assert.assertEquals(atomicInt.get(), 1);
		Assert.assertEquals(signal.getNumListeners(), 2);
	}
	
	@Test
	public void verify_addOnceFor_is_called_with_Integer_value() throws Throwable {
		final AtomicInteger atomicInt = new AtomicInteger();

		final String keyValue = "Hello";

		signal.setComparator(new SelectiveSignalComparator2<String, String, Integer>() {
			public boolean compare(String key, String value0, Integer value1) {
				return value0.equals(key);
			}
		});

		signal.addOnceFor(keyValue, new SignalListener2<String, Integer>() {
			public void apply(String value0, Integer value1) {
				atomicInt.incrementAndGet();
			}
		});

		signal.addOnceFor("World", new SignalListener2<String, Integer>() {
			public void apply(String value0, Integer value1) {
				Assert.fail("This listener should not be called.");
			}
		});

		signal.dispatch(keyValue, 42);
		
		Assert.assertEquals(atomicInt.get(), 1);
		Assert.assertEquals(signal.getNumListeners(), 1);
	}
	
}
