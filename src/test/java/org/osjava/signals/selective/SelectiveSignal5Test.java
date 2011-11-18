package org.osjava.signals.selective;

import org.junit.Before;
import org.osjava.signals.SelectiveSignal.SelectiveSignal5;
import org.osjava.signals.Signal5Base;
import org.osjava.signals.impl.SelectiveSignalImpl.SelectiveSignalImpl5;

public class SelectiveSignal5Test extends Signal5Base {

	private SelectiveSignal5<String, Boolean, String, String, String, String> selectiveSignal;

	@Before
	public void setUp() {
		selectiveSignal = SelectiveSignalImpl5.newInstance();
		signal = selectiveSignal;
	}
}
