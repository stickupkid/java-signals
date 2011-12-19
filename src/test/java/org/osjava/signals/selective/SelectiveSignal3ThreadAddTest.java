package org.osjava.signals.selective;

import org.junit.Before;
import org.osjava.signals.SelectiveSignal.SelectiveSignal3;
import org.osjava.signals.Signal3ThreadAddBase;
import org.osjava.signals.impl.SelectiveSignalImpl.SelectiveSignalImpl3;

public class SelectiveSignal3ThreadAddTest extends Signal3ThreadAddBase {

	private SelectiveSignal3<Boolean, Boolean, String, Integer> selectiveSignal;

	@Before
	public void setUp() {
		selectiveSignal = SelectiveSignalImpl3.newInstance();
		signal = selectiveSignal;
	}
}
