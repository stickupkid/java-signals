package org.osjava.signals.selective;

import org.junit.Before;
import org.osjava.signals.SelectiveSignal.SelectiveSignal0;
import org.osjava.signals.Signal0ParamsBase;
import org.osjava.signals.impl.SelectiveSignalImpl.SelectiveSignalImpl0;

public class SelectiveSignal0ParamsTest extends Signal0ParamsBase {

	private SelectiveSignal0<Integer> selectiveSignal;

	@Before
	public void setUp() {
		selectiveSignal = SelectiveSignalImpl0.newInstance();
		signal = selectiveSignal;
	}
}
