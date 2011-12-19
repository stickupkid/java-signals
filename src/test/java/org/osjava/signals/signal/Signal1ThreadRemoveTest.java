package org.osjava.signals.signal;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Before;
import org.osjava.signals.Signal1ThreadRemoveBase;
import org.osjava.signals.impl.SignalImpl.SignalImpl1;

public class Signal1ThreadRemoveTest extends Signal1ThreadRemoveBase {
	@Before
	public void setUp() {
		signal = SignalImpl1.newInstance();
		incrementer = new AtomicInteger();
	}
}
