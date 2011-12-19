package org.osjava.signals.signal;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Before;
import org.osjava.signals.Signal5ThreadRemoveBase;
import org.osjava.signals.impl.SignalImpl.SignalImpl5;

public class Signal5ThreadRemoveTest extends Signal5ThreadRemoveBase {

	@Before
	public void setUp() {
		signal = SignalImpl5.newInstance();
		incrementer = new AtomicInteger();
	}
}
