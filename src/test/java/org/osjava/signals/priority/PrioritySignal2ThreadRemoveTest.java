package org.osjava.signals.priority;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Before;
import org.osjava.signals.Signal2ThreadRemoveBase;
import org.osjava.signals.impl.PrioritySignalImpl.PrioritySignalImpl2;

public class PrioritySignal2ThreadRemoveTest extends Signal2ThreadRemoveBase {

	@Before
	public void setUp() {
		signal = PrioritySignalImpl2.newInstance();
		incrementer = new AtomicInteger();
	}
}
