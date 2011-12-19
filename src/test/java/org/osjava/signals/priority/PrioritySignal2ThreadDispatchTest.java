package org.osjava.signals.priority;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Before;
import org.osjava.signals.Signal2ThreadDispatchBase;
import org.osjava.signals.impl.PrioritySignalImpl.PrioritySignalImpl2;

public class PrioritySignal2ThreadDispatchTest extends Signal2ThreadDispatchBase {

	@Before
	public void setUp() {
		signal = PrioritySignalImpl2.newInstance();
		incrementer = new AtomicInteger();
	}
}
