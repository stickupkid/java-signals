package org.osjava.signals;

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
	public void test() throws Throwable {
		signal.setComparator(new SelectiveSignalComparator1<String, String>(){
			public boolean compare(String key, String value0) {
				return value0.equals(key);
			}
		});
		
		signal.addFor("Hello", new SignalListener1<String>() {
			public void apply(String value0) {
				// This should work
			}
		});
		
		signal.addFor("World", new SignalListener1<String>() {
			public void apply(String value0) {
				// This should not work
			}
		});
		
		signal.dispatch("Hello");
	}
	
}
