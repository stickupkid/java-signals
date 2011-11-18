package org.osjava.signals.selective;

import org.junit.Before;
import org.osjava.signals.SelectiveSignal.SelectiveSignal5;
import org.osjava.signals.Signal5ParamsBase;
import org.osjava.signals.impl.SelectiveSignalImpl.SelectiveSignalImpl5;

public class SelectiveSignal5ParamsTest extends Signal5ParamsBase {

	private SelectiveSignal5<String, String, String, String, String, String> selectiveSignal;

	@Before
	public void setUp() {
		selectiveSignal = SelectiveSignalImpl5.newInstance();
		signal = selectiveSignal;
	}
}
