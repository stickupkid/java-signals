package org.osjava.signals.priority;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Before;
import org.osjava.signals.Signal1ThreadRemoveBase;
import org.osjava.signals.impl.PrioritySignalImpl.PrioritySignalImpl1;

public class PrioritySignal1ThreadRemoveTest extends Signal1ThreadRemoveBase {
	@Before
	public void setUp() {
		signal = PrioritySignalImpl1.newInstance();
		incrementer = new AtomicInteger();
	}
}
