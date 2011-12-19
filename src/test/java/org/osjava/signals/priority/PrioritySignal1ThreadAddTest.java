package org.osjava.signals.priority;

import org.junit.Before;
import org.osjava.signals.Signal1ThreadAddBase;
import org.osjava.signals.impl.PrioritySignalImpl.PrioritySignalImpl1;

/**
 * Created by IntelliJ IDEA. User: cereals Date: 13/10/2011
 */
public class PrioritySignal1ThreadAddTest extends Signal1ThreadAddBase {

	@Before
	public void setUp() {
		signal = PrioritySignalImpl1.newInstance();
	}
}
