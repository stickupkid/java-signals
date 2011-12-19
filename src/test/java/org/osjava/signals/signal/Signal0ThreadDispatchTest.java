package org.osjava.signals.signal;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Before;
import org.osjava.signals.Signal0ThreadDispatchBase;
import org.osjava.signals.impl.SignalImpl.SignalImpl0;

public class Signal0ThreadDispatchTest extends Signal0ThreadDispatchBase {

	@Before
	public void setUp() {
		signal = SignalImpl0.newInstance();
		incrementer = new AtomicInteger();
	}
}
