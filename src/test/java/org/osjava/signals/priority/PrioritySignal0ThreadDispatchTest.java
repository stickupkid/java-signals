package org.osjava.signals.priority;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Before;
import org.osjava.signals.Signal0ThreadDispatchBase;
import org.osjava.signals.impl.PrioritySignalImpl.PrioritySignalImpl0;

public class PrioritySignal0ThreadDispatchTest extends Signal0ThreadDispatchBase {

	@Before
	public void setUp() {
		signal = PrioritySignalImpl0.newInstance();
		incrementer = new AtomicInteger();
	}
}
