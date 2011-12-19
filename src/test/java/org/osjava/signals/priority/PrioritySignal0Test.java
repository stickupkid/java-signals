//
// java-signals - Simple, type-safe event dispatching
// Copyright (c) 2011, Three Rings Design, Inc. - All rights reserved.
// https://github.com/osjava/java-signals/blob/master/LICENSE

package org.osjava.signals.priority;

import org.junit.Before;
import org.osjava.signals.Signal0Base;
import org.osjava.signals.impl.PrioritySignalImpl.PrioritySignalImpl0;

public class PrioritySignal0Test extends Signal0Base {

	@Before
	public void setUp() {
		signal = PrioritySignalImpl0.newInstance();
	}
}
