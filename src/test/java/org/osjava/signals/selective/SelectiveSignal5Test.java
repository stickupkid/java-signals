package org.osjava.signals.selective;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.osjava.signals.SelectiveSignal.SelectiveSignal5;
import org.osjava.signals.SelectiveSignal.SelectiveSignal5.SelectiveSignalComparator5;
import org.osjava.signals.Signal5Base;
import org.osjava.signals.SignalListener.SignalListener5;
import org.osjava.signals.impl.SelectiveSignalImpl.SelectiveSignalImpl5;

public class SelectiveSignal5Test extends Signal5Base {

	private SelectiveSignal5<String, String, String, String, String, Boolean> selectiveSignal;

	@Before
	public void setUp() {
		selectiveSignal = SelectiveSignalImpl5.newInstance();
		signal = selectiveSignal;
	}

	@Test
	public void verify_signal_comparator_is_null() {
		Assert.assertNull(selectiveSignal.getComparator());
	}

	@Test
	public void verify_signal_comparator_is_not_null() {
		selectiveSignal
				.setComparator(new SelectiveSignalComparator5<String, String, String, String, String, Boolean>() {
					public boolean compare(String key, String value0, String value1, String value2,
							String value3, Boolean value4) {
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

		selectiveSignal
				.setComparator(new SelectiveSignalComparator5<String, String, String, String, String, Boolean>() {
					public boolean compare(String key, String value0, String value1, String value2,
							String value3, Boolean value4) {
						return key.equals(keyValue);
					}
				});

		selectiveSignal.add(new SignalListener5<String, String, String, String, Boolean>() {
			public void apply(String value0, String value1, String value2, String value3,
					Boolean value4) {
				atomicInt.incrementAndGet();
			}
		});

		selectiveSignal.dispatch(keyValue, "hello", "World", "!", true);

		Assert.assertEquals(atomicInt.get(), 1);
		Assert.assertEquals(selectiveSignal.getNumListeners(), 1);
	}

	@Test
	public void verify_addOnce_is_called_with_Boolean_value() throws Throwable {

		final AtomicInteger atomicInt = new AtomicInteger();

		final String keyValue = "Hello";

		selectiveSignal
				.setComparator(new SelectiveSignalComparator5<String, String, String, String, String, Boolean>() {
					public boolean compare(String key, String value0, String value1, String value2,
							String value3, Boolean value4) {
						return key.equals(keyValue);
					}
				});

		selectiveSignal.addOnce(new SignalListener5<String, String, String, String, Boolean>() {
			public void apply(String value0, String value1, String value2, String value3,
					Boolean value4) {
				atomicInt.incrementAndGet();
			}
		});

		selectiveSignal.dispatch(keyValue, "hello", "World", "!", true);

		Assert.assertEquals(atomicInt.get(), 1);
		Assert.assertEquals(selectiveSignal.getNumListeners(), 0);
	}

	@Test
	public void verify_addFor_is_called_with_Boolean_value() throws Throwable {
		final AtomicInteger atomicInt = new AtomicInteger();

		final String keyValue = "Hello";

		selectiveSignal
				.setComparator(new SelectiveSignalComparator5<String, String, String, String, String, Boolean>() {
					public boolean compare(String key, String value0, String value1, String value2,
							String value3, Boolean value4) {
						return value0.equals(key);
					}
				});

		selectiveSignal.addFor(keyValue,
				new SignalListener5<String, String, String, String, Boolean>() {
					public void apply(String value0, String value1, String value2, String value3,
							Boolean value4) {
						atomicInt.incrementAndGet();
					}
				});

		selectiveSignal.addFor("World",
				new SignalListener5<String, String, String, String, Boolean>() {
					public void apply(String value0, String value1, String value2, String value3,
							Boolean value4) {
						Assert.fail("This listener should not be called.");
					}
				});

		selectiveSignal.dispatch(keyValue, keyValue, "World", "!", true);

		Assert.assertEquals(atomicInt.get(), 1);
		Assert.assertEquals(selectiveSignal.getNumListeners(), 2);
	}

	@Test
	public void verify_addOnceFor_is_called_with_Boolean_value() throws Throwable {
		final AtomicInteger atomicInt = new AtomicInteger();

		final String keyValue = "Hello";

		selectiveSignal
				.setComparator(new SelectiveSignalComparator5<String, String, String, String, String, Boolean>() {
					public boolean compare(String key, String value0, String value1, String value2,
							String value3, Boolean value4) {
						return value0.equals(key);
					}
				});

		selectiveSignal.addOnceFor(keyValue,
				new SignalListener5<String, String, String, String, Boolean>() {
					public void apply(String value0, String value1, String value2, String value3,
							Boolean value4) {
						atomicInt.incrementAndGet();
					}
				});

		selectiveSignal.addOnceFor("World",
				new SignalListener5<String, String, String, String, Boolean>() {
					public void apply(String value0, String value1, String value2, String value3,
							Boolean value4) {
						Assert.fail("This listener should not be called.");
					}
				});

		selectiveSignal.dispatch(keyValue, keyValue, "World", "!", true);

		Assert.assertEquals(atomicInt.get(), 1);
		Assert.assertEquals(selectiveSignal.getNumListeners(), 1);
	}
}
