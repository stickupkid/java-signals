package org.osjava.signals.signal;

import org.junit.Before;
import org.osjava.signals.Signal5Base;
import org.osjava.signals.impl.SignalImpl.SignalImpl5;

/**
 * Created by IntelliJ IDEA. User: cereals Date: 16/09/5011
 */
public class Signal5Test extends Signal5Base {

	@Before
	public void setUp() {
		signal = SignalImpl5.newInstance();
	}
}
