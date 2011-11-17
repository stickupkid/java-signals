package org.osjava.signals.selective;

import java.util.concurrent.atomic.AtomicInteger;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.osjava.signals.SelectiveSignal.SelectiveSignal1;
import org.osjava.signals.SelectiveSignal.SelectiveSignal1.SelectiveSignalComparator1;
import org.osjava.signals.Signal1Base;
import org.osjava.signals.SignalListener.SignalListener1;
import org.osjava.signals.impl.SelectiveSignalImpl.SelectiveSignalImpl1;

public class SelectiveSignal1Test extends Signal1Base {

	private SelectiveSignal1<String, String> selectiveSignal;

	@Before
	public void setUp() {
		selectiveSignal = SelectiveSignalImpl1.newInstance();
		signal = selectiveSignal;
	}
	
	@Test
	public void verify_selectiveSignal_comparator_is_null() {
		Assert.assertNull(selectiveSignal.getComparator());
	}

	@Test
	public void verify_selectiveSignal_comparator_is_not_null() {
		selectiveSignal.setComparator(new SelectiveSignalComparator1<String, String>() {
			public boolean compare(String key, String value0) {
				return true;
			}
		});

		Assert.assertNotNull(selectiveSignal.getComparator());
	}

	@Test(expected = AssertionError.class)
	public void verify_selectiveSignal_comparator_can_not_null() {
		selectiveSignal.setComparator(null);

		Assert.assertNull(selectiveSignal.getComparator());
	}

	@Test
	public void verify_add_is_called_with_Integer_value() throws Throwable {

		final AtomicInteger atomicInt = new AtomicInteger();

		final String keyValue = "Hello";

		selectiveSignal.setComparator(new SelectiveSignalComparator1<String, String>() {
			public boolean compare(String key, String value0) {
				return key.equals(keyValue);
			}
		});

		selectiveSignal.add(new SignalListener1<String>() {
			public void apply(String value0) {
				atomicInt.incrementAndGet();
			}
		});

		selectiveSignal.dispatch(keyValue);

		Assert.assertEquals(atomicInt.get(), 1);
		Assert.assertEquals(selectiveSignal.getNumListeners(), 1);
	}
	
	@Test
	public void verify_addOnce_is_called_with_Integer_value() throws Throwable {

		final AtomicInteger atomicInt = new AtomicInteger();

		final String keyValue = "Hello";

		selectiveSignal.setComparator(new SelectiveSignalComparator1<String, String>() {
			public boolean compare(String key, String value0) {
				return key.equals(keyValue);
			}
		});

		selectiveSignal.addOnce(new SignalListener1<String>() {
			public void apply(String value0) {
				atomicInt.incrementAndGet();
			}
		});

		selectiveSignal.dispatch(keyValue);

		Assert.assertEquals(atomicInt.get(), 1);
		Assert.assertEquals(selectiveSignal.getNumListeners(), 0);
	}
	
	@Test
	public void verify_addFor_is_called_with_Integer_value() throws Throwable {
		final AtomicInteger atomicInt = new AtomicInteger();

		final String keyValue = "Hello";

		selectiveSignal.setComparator(new SelectiveSignalComparator1<String, String>() {
			public boolean compare(String key, String value0) {
				return value0.equals(key);
			}
		});

		selectiveSignal.addFor(keyValue, new SignalListener1<String>() {
			public void apply(String value0) {
				atomicInt.incrementAndGet();
			}
		});

		selectiveSignal.addFor("World", new SignalListener1<String>() {
			public void apply(String value0) {
				Assert.fail("This listener should not be called.");
			}
		});

		selectiveSignal.dispatch(keyValue);

		Assert.assertEquals(atomicInt.get(), 1);
		Assert.assertEquals(selectiveSignal.getNumListeners(), 2);
	}
	
	@Test
	public void verify_addOnceFor_is_called_with_Integer_value() throws Throwable {
		final AtomicInteger atomicInt = new AtomicInteger();

		final String keyValue = "Hello";

		selectiveSignal.setComparator(new SelectiveSignalComparator1<String, String>() {
			public boolean compare(String key, String value0) {
				return value0.equals(key);
			}
		});

		selectiveSignal.addOnceFor(keyValue, new SignalListener1<String>() {
			public void apply(String value0) {
				atomicInt.incrementAndGet();
			}
		});

		selectiveSignal.addOnceFor("World", new SignalListener1<String>() {
			public void apply(String value0) {
				Assert.fail("This listener should not be called.");
			}
		});

		selectiveSignal.dispatch(keyValue);

		Assert.assertEquals(atomicInt.get(), 1);
		Assert.assertEquals(selectiveSignal.getNumListeners(), 1);
	}
}
