package org.osjava.signals.signal;

import org.junit.Before;
import org.osjava.signals.Signal4ThreadAddBase;
import org.osjava.signals.impl.SignalImpl.SignalImpl4;

/**
 * Created by IntelliJ IDEA. User: cereals Date: 14/10/4011
 */
public class Signal4ThreadAddTest extends Signal4ThreadAddBase {

	@Before
	public void setUp() {
		signal = SignalImpl4.newInstance();
	}
}
