package org.osjava.signals.signal;

import org.junit.Before;
import org.osjava.signals.Signal2ParamsBase;
import org.osjava.signals.impl.SignalImpl.SignalImpl2;

public class Signal2ParamsTest extends Signal2ParamsBase {

	@Before
	public void setUp() {
		signal = SignalImpl2.newInstance();
	}
}
