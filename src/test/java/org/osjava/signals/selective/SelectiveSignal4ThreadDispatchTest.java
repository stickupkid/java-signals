package org.osjava.signals.selective;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Before;
import org.osjava.signals.SelectiveSignal.SelectiveSignal4;
import org.osjava.signals.SelectiveSignal.SelectiveSignal4.SelectiveSignalComparator4;
import org.osjava.signals.Signal4ThreadDispatchBase;
import org.osjava.signals.impl.SelectiveSignalImpl.SelectiveSignalImpl4;

public class SelectiveSignal4ThreadDispatchTest extends Signal4ThreadDispatchBase {

	private SelectiveSignal4<Integer, Integer, Integer, Integer, Integer> selectiveSignal;

	@Before
	public void setUp() {
		selectiveSignal = SelectiveSignalImpl4.newInstance();
		selectiveSignal
				.setComparator(new SelectiveSignalComparator4<Integer, Integer, Integer, Integer, Integer>() {
					public boolean compare(Integer key, Integer value0, Integer value1,
							Integer value2, Integer value3) {
						return true;
					}
				});
		signal = selectiveSignal;
		incrementer = new AtomicInteger();
	}

}
