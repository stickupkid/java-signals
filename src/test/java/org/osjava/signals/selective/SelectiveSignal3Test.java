package org.osjava.signals.selective;

import java.util.concurrent.atomic.AtomicInteger;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.osjava.signals.SelectiveSignal.SelectiveSignal3;
import org.osjava.signals.SelectiveSignal.SelectiveSignal3.SelectiveSignalComparator3;
import org.osjava.signals.Signal3Base;
import org.osjava.signals.SignalListener.SignalListener3;
import org.osjava.signals.impl.SelectiveSignalImpl.SelectiveSignalImpl3;

public class SelectiveSignal3Test extends Signal3Base {

	private SelectiveSignal3<String, String, String, Boolean> selectiveSignal;

	@Before
	public void setUp() {
		selectiveSignal = SelectiveSignalImpl3.newInstance();
		signal = selectiveSignal;
	}

	@Test
	public void verify_signal_comparator_is_null() {
		Assert.assertNull(selectiveSignal.getComparator());
	}

	@Test
	public void verify_signal_comparator_is_not_null() {
		selectiveSignal
				.setComparator(new SelectiveSignalComparator3<String, String, String, Boolean>() {
					public boolean
							compare(String key, String value0, String value1, Boolean value2) {
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
				.setComparator(new SelectiveSignalComparator3<String, String, String, Boolean>() {
					public boolean
							compare(String key, String value0, String value1, Boolean value2) {
						return key.equals(keyValue);
					}
				});

		selectiveSignal.add(new SignalListener3<String, String, Boolean>() {
			public void apply(String value0, String value1, Boolean value2) {
				atomicInt.incrementAndGet();
			}
		});

		selectiveSignal.dispatch(keyValue, "hello", true);

		Assert.assertEquals(atomicInt.get(), 1);
		Assert.assertEquals(selectiveSignal.getNumListeners(), 1);
	}

	@Test
	public void verify_addOnce_is_called_with_Boolean_value() throws Throwable {

		final AtomicInteger atomicInt = new AtomicInteger();

		final String keyValue = "Hello";

		selectiveSignal
				.setComparator(new SelectiveSignalComparator3<String, String, String, Boolean>() {
					public boolean
							compare(String key, String value0, String value1, Boolean value2) {
						return key.equals(keyValue);
					}
				});

		selectiveSignal.addOnce(new SignalListener3<String, String, Boolean>() {
			public void apply(String value0, String value1, Boolean value2) {
				atomicInt.incrementAndGet();
			}
		});

		selectiveSignal.dispatch(keyValue, "hello", true);

		Assert.assertEquals(atomicInt.get(), 1);
		Assert.assertEquals(selectiveSignal.getNumListeners(), 0);
	}

	@Test
	public void verify_addFor_is_called_with_Boolean_value() throws Throwable {
		final AtomicInteger atomicInt = new AtomicInteger();

		final String keyValue = "Hello";

		selectiveSignal
				.setComparator(new SelectiveSignalComparator3<String, String, String, Boolean>() {
					public boolean
							compare(String key, String value0, String value1, Boolean value2) {
						return value0.equals(key);
					}
				});

		selectiveSignal.addFor(keyValue, new SignalListener3<String, String, Boolean>() {
			public void apply(String value0, String value1, Boolean value2) {
				atomicInt.incrementAndGet();
			}
		});

		selectiveSignal.addFor("World", new SignalListener3<String, String, Boolean>() {
			public void apply(String value0, String value1, Boolean value2) {
				Assert.fail("This listener should not be called.");
			}
		});

		selectiveSignal.dispatch(keyValue, "Hello", true);

		Assert.assertEquals(atomicInt.get(), 1);
		Assert.assertEquals(selectiveSignal.getNumListeners(), 2);
	}

	@Test
	public void verify_addOnceFor_is_called_with_Boolean_value() throws Throwable {
		final AtomicInteger atomicInt = new AtomicInteger();

		final String keyValue = "Hello";

		selectiveSignal
				.setComparator(new SelectiveSignalComparator3<String, String, String, Boolean>() {
					public boolean
							compare(String key, String value0, String value1, Boolean value2) {
						return value0.equals(key);
					}
				});

		selectiveSignal.addOnceFor(keyValue, new SignalListener3<String, String, Boolean>() {
			public void apply(String value0, String value1, Boolean value2) {
				atomicInt.incrementAndGet();
			}
		});

		selectiveSignal.addOnceFor("World", new SignalListener3<String, String, Boolean>() {
			public void apply(String value0, String value1, Boolean value2) {
				Assert.fail("This listener should not be called.");
			}
		});

		selectiveSignal.dispatch(keyValue, "Hello", true);

		Assert.assertEquals(atomicInt.get(), 1);
		Assert.assertEquals(selectiveSignal.getNumListeners(), 1);
	}
}
