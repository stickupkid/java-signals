package org.osjava.signals.priority;

import org.junit.Before;
import org.osjava.signals.Signal2ThreadAddBase;
import org.osjava.signals.impl.PrioritySignalImpl.PrioritySignalImpl2;

/**
 * Created by IntelliJ IDEA. User: cereals Date: 13/10/2011
 */
public class PrioritySignal2ThreadAddTest extends Signal2ThreadAddBase {

	@Before
	public void setUp() {
		signal = PrioritySignalImpl2.newInstance();
	}
}
