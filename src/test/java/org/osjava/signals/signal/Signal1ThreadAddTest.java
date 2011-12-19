package org.osjava.signals.signal;

import org.junit.Before;
import org.osjava.signals.Signal1ThreadAddBase;
import org.osjava.signals.impl.SignalImpl.SignalImpl1;

/**
 * Created by IntelliJ IDEA. User: cereals Date: 13/10/2011
 */
public class Signal1ThreadAddTest extends Signal1ThreadAddBase {

	@Before
	public void setUp() {
		signal = SignalImpl1.newInstance();
	}
}
