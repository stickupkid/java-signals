package org.osjava.signals.signal;

import org.junit.Before;
import org.osjava.signals.Signal5ParamsBase;
import org.osjava.signals.impl.SignalImpl.SignalImpl5;

public class Signal5ParamsTest extends Signal5ParamsBase {

	@Before
	public void setUp() {
		signal = SignalImpl5.newInstance();
	}
}
