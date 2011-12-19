package org.osjava.signals.selective;

import org.junit.Before;
import org.osjava.signals.SelectiveSignal.SelectiveSignal0;
import org.osjava.signals.Signal0ThreadAddBase;
import org.osjava.signals.impl.SelectiveSignalImpl.SelectiveSignalImpl0;

public class SelectiveSignal0ThreadAddTest extends Signal0ThreadAddBase {

	private SelectiveSignal0<Integer> selectiveSignal;

	@Before
	public void setUp() {
		selectiveSignal = SelectiveSignalImpl0.newInstance();
		signal = selectiveSignal;
	}
}
