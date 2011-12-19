package org.osjava.signals.priority;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Before;
import org.osjava.signals.Signal5ThreadRemoveBase;
import org.osjava.signals.impl.PrioritySignalImpl.PrioritySignalImpl5;

public class PrioritySignal5ThreadRemoveTest extends Signal5ThreadRemoveBase {

	@Before
	public void setUp() {
		signal = PrioritySignalImpl5.newInstance();
		incrementer = new AtomicInteger();
	}
}
