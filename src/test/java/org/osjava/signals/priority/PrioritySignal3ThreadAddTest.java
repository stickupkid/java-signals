package org.osjava.signals.priority;

import org.junit.Before;
import org.osjava.signals.Signal3ThreadAddBase;
import org.osjava.signals.impl.PrioritySignalImpl.PrioritySignalImpl3;

/**
 * Created by IntelliJ IDEA. User: cereals Date: 13/10/3011
 */
public class PrioritySignal3ThreadAddTest extends Signal3ThreadAddBase {

	@Before
	public void setUp() {
		signal = PrioritySignalImpl3.newInstance();
	}
}
