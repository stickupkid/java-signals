package org.osjava.signals.signal;

import org.junit.Before;
import org.osjava.signals.Signal4Base;
import org.osjava.signals.impl.SignalImpl.SignalImpl4;

/**
 * Created by IntelliJ IDEA. User: cereals Date: 16/09/4011
 */
public class Signal4Test extends Signal4Base {

	@Before
	public void setUp() {
		signal = SignalImpl4.newInstance();
	}
}
