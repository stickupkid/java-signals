package org.osjava.signals.selective;

import org.junit.Before;
import org.osjava.signals.SelectiveSignal.SelectiveSignal4;
import org.osjava.signals.Signal4ThreadAddBase;
import org.osjava.signals.impl.SelectiveSignalImpl.SelectiveSignalImpl4;

public class SelectiveSignal4ThreadAddTest extends Signal4ThreadAddBase {

	private SelectiveSignal4<Boolean, Boolean, String, Integer, Integer> selectiveSignal;

	@Before
	public void setUp() {
		selectiveSignal = SelectiveSignalImpl4.newInstance();
		signal = selectiveSignal;
	}
}
