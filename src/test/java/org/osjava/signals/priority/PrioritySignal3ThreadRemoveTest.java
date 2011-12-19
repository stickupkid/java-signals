package org.osjava.signals.priority;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Before;
import org.osjava.signals.Signal3ThreadRemoveBase;
import org.osjava.signals.impl.PrioritySignalImpl.PrioritySignalImpl3;

public class PrioritySignal3ThreadRemoveTest extends Signal3ThreadRemoveBase {

	@Before
	public void setUp() {
		signal = PrioritySignalImpl3.newInstance();
		incrementer = new AtomicInteger();
	}
}
