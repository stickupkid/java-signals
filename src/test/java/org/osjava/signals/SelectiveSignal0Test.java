package org.osjava.signals;

import java.util.concurrent.atomic.AtomicInteger;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.osjava.signals.SelectiveSignal.SelectiveSignal0;
import org.osjava.signals.SelectiveSignal.SelectiveSignal0.SelectiveSignalComparator0;
import org.osjava.signals.SignalListener.SignalListener0;
import org.osjava.signals.impl.SelectiveSignalImpl.SelectiveSignalImpl0;

public class SelectiveSignal0Test {

	private SelectiveSignal0<Integer> signal;

	@Before
	public void setUp() {
		signal = SelectiveSignalImpl0.newInstance();
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
		signal.setComparator(new SelectiveSignalComparator0<Integer>() {
			public boolean compare(Integer key) {
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
	public void verify_addFor_is_called_with_Integer_value() throws Throwable {

		final AtomicInteger atomicInt = new AtomicInteger();

		final int keyValue = 42;

		signal.setComparator(new SelectiveSignalComparator0<Integer>() {
			public boolean compare(Integer key) {
				return key.equals(keyValue);
			}
		});

		signal.addFor(keyValue, new SignalListener0() {
			public void apply() {
				atomicInt.incrementAndGet();
			}
		});

		signal.addFor(100, new SignalListener0() {
			public void apply() {
				Assert.fail("This listener should not be called.");
			}
		});

		signal.dispatch();

		Assert.assertEquals(atomicInt.get(), 1);
		Assert.assertEquals(signal.getNumListeners(), 2);
	}

	@Test
	public void verify_addOnceFor_is_called_with_Integer_value() throws Throwable {

		final AtomicInteger atomicInt = new AtomicInteger();

		final int keyValue = 42;

		signal.setComparator(new SelectiveSignalComparator0<Integer>() {
			public boolean compare(Integer key) {
				return key.equals(keyValue);
			}
		});

		signal.addOnceFor(keyValue, new SignalListener0() {
			public void apply() {
				atomicInt.incrementAndGet();
			}
		});

		signal.addOnceFor(100, new SignalListener0() {
			public void apply() {
				Assert.fail("This listener should not be called.");
			}
		});

		signal.dispatch();

		Assert.assertEquals(atomicInt.get(), 1);
		Assert.assertEquals(signal.getNumListeners(), 1);
	}
}
