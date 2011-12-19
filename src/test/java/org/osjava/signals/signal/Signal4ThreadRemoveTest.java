package org.osjava.signals.signal;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Before;
import org.osjava.signals.Signal4ThreadRemoveBase;
import org.osjava.signals.impl.SignalImpl.SignalImpl4;

public class Signal4ThreadRemoveTest extends Signal4ThreadRemoveBase {

	@Before
	public void setUp() {
		signal = SignalImpl4.newInstance();
		incrementer = new AtomicInteger();
	}
}
