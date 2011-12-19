package org.osjava.signals.priority;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Before;
import org.osjava.signals.Signal3ThreadDispatchBase;
import org.osjava.signals.impl.PrioritySignalImpl.PrioritySignalImpl3;

public class PrioritySignal3ThreadDispatchTest extends Signal3ThreadDispatchBase {

	@Before
	public void setUp() {
		signal = PrioritySignalImpl3.newInstance();
		incrementer = new AtomicInteger();
	}
}
