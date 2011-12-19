package org.osjava.signals.priority;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Before;
import org.osjava.signals.Signal4ThreadRemoveBase;
import org.osjava.signals.impl.PrioritySignalImpl.PrioritySignalImpl4;

public class PrioritySignal4ThreadRemoveTest extends Signal4ThreadRemoveBase {

	@Before
	public void setUp() {
		signal = PrioritySignalImpl4.newInstance();
		incrementer = new AtomicInteger();
	}
}
