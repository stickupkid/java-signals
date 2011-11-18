package org.osjava.signals.selective;

import org.junit.Before;
import org.osjava.signals.SelectiveSignal.SelectiveSignal3;
import org.osjava.signals.Signal3ParamsBase;
import org.osjava.signals.impl.SelectiveSignalImpl.SelectiveSignalImpl3;

public class SelectiveSignal3ParamsTest extends Signal3ParamsBase {

	private SelectiveSignal3<String, String, String, String> selectiveSignal;

	@Before
	public void setUp() {
		selectiveSignal = SelectiveSignalImpl3.newInstance();
		signal = selectiveSignal;
	}
}
