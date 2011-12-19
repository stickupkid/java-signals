package org.osjava.signals.signal;

import org.junit.Before;
import org.osjava.signals.Signal5ThreadAddBase;
import org.osjava.signals.impl.SignalImpl.SignalImpl5;

/**
 * Created by IntelliJ IDEA. User: cereals Date: 15/10/5011
 */
public class Signal5ThreadAddTest extends Signal5ThreadAddBase {

	@Before
	public void setUp() {
		signal = SignalImpl5.newInstance();
	}
}
