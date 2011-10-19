//
// java-signals - Simple, type-safe event dispatching
// Copyright (c) 2011, Three Rings Design, Inc. - All rights reserved.
// https://github.com/osjava/java-signals/blob/master/LICENSE

package org.osjava.signals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.osjava.signals.impl.SignalImpl0;

public class Signal0Test {

	private Signal0 signal;

	@Before
	public void setUp() {
		signal = SignalImpl0.newInstance();
	}

	@After
	public void tearDown() {
		signal.removeAll();
	}

	@Test
	public void verify_that_getNumListeners_is_zero() {
		Assert.assertEquals("Signal getNumListeners should be zero", 0, signal.getNumListeners());
	}

	@Test
	public void verify_that_add_makes_getNumListeners_equal_one() {
		signal.add(new Signal0.SignalListener0() {
			public void apply() {
			}
		});

		Assert.assertEquals("Signal getNumListeners should equal one after add", 1,
				signal.getNumListeners());
	}

	@Test
	public void verify_that_add_makes_getNumListeners_equal_ten() {
		final int total = 10;

		final Signal0.SignalListener0 listener = new Signal0.SignalListener0() {
			public void apply() {
			}
		};

		for (int i = 0; i < total; i++) {
			signal.add(listener);
		}

		Assert.assertEquals("Signal getNumListeners should equal total after add", total,
				signal.getNumListeners());
	}

	@Test
	public void verify_that_add_once_makes_getNumListeners_equal_one() {
		signal.addOnce(new Signal0.SignalListener0() {
			public void apply() {
			}
		});

		Assert.assertEquals("Signal getNumListeners should equal one after add once", 1,
				signal.getNumListeners());
	}

	@Test
	public void verify_that_add_once_makes_getNumListeners_equal_ten() {
		final int total = 10;

		final Signal0.SignalListener0 listener = new Signal0.SignalListener0() {
			public void apply() {
			}
		};

		for (int i = 0; i < total; i++) {
			signal.addOnce(listener);
		}

		Assert.assertEquals("Signal getNumListeners should equal total after add once", total,
				signal.getNumListeners());
	}

	@Test
	public void verify_that_after_add_that_getNumListeners_equal_one_after_dispatch() {
		signal.add(new Signal0.SignalListener0() {
			public void apply() {
			}
		});

		signal.dispatch();

		Assert.assertEquals("Signal getNumListeners should equal one after add and then dispatch",
				1, signal.getNumListeners());
	}

	@Test
	public void verify_that_after_add_once_that_getNumListeners_equal_one_after_dispatch() {
		signal.addOnce(new Signal0.SignalListener0() {
			public void apply() {
			}
		});

		signal.dispatch();

		Assert.assertEquals("Signal getNumListeners should equal one after add once and then "
				+ "dispatch", 0, signal.getNumListeners());
	}

	@Test
	public void verify_that_a_listener_is_called_after_dispatch() {
		signal.add(new Signal0.SignalListener0() {
			public void apply() {
				Assert.assertTrue("Signal0 apply was called when dispatched", true);
			}
		});

		signal.dispatch();
	}

	@Test
	public void verify_that_multiple_listeners_are_called_after_dispatch() {
		final int total = 10;
		final ArrayList<Boolean> active = new ArrayList<Boolean>();

		final Signal0.SignalListener0 listener = new Signal0.SignalListener0() {
			public void apply() {
				active.add(true);
			}
		};

		for (int i = 0; i < total; i++) {
			signal.add(listener);
		}

		signal.dispatch();

		Assert.assertEquals("Number of signals dispatched should equal total", 10, active.size());
	}
}
