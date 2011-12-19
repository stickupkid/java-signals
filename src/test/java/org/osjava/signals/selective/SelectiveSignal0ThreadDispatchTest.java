package org.osjava.signals.selective;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Before;
import org.osjava.signals.SelectiveSignal.SelectiveSignal0;
import org.osjava.signals.SelectiveSignal.SelectiveSignal0.SelectiveSignalComparator0;
import org.osjava.signals.Signal0ThreadDispatchBase;
import org.osjava.signals.impl.SelectiveSignalImpl.SelectiveSignalImpl0;

public class SelectiveSignal0ThreadDispatchTest extends Signal0ThreadDispatchBase {

	private SelectiveSignal0<Integer> selectiveSignal;

	@Before
	public void setUp() {
		selectiveSignal = SelectiveSignalImpl0.newInstance();
		selectiveSignal.setComparator(new SelectiveSignalComparator0<Integer>() {
			public boolean compare(Integer key) {
				return true;
			}
		});
		signal = selectiveSignal;
		incrementer = new AtomicInteger();
	}
}
