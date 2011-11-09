package org.osjava.signals;

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
	public void test() throws Throwable {

		final int keyValue = 42;

		signal.setComparator(new SelectiveSignalComparator0<Integer>() {
			public boolean compare(Integer key) {
				return key.equals(keyValue);
			}
		});

		signal.addFor(keyValue, new SignalListener0() {
			public void apply() {

			}
		});

		signal.dispatch();
	}

}
