package org.osjava.signals.priority;

import org.junit.Before;
import org.osjava.signals.Signal4Base;
import org.osjava.signals.impl.PrioritySignalImpl.PrioritySignalImpl4;

/**
 * Created by IntelliJ IDEA. User: cereals Date: 16/09/4011
 */
public class PrioritySignal4Test extends Signal4Base {

	@Before
	public void setUp() {
		signal = PrioritySignalImpl4.newInstance();
	}
}
