package org.osjava.signals.signal;

import org.junit.Before;
import org.osjava.signals.Signal1Base;
import org.osjava.signals.impl.SignalImpl.SignalImpl1;

/**
 * Created by IntelliJ IDEA. User: cereals Date: 16/09/2011
 */
public class Signal1Test extends Signal1Base {

	@Before
	public void setUp() {
		signal = SignalImpl1.newInstance();
	}
}
