package org.osjava.signals.signal;

import org.junit.Before;
import org.osjava.signals.Signal0ThreadAddBase;
import org.osjava.signals.impl.SignalImpl.SignalImpl0;

/**
 * Created by IntelliJ IDEA. User: simonrichardson Date: 26/09/2011 Time: 09:53
 */
public class Signal0ThreadAddTest extends Signal0ThreadAddBase {

	@Before
	public void setUp() {
		signal = SignalImpl0.newInstance();
	}
}
