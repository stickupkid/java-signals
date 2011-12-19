package org.osjava.signals.priority;

import org.junit.Before;
import org.osjava.signals.Signal0ParamsBase;
import org.osjava.signals.impl.PrioritySignalImpl.PrioritySignalImpl0;

public class PrioritySignal0ParamsTest extends Signal0ParamsBase {

	@Before
	public void setUp() {
		signal = PrioritySignalImpl0.newInstance();
	}
}
