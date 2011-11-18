package org.osjava.signals.selective;

import org.junit.Before;
import org.osjava.signals.SelectiveSignal.SelectiveSignal4;
import org.osjava.signals.Signal4Base;
import org.osjava.signals.impl.SelectiveSignalImpl.SelectiveSignalImpl4;

public class SelectiveSignal4Test extends Signal4Base {

	private SelectiveSignal4<String, Boolean, String, String, String> selectiveSignal;

	@Before
	public void setUp() {
		selectiveSignal = SelectiveSignalImpl4.newInstance();
		signal = selectiveSignal;
	}
}
