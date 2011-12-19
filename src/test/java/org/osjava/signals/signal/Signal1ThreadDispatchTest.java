package org.osjava.signals.signal;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Before;
import org.osjava.signals.Signal1ThreadDispatchBase;
import org.osjava.signals.impl.SignalImpl.SignalImpl1;

public class Signal1ThreadDispatchTest extends Signal1ThreadDispatchBase {

	@Before
	public void setUp() {
		signal = SignalImpl1.newInstance();
		incrementer = new AtomicInteger();
	}
}
