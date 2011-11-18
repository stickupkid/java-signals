package org.osjava.signals.signal;

import org.junit.Before;
import org.osjava.signals.Signal4ParamsBase;
import org.osjava.signals.impl.SignalImpl.SignalImpl4;

public class Signal4ParamsTest extends Signal4ParamsBase {

	@Before
	public void setUp() {
		signal = SignalImpl4.newInstance();
	}
}
