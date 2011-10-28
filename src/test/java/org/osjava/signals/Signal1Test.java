package org.osjava.signals;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.osjava.signals.Signal.Signal1;
import org.osjava.signals.SignalListener.SignalListener1;
import org.osjava.signals.impl.SignalImpl.SignalImpl1;

/**
 * Created by IntelliJ IDEA. User: cereals Date: 16/09/2011
 */
public class Signal1Test {

	private Signal1<Boolean> signal;

	@Before
	public void setUp() {
		signal = SignalImpl1.newInstance();
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
		signal.add(new SignalListener1<Boolean>() {
			public void apply(Boolean value) {
			}
		});

		Assert.assertEquals("Signal getNumListeners should equal one after add", 1,
				signal.getNumListeners());
	}

	@Test
	public void verify_that_add_makes_getNumListeners_equal_ten() {
		final int total = 10;

		final SignalListener1<Boolean> listener = new SignalListener1<Boolean>() {
			public void apply(Boolean value) {
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
		signal.addOnce(new SignalListener1<Boolean>() {
			public void apply(Boolean value) {
			}
		});

		Assert.assertEquals("Signal getNumListeners should equal one after add once", 1,
				signal.getNumListeners());
	}

	@Test
	public void verify_that_add_once_makes_getNumListeners_equal_ten() {
		final int total = 10;

		final SignalListener1<Boolean> listener = new SignalListener1<Boolean>() {
			public void apply(Boolean value) {
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
		signal.add(new SignalListener1<Boolean>() {
			public void apply(Boolean value) {
			}
		});

		signal.dispatch(true);

		Assert.assertEquals("Signal getNumListeners should equal one after add and then dispatch",
				1, signal.getNumListeners());
	}

	@Test
	public void verify_that_after_add_once_that_getNumListeners_equal_one_after_dispatch() {
		signal.addOnce(new SignalListener1<Boolean>() {
			public void apply(Boolean value) {
			}
		});

		signal.dispatch(true);

		Assert.assertEquals("Signal getNumListeners should equal one after add once and then "
				+ "dispatch", 0, signal.getNumListeners());
	}

	@Test
	public void verify_that_a_listener_is_called_after_dispatch() {
		signal.add(new SignalListener1<Boolean>() {
			public void apply(Boolean value) {
				Assert.assertTrue("Signal0 apply was called when dispatched", true);
			}
		});

		signal.dispatch(true);
	}

	@Test
	public void verify_that_multiple_listeners_are_called_after_dispatch() {
		final int total = 10;
		final ArrayList<Boolean> active = new ArrayList<Boolean>();

		final SignalListener1<Boolean> listener = new SignalListener1<Boolean>() {
			public void apply(Boolean value) {
				active.add(value);
			}
		};

		for (int i = 0; i < total; i++) {
			signal.add(listener);
		}

		signal.dispatch(true);

		Assert.assertEquals("Number of signals dispatched should equal total", 10, active.size());
	}
}
