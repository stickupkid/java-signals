package org.osjava.signals.priority;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Before;
import org.osjava.signals.Signal0ThreadRemoveBase;
import org.osjava.signals.impl.PrioritySignalImpl.PrioritySignalImpl0;

public class PrioritySignal0ThreadRemoveTest extends Signal0ThreadRemoveBase {

	@Before
	public void setUp() {
		signal = PrioritySignalImpl0.newInstance();
		incrementer = new AtomicInteger();
	}
}
