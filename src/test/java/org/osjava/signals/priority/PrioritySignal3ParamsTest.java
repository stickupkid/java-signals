package org.osjava.signals.priority;

import org.junit.Before;
import org.osjava.signals.Signal3ParamsBase;
import org.osjava.signals.impl.PrioritySignalImpl.PrioritySignalImpl3;

public class PrioritySignal3ParamsTest extends Signal3ParamsBase {

	@Before
	public void setUp() {
		signal = PrioritySignalImpl3.newInstance();
	}
}
