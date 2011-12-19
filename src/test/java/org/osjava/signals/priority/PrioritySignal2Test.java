package org.osjava.signals.priority;

import org.junit.Before;
import org.osjava.signals.Signal2Base;
import org.osjava.signals.impl.PrioritySignalImpl.PrioritySignalImpl2;

/**
 * Created by IntelliJ IDEA. User: cereals Date: 16/09/2011
 */
public class PrioritySignal2Test extends Signal2Base {

	@Before
	public void setUp() {
		signal = PrioritySignalImpl2.newInstance();
	}
}
