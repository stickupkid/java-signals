package org.osjava.signals.signal;

import org.junit.Before;
import org.osjava.signals.Signal3ThreadAddBase;
import org.osjava.signals.impl.SignalImpl.SignalImpl3;

/**
 * Created by IntelliJ IDEA. User: cereals Date: 13/10/3011
 */
public class Signal3ThreadAddTest extends Signal3ThreadAddBase {

	@Before
	public void setUp() {
		signal = SignalImpl3.newInstance();
	}
}
