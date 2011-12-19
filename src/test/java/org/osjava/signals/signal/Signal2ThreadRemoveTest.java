package org.osjava.signals.signal;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Before;
import org.osjava.signals.Signal2ThreadRemoveBase;
import org.osjava.signals.impl.SignalImpl.SignalImpl2;

public class Signal2ThreadRemoveTest extends Signal2ThreadRemoveBase {

	@Before
	public void setUp() {
		signal = SignalImpl2.newInstance();
		incrementer = new AtomicInteger();
	}
}
