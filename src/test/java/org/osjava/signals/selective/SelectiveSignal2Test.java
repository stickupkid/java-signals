package org.osjava.signals.selective;

import java.util.concurrent.atomic.AtomicInteger;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.osjava.signals.SelectiveSignal.SelectiveSignal2;
import org.osjava.signals.SelectiveSignal.SelectiveSignal2.SelectiveSignalComparator2;
import org.osjava.signals.Signal2Base;
import org.osjava.signals.SignalListener.SignalListener2;
import org.osjava.signals.impl.SelectiveSignalImpl.SelectiveSignalImpl2;

public class SelectiveSignal2Test extends Signal2Base {

	private SelectiveSignal2<String, String, Boolean> selectiveSignal;

	@Before
	public void setUp() {
		selectiveSignal = SelectiveSignalImpl2.newInstance();
		signal = selectiveSignal;
	}

	@Test
	public void verify_signal_comparator_is_null() {
		Assert.assertNull(selectiveSignal.getComparator());
	}

	@Test
	public void verify_signal_comparator_is_not_null() {
		selectiveSignal.setComparator(new SelectiveSignalComparator2<String, String, Boolean>() {
			public boolean compare(String key, String value0, Boolean value1) {
				return true;
			}
		});

		Assert.assertNotNull(selectiveSignal.getComparator());
	}

	@Test(expected = AssertionError.class)
	public void verify_signal_comparator_can_not_null() {
		selectiveSignal.setComparator(null);

		Assert.assertNull(selectiveSignal.getComparator());
	}

	@Test
	public void verify_add_is_called_with_Boolean_value() throws Throwable {

		final AtomicInteger atomicInt = new AtomicInteger();

		final String keyValue = "Hello";

		selectiveSignal.setComparator(new SelectiveSignalComparator2<String, String, Boolean>() {
			public boolean compare(String key, String value0, Boolean value1) {
				return key.equals(keyValue);
			}
		});

		selectiveSignal.add(new SignalListener2<String, Boolean>() {
			public void apply(String value0, Boolean value1) {
				atomicInt.incrementAndGet();
			}
		});

		selectiveSignal.dispatch(keyValue, true);

		Assert.assertEquals(atomicInt.get(), 1);
		Assert.assertEquals(selectiveSignal.getNumListeners(), 1);
	}

	@Test
	public void verify_addOnce_is_called_with_Boolean_value() throws Throwable {

		final AtomicInteger atomicInt = new AtomicInteger();

		final String keyValue = "Hello";

		selectiveSignal.setComparator(new SelectiveSignalComparator2<String, String, Boolean>() {
			public boolean compare(String key, String value0, Boolean value1) {
				return key.equals(keyValue);
			}
		});

		selectiveSignal.addOnce(new SignalListener2<String, Boolean>() {
			public void apply(String value0, Boolean value1) {
				atomicInt.incrementAndGet();
			}
		});

		selectiveSignal.dispatch(keyValue, true);

		Assert.assertEquals(atomicInt.get(), 1);
		Assert.assertEquals(selectiveSignal.getNumListeners(), 0);
	}

	@Test
	public void verify_addFor_is_called_with_Boolean_value() throws Throwable {
		final AtomicInteger atomicInt = new AtomicInteger();

		final String keyValue = "Hello";

		selectiveSignal.setComparator(new SelectiveSignalComparator2<String, String, Boolean>() {
			public boolean compare(String key, String value0, Boolean value1) {
				return value0.equals(key);
			}
		});

		selectiveSignal.addFor(keyValue, new SignalListener2<String, Boolean>() {
			public void apply(String value0, Boolean value1) {
				atomicInt.incrementAndGet();
			}
		});

		selectiveSignal.addFor("World", new SignalListener2<String, Boolean>() {
			public void apply(String value0, Boolean value1) {
				Assert.fail("This listener should not be called.");
			}
		});

		selectiveSignal.dispatch(keyValue, true);

		Assert.assertEquals(atomicInt.get(), 1);
		Assert.assertEquals(selectiveSignal.getNumListeners(), 2);
	}

	@Test
	public void verify_addOnceFor_is_called_with_Boolean_value() throws Throwable {
		final AtomicInteger atomicInt = new AtomicInteger();

		final String keyValue = "Hello";

		selectiveSignal.setComparator(new SelectiveSignalComparator2<String, String, Boolean>() {
			public boolean compare(String key, String value0, Boolean value1) {
				return value0.equals(key);
			}
		});

		selectiveSignal.addOnceFor(keyValue, new SignalListener2<String, Boolean>() {
			public void apply(String value0, Boolean value1) {
				atomicInt.incrementAndGet();
			}
		});

		selectiveSignal.addOnceFor("World", new SignalListener2<String, Boolean>() {
			public void apply(String value0, Boolean value1) {
				Assert.fail("This listener should not be called.");
			}
		});

		selectiveSignal.dispatch(keyValue, true);

		Assert.assertEquals(atomicInt.get(), 1);
		Assert.assertEquals(selectiveSignal.getNumListeners(), 1);
	}

}
