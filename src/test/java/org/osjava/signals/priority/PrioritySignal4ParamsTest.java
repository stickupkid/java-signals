package org.osjava.signals.priority;

import org.junit.Before;
import org.osjava.signals.Signal4ParamsBase;
import org.osjava.signals.impl.PrioritySignalImpl.PrioritySignalImpl4;

public class PrioritySignal4ParamsTest extends Signal4ParamsBase {

	@Before
	public void setUp() {
		signal = PrioritySignalImpl4.newInstance();
	}
}
