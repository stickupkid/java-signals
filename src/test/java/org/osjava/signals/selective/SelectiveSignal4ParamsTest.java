package org.osjava.signals.selective;

import org.junit.Before;
import org.osjava.signals.SelectiveSignal.SelectiveSignal4;
import org.osjava.signals.Signal4ParamsBase;
import org.osjava.signals.impl.SelectiveSignalImpl.SelectiveSignalImpl4;

public class SelectiveSignal4ParamsTest extends Signal4ParamsBase {

	private SelectiveSignal4<String, String, String, String, String> selectiveSignal;

	@Before
	public void setUp() {
		selectiveSignal = SelectiveSignalImpl4.newInstance();
		signal = selectiveSignal;
	}
}
