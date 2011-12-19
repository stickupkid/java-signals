package org.osjava.signals.priority;

import org.junit.Before;
import org.osjava.signals.Signal5ParamsBase;
import org.osjava.signals.impl.PrioritySignalImpl.PrioritySignalImpl5;

public class PrioritySignal5ParamsTest extends Signal5ParamsBase {

	@Before
	public void setUp() {
		signal = PrioritySignalImpl5.newInstance();
	}
}
