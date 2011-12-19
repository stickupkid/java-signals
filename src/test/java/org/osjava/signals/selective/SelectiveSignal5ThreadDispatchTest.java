package org.osjava.signals.selective;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Before;
import org.osjava.signals.SelectiveSignal.SelectiveSignal5;
import org.osjava.signals.SelectiveSignal.SelectiveSignal5.SelectiveSignalComparator5;
import org.osjava.signals.Signal5ThreadDispatchBase;
import org.osjava.signals.impl.SelectiveSignalImpl.SelectiveSignalImpl5;

public class SelectiveSignal5ThreadDispatchTest extends Signal5ThreadDispatchBase {

	private SelectiveSignal5<Integer, Integer, Integer, Integer, Integer, Integer> selectiveSignal;

	@Before
	public void setUp() {
		selectiveSignal = SelectiveSignalImpl5.newInstance();
		selectiveSignal
				.setComparator(new SelectiveSignalComparator5<Integer, Integer, Integer, Integer, Integer, Integer>() {
					public boolean compare(Integer key, Integer value0, Integer value1,
							Integer value2, Integer value3, Integer value4) {
						return true;
					}
				});
		signal = selectiveSignal;
		incrementer = new AtomicInteger();
	}
}
