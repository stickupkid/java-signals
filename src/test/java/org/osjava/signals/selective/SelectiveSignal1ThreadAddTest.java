package org.osjava.signals.selective;

import org.junit.Before;
import org.osjava.signals.SelectiveSignal.SelectiveSignal1;
import org.osjava.signals.Signal1ThreadAddBase;
import org.osjava.signals.impl.SelectiveSignalImpl.SelectiveSignalImpl1;

public class SelectiveSignal1ThreadAddTest extends Signal1ThreadAddBase {

	private SelectiveSignal1<Boolean, Boolean> selectiveSignal;

	@Before
	public void setUp() {
		selectiveSignal = SelectiveSignalImpl1.newInstance();
		signal = selectiveSignal;
	}
}
