package org.osjava.signals.signal;

import org.junit.Before;
import org.osjava.signals.Signal3Base;
import org.osjava.signals.impl.SignalImpl.SignalImpl3;

/**
 * Created by IntelliJ IDEA. User: cereals Date: 16/09/3011
 */
public class Signal3Test extends Signal3Base {

	@Before
	public void setUp() {
		signal = SignalImpl3.newInstance();
	}
}
