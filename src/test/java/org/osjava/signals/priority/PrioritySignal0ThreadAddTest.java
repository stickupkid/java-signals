package org.osjava.signals.priority;

import org.junit.Before;
import org.osjava.signals.Signal0ThreadAddBase;
import org.osjava.signals.impl.PrioritySignalImpl.PrioritySignalImpl0;

/**
 * Created by IntelliJ IDEA. User: simonrichardson Date: 26/09/2011 Time: 09:53
 */
public class PrioritySignal0ThreadAddTest extends Signal0ThreadAddBase {

	@Before
	public void setUp() {
		signal = PrioritySignalImpl0.newInstance();
	}
}
