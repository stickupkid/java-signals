package org.osjava.signals.signal;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Before;
import org.osjava.signals.Signal0ThreadRemoveBase;
import org.osjava.signals.impl.SignalImpl.SignalImpl0;

public class Signal0ThreadRemoveTest extends Signal0ThreadRemoveBase {

	@Before
	public void setUp() {
		signal = SignalImpl0.newInstance();
		incrementer = new AtomicInteger();
	}
}
