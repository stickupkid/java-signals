package org.osjava.signals.priority;

import org.junit.Before;
import org.osjava.signals.Signal5Base;
import org.osjava.signals.impl.PrioritySignalImpl.PrioritySignalImpl5;

/**
 * Created by IntelliJ IDEA. User: cereals Date: 16/09/5011
 */
public class PrioritySignal5Test extends Signal5Base {

	@Before
	public void setUp() {
		signal = PrioritySignalImpl5.newInstance();
	}
}
