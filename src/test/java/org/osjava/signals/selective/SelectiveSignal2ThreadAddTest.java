package org.osjava.signals.selective;

import org.junit.Before;
import org.osjava.signals.SelectiveSignal.SelectiveSignal2;
import org.osjava.signals.Signal2ThreadAddBase;
import org.osjava.signals.impl.SelectiveSignalImpl.SelectiveSignalImpl2;

public class SelectiveSignal2ThreadAddTest extends Signal2ThreadAddBase {

	private SelectiveSignal2<Boolean, Boolean, String> selectiveSignal;

	@Before
	public void setUp() {
		selectiveSignal = SelectiveSignalImpl2.newInstance();
		signal = selectiveSignal;
	}
}
