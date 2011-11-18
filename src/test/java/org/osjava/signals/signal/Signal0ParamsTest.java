package org.osjava.signals.signal;

import org.junit.Before;
import org.osjava.signals.Signal0ParamsBase;
import org.osjava.signals.impl.SignalImpl.SignalImpl0;

public class Signal0ParamsTest extends Signal0ParamsBase {

	@Before
	public void setUp() {
		signal = SignalImpl0.newInstance();
	}
}
