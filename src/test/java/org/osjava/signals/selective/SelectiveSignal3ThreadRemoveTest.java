package org.osjava.signals.selective;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Before;
import org.osjava.signals.SelectiveSignal.SelectiveSignal3;
import org.osjava.signals.SelectiveSignal.SelectiveSignal3.SelectiveSignalComparator3;
import org.osjava.signals.Signal3ThreadRemoveBase;
import org.osjava.signals.impl.SelectiveSignalImpl.SelectiveSignalImpl3;

public class SelectiveSignal3ThreadRemoveTest extends Signal3ThreadRemoveBase {

	private SelectiveSignal3<Integer, Integer, Integer, Integer> selectiveSignal;

	@Before
	public void setUp() {
		selectiveSignal = SelectiveSignalImpl3.newInstance();
		selectiveSignal
				.setComparator(new SelectiveSignalComparator3<Integer, Integer, Integer, Integer>() {
					public boolean compare(Integer key, Integer value0, Integer value1,
							Integer value2) {
						return true;
					}
				});
		signal = selectiveSignal;
		incrementer = new AtomicInteger();
	}
}
