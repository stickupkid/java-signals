package org.osjava.signals.priority;

import org.junit.Before;
import org.osjava.signals.Signal1Base;
import org.osjava.signals.impl.PrioritySignalImpl.PrioritySignalImpl1;

/**
 * Created by IntelliJ IDEA. User: cereals Date: 16/09/2011
 */
public class PrioritySignal1Test extends Signal1Base {

	@Before
	public void setUp() {
		signal = PrioritySignalImpl1.newInstance();
	}
}
