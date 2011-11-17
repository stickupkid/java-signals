package org.osjava.signals.selective;

import java.util.concurrent.atomic.AtomicInteger;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.osjava.signals.SelectiveSignal.SelectiveSignal0;
import org.osjava.signals.SelectiveSignal.SelectiveSignal0.SelectiveSignalComparator0;
import org.osjava.signals.Signal0Base;
import org.osjava.signals.SignalListener.SignalListener0;
import org.osjava.signals.impl.SelectiveSignalImpl.SelectiveSignalImpl0;

public class SelectiveSignal0Test extends Signal0Base {

	private SelectiveSignal0<Integer> selectiveSignal;
	
	@Before
	public void setUp() {
		selectiveSignal = SelectiveSignalImpl0.newInstance();
		signal = selectiveSignal;
	}

	@Test
	public void verify_signal_comparator_is_null() {
		Assert.assertNull(selectiveSignal.getComparator());
	}

	@Test
	public void verify_signal_comparator_is_not_null() {
		selectiveSignal.setComparator(new SelectiveSignalComparator0<Integer>() {
			public boolean compare(Integer key) {
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
	public void verify_add_is_called_with_Integer_value() throws Throwable {

		final AtomicInteger atomicInt = new AtomicInteger();

		final int keyValue = 42;

		selectiveSignal.setComparator(new SelectiveSignalComparator0<Integer>() {
			public boolean compare(Integer key) {
				return key.equals(keyValue);
			}
		});

		selectiveSignal.add(new SignalListener0() {
			public void apply() {
				atomicInt.incrementAndGet();
			}
		});

		selectiveSignal.dispatch();

		Assert.assertEquals(atomicInt.get(), 1);
		Assert.assertEquals(selectiveSignal.getNumListeners(), 1);
	}
	
	@Test
	public void verify_addOnce_is_called_with_Integer_value() throws Throwable {

		final AtomicInteger atomicInt = new AtomicInteger();

		final int keyValue = 42;

		selectiveSignal.setComparator(new SelectiveSignalComparator0<Integer>() {
			public boolean compare(Integer key) {
				return key.equals(keyValue);
			}
		});

		selectiveSignal.addOnce(new SignalListener0() {
			public void apply() {
				atomicInt.incrementAndGet();
			}
		});

		selectiveSignal.dispatch();

		Assert.assertEquals(atomicInt.get(), 1);
		Assert.assertEquals(signal.getNumListeners(), 0);
	}
	
	@Test
	public void verify_addFor_is_called_with_Integer_value() throws Throwable {

		final AtomicInteger atomicInt = new AtomicInteger();

		final int keyValue = 42;

		selectiveSignal.setComparator(new SelectiveSignalComparator0<Integer>() {
			public boolean compare(Integer key) {
				return key.equals(keyValue);
			}
		});

		selectiveSignal.addFor(keyValue, new SignalListener0() {
			public void apply() {
				atomicInt.incrementAndGet();
			}
		});

		selectiveSignal.addFor(100, new SignalListener0() {
			public void apply() {
				Assert.fail("This listener should not be called.");
			}
		});

		selectiveSignal.dispatch();

		Assert.assertEquals(atomicInt.get(), 1);
		Assert.assertEquals(selectiveSignal.getNumListeners(), 2);
	}

	@Test
	public void verify_addOnceFor_is_called_with_Integer_value() throws Throwable {

		final AtomicInteger atomicInt = new AtomicInteger();

		final int keyValue = 42;

		selectiveSignal.setComparator(new SelectiveSignalComparator0<Integer>() {
			public boolean compare(Integer key) {
				return key.equals(keyValue);
			}
		});

		selectiveSignal.addOnceFor(keyValue, new SignalListener0() {
			public void apply() {
				atomicInt.incrementAndGet();
			}
		});

		selectiveSignal.addOnceFor(100, new SignalListener0() {
			public void apply() {
				Assert.fail("This listener should not be called.");
			}
		});

		selectiveSignal.dispatch();

		Assert.assertEquals(atomicInt.get(), 1);
		Assert.assertEquals(selectiveSignal.getNumListeners(), 1);
	}
}
