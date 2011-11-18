package org.osjava.signals.signal;

import org.junit.Before;
import org.osjava.signals.Signal1ParamsBase;
import org.osjava.signals.impl.SignalImpl.SignalImpl1;

public class Signal1ParamsTest extends Signal1ParamsBase {

	@Before
	public void setUp() {
		signal = SignalImpl1.newInstance();
	}
}
