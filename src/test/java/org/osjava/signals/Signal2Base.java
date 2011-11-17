package org.osjava.signals;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Test;
import org.osjava.signals.Signal.Signal2;
import org.osjava.signals.SignalListener.SignalListener2;

public class Signal2Base {
	protected Signal2<String, Boolean> signal;

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
		signal.add(new SignalListener2<String, Boolean>() {
			public void apply(String value0, Boolean value1) {
			}
		});

		Assert.assertEquals("Signal getNumListeners should equal one after add", 1,
				signal.getNumListeners());
	}

	@Test
	public void verify_that_add_makes_getNumListeners_equal_ten() {
		final int total = 10;

		final SignalListener2<String, Boolean> listener = new SignalListener2<String, Boolean>() {
			public void apply(String value0, Boolean value1) {
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
		signal.addOnce(new SignalListener2<String, Boolean>() {
			public void apply(String value0, Boolean value1) {
			}
		});

		Assert.assertEquals("Signal getNumListeners should equal one after add once", 1,
				signal.getNumListeners());
	}

	@Test
	public void verify_that_add_once_makes_getNumListeners_equal_ten() {
		final int total = 10;

		final SignalListener2<String, Boolean> listener = new SignalListener2<String, Boolean>() {
			public void apply(String value0, Boolean value1) {
			}
		};

		for (int i = 0; i < total; i++) {
			signal.addOnce(listener);
		}

		Assert.assertEquals("Signal getNumListeners should equal total after add once", total,
				signal.getNumListeners());
	}

	@Test
	public void verify_that_after_add_that_getNumListeners_equal_one_after_dispatch()
			throws Throwable {
		signal.add(new SignalListener2<String, Boolean>() {
			public void apply(String value0, Boolean value1) {
			}
		});

		signal.dispatch("String", true);

		Assert.assertEquals("Signal getNumListeners should equal one after add and then dispatch",
				1, signal.getNumListeners());
	}

	@Test
	public void verify_that_after_add_once_that_getNumListeners_equal_one_after_dispatch()
			throws Throwable {
		signal.addOnce(new SignalListener2<String, Boolean>() {
			public void apply(String value0, Boolean value1) {
			}
		});

		signal.dispatch("String", true);

		Assert.assertEquals("Signal getNumListeners should equal one after add once and then "
				+ "dispatch", 0, signal.getNumListeners());
	}

	@Test
	public void verify_that_a_listener_is_called_after_dispatch() throws Throwable {
		signal.add(new SignalListener2<String, Boolean>() {
			public void apply(String value0, Boolean value1) {
				Assert.assertTrue("Signal0 apply was called when dispatched", true);
			}
		});

		signal.dispatch("String", true);
	}

	@Test
	public void verify_that_multiple_listeners_are_called_after_dispatch() throws Throwable {
		final int total = 10;
		final ArrayList<Boolean> active = new ArrayList<Boolean>();

		final SignalListener2<String, Boolean> listener = new SignalListener2<String, Boolean>() {
			public void apply(String value0, Boolean value1) {
				if (value0.equals("String") && value1)
					active.add(true);
			}
		};

		for (int i = 0; i < total; i++) {
			signal.add(listener);
		}

		signal.dispatch("String", true);

		Assert.assertEquals("Number of signals dispatched should equal total", 10, active.size());
	}
}
