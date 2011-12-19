package org.osjava.signals.priority;

import org.junit.Before;
import org.osjava.signals.Signal3Base;
import org.osjava.signals.impl.PrioritySignalImpl.PrioritySignalImpl3;

/**
 * Created by IntelliJ IDEA. User: cereals Date: 16/09/3011
 */
public class PrioritySignal3Test extends Signal3Base {

	@Before
	public void setUp() {
		signal = PrioritySignalImpl3.newInstance();
	}
}
