package org.osjava.signals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
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
	public void test() throws Throwable {
		signal.setComparator(new SelectiveSignalComparator2<String, String, Integer>(){
			public boolean compare(String key, String value0, Integer value1) {
				return value0.equals(key);
			}
		});
		
		signal.addFor("Hello", new SignalListener2<String, Integer>() {
			public void apply(String value0, Integer value1) {
				// This should work
			}
		});
		
		signal.addFor("World", new SignalListener2<String, Integer>() {
			public void apply(String value0, Integer value1) {
				// This should not work
			}
		});
		
		signal.dispatch("Hello", 42);
	}
}
