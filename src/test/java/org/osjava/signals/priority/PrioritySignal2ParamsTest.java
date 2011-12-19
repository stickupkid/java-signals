package org.osjava.signals.priority;

import org.junit.Before;
import org.osjava.signals.Signal2ParamsBase;
import org.osjava.signals.impl.PrioritySignalImpl.PrioritySignalImpl2;

public class PrioritySignal2ParamsTest extends Signal2ParamsBase {

	@Before
	public void setUp() {
		signal = PrioritySignalImpl2.newInstance();
	}
}
