package org.osjava.signals.priority;

import org.junit.Before;
import org.osjava.signals.Signal4ThreadAddBase;
import org.osjava.signals.impl.PrioritySignalImpl.PrioritySignalImpl4;

/**
 * Created by IntelliJ IDEA. User: cereals Date: 14/10/4011
 */
public class PrioritySignal4ThreadAddTest extends Signal4ThreadAddBase {

	@Before
	public void setUp() {
		signal = PrioritySignalImpl4.newInstance();
	}
}