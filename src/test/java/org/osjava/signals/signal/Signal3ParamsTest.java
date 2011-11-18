package org.osjava.signals.signal;

import org.junit.Before;
import org.osjava.signals.Signal3ParamsBase;
import org.osjava.signals.impl.SignalImpl.SignalImpl3;

public class Signal3ParamsTest extends Signal3ParamsBase {

	@Before
	public void setUp() {
		signal = SignalImpl3.newInstance();
	}
}
