package org.osjava.signals.selective;

import org.junit.Before;
import org.osjava.signals.SelectiveSignal.SelectiveSignal2;
import org.osjava.signals.Signal2ParamsBase;
import org.osjava.signals.impl.SelectiveSignalImpl.SelectiveSignalImpl2;

public class SelectiveSignal2ParamsTest extends Signal2ParamsBase {

	private SelectiveSignal2<String, String, String> selectiveSignal;

	@Before
	public void setUp() {
		selectiveSignal = SelectiveSignalImpl2.newInstance();
		signal = selectiveSignal;
	}
}
