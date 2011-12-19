package org.osjava.signals.priority;

import org.junit.Before;
import org.osjava.signals.Signal5ThreadAddBase;
import org.osjava.signals.impl.PrioritySignalImpl.PrioritySignalImpl5;

/**
 * Created by IntelliJ IDEA. User: cereals Date: 15/10/5011
 */
public class PrioritySignal5ThreadAddTest extends Signal5ThreadAddBase {

	@Before
	public void setUp() {
		signal = PrioritySignalImpl5.newInstance();
	}
}
