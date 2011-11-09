package org.osjava.signals;

import java.util.concurrent.atomic.AtomicInteger;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.osjava.signals.SelectiveSignal.SelectiveSignal1;
import org.osjava.signals.SelectiveSignal.SelectiveSignal1.SelectiveSignalComparator1;
import org.osjava.signals.SignalListener.SignalListener1;
import org.osjava.signals.impl.SelectiveSignalImpl.SelectiveSignalImpl1;

public class SelectiveSignal1Test {

	private SelectiveSignal1<String, String> signal;

	@Before
	public void setUp() {
		signal = SelectiveSignalImpl1.newInstance();
	}

	@After
	public void tearDown() {
		signal.removeAll();
	}

	@Test
	public void verify_addFor_is_called_with_Integer_value() throws Throwable {
		final AtomicInteger atomicInt = new AtomicInteger();

		final String keyValue = "Hello";

		signal.setComparator(new SelectiveSignalComparator1<String, String>() {
			public boolean compare(String key, String value0) {
				return value0.equals(key);
			}
		});

		signal.addFor(keyValue, new SignalListener1<String>() {
			public void apply(String value0) {
				atomicInt.incrementAndGet();
			}
		});

		signal.addFor("World", new SignalListener1<String>() {
			public void apply(String value0) {
				Assert.fail("This listener should not be called.");
			}
		});

		signal.dispatch(keyValue);

		Assert.assertEquals(atomicInt.get(), 1);
		Assert.assertEquals(signal.getNumListeners(), 2);
	}
	
	@Test
	public void verify_addOnceFor_is_called_with_Integer_value() throws Throwable {
		final AtomicInteger atomicInt = new AtomicInteger();

		final String keyValue = "Hello";

		signal.setComparator(new SelectiveSignalComparator1<String, String>() {
			public boolean compare(String key, String value0) {
				return value0.equals(key);
			}
		});

		signal.addOnceFor(keyValue, new SignalListener1<String>() {
			public void apply(String value0) {
				atomicInt.incrementAndGet();
			}
		});

		signal.addOnceFor("World", new SignalListener1<String>() {
			public void apply(String value0) {
				Assert.fail("This listener should not be called.");
			}
		});

		signal.dispatch(keyValue);

		Assert.assertEquals(atomicInt.get(), 1);
		Assert.assertEquals(signal.getNumListeners(), 1);
	}
}
