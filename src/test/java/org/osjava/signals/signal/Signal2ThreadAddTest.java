package org.osjava.signals.signal;

import org.junit.Before;
import org.osjava.signals.Signal2ThreadAddBase;
import org.osjava.signals.impl.SignalImpl.SignalImpl2;

/**
 * Created by IntelliJ IDEA. User: cereals Date: 13/10/2011
 */
public class Signal2ThreadAddTest extends Signal2ThreadAddBase {

	@Before
	public void setUp() {
		signal = SignalImpl2.newInstance();
	}
}
