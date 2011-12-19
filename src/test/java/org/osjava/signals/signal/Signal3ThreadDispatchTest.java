package org.osjava.signals.signal;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Before;
import org.osjava.signals.Signal3ThreadDispatchBase;
import org.osjava.signals.impl.SignalImpl.SignalImpl3;

public class Signal3ThreadDispatchTest extends Signal3ThreadDispatchBase {

	@Before
	public void setUp() {
		signal = SignalImpl3.newInstance();
		incrementer = new AtomicInteger();
	}
}
