package org.osjava.signals.selective;

import org.junit.Before;
import org.osjava.signals.SelectiveSignal.SelectiveSignal1;
import org.osjava.signals.Signal1ParamsBase;
import org.osjava.signals.impl.SelectiveSignalImpl.SelectiveSignalImpl1;

public class SelectiveSignal1ParamsTest extends Signal1ParamsBase {

	private SelectiveSignal1<String, String> selectiveSignal;

	@Before
	public void setUp() {
		selectiveSignal = SelectiveSignalImpl1.newInstance();
		signal = selectiveSignal;
	}
}
