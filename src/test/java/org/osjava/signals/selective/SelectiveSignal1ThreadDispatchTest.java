package org.osjava.signals.selective;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Before;
import org.osjava.signals.SelectiveSignal.SelectiveSignal1;
import org.osjava.signals.SelectiveSignal.SelectiveSignal1.SelectiveSignalComparator1;
import org.osjava.signals.Signal1ThreadDispatchBase;
import org.osjava.signals.impl.SelectiveSignalImpl.SelectiveSignalImpl1;

public class SelectiveSignal1ThreadDispatchTest extends Signal1ThreadDispatchBase {

	private SelectiveSignal1<Integer, Integer> selectiveSignal;

	@Before
	public void setUp() {
		selectiveSignal = SelectiveSignalImpl1.newInstance();
		selectiveSignal.setComparator(new SelectiveSignalComparator1<Integer, Integer>() {
			public boolean compare(Integer key, Integer value0) {
				return true;
			}
		});
		signal = selectiveSignal;
		incrementer = new AtomicInteger();
	}
}
