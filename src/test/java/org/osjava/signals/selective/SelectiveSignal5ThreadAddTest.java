package org.osjava.signals.selective;

import org.junit.Before;
import org.osjava.signals.SelectiveSignal.SelectiveSignal5;
import org.osjava.signals.Signal5ThreadAddBase;
import org.osjava.signals.impl.SelectiveSignalImpl.SelectiveSignalImpl5;

public class SelectiveSignal5ThreadAddTest extends Signal5ThreadAddBase {

	private SelectiveSignal5<Boolean, Boolean, String, Integer, Integer, String> selectiveSignal;

	@Before
	public void setUp() {
		selectiveSignal = SelectiveSignalImpl5.newInstance();
		signal = selectiveSignal;
	}
}
