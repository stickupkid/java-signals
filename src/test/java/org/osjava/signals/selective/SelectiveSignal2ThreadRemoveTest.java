package org.osjava.signals.selective;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Before;
import org.osjava.signals.SelectiveSignal.SelectiveSignal2;
import org.osjava.signals.SelectiveSignal.SelectiveSignal2.SelectiveSignalComparator2;
import org.osjava.signals.Signal2ThreadRemoveBase;
import org.osjava.signals.impl.SelectiveSignalImpl.SelectiveSignalImpl2;

public class SelectiveSignal2ThreadRemoveTest extends Signal2ThreadRemoveBase {

	private SelectiveSignal2<Integer, Integer, Integer> selectiveSignal;

	@Before
	public void setUp() {
		selectiveSignal = SelectiveSignalImpl2.newInstance();
		selectiveSignal.setComparator(new SelectiveSignalComparator2<Integer, Integer, Integer>() {
			public boolean compare(Integer key, Integer value0, Integer value1) {
				return true;
			}
		});
		signal = selectiveSignal;
		incrementer = new AtomicInteger();
	}
}
