package org.osjava.signals.priority;

import org.junit.Before;
import org.osjava.signals.Signal1ParamsBase;
import org.osjava.signals.impl.PrioritySignalImpl.PrioritySignalImpl1;

public class PrioritySignal1ParamsTest extends Signal1ParamsBase {

	@Before
	public void setUp() {
		signal = PrioritySignalImpl1.newInstance();
	}
}
