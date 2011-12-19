package org.osjava.signals;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Test;
import org.osjava.signals.Signal.Signal1;
import org.osjava.signals.SignalListener.SignalListener1;

public class Signal1Base {

	protected Signal1<String> signal;

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
		signal.add(new SignalListener1<String>() {
			public void apply(String value) {
			}
		});

		Assert.assertEquals("Signal getNumListeners should equal one after add", 1,
				signal.getNumListeners());
	}

	@Test
	public void verify_that_add_makes_getNumListeners_equal_ten() {
		final int total = 10;

		for (int i = 0; i < total; i++) {
			final SignalListener1<String> listener = new SignalListener1<String>() {
				public void apply(String value) {
				}
			};

			signal.add(listener);
		}

		Assert.assertEquals("Signal getNumListeners should equal total after add", total,
				signal.getNumListeners());
	}

	@Test
	public void verify_that_add_once_makes_getNumListeners_equal_one() {
		signal.addOnce(new SignalListener1<String>() {
			public void apply(String value) {
			}
		});

		Assert.assertEquals("Signal getNumListeners should equal one after add once", 1,
				signal.getNumListeners());
	}

	@Test
	public void verify_that_add_once_makes_getNumListeners_equal_ten() {
		final int total = 10;

		for (int i = 0; i < total; i++) {
			final SignalListener1<String> listener = new SignalListener1<String>() {
				public void apply(String value) {
				}
			};

			signal.addOnce(listener);
		}

		Assert.assertEquals("Signal getNumListeners should equal total after add once", total,
				signal.getNumListeners());
	}

	@Test
	public void verify_that_after_add_that_getNumListeners_equal_one_after_dispatch()
			throws Throwable {
		signal.add(new SignalListener1<String>() {
			public void apply(String value) {
			}
		});

		signal.dispatch("Hello");

		Assert.assertEquals("Signal getNumListeners should equal one after add and then dispatch",
				1, signal.getNumListeners());
	}

	@Test
	public void verify_that_after_add_once_that_getNumListeners_equal_one_after_dispatch()
			throws Throwable {
		signal.addOnce(new SignalListener1<String>() {
			public void apply(String value) {
			}
		});

		signal.dispatch("Hello");

		Assert.assertEquals("Signal getNumListeners should equal one after add once and then "
				+ "dispatch", 0, signal.getNumListeners());
	}

	@Test
	public void verify_that_a_listener_is_called_after_dispatch() throws Throwable {
		signal.add(new SignalListener1<String>() {
			public void apply(String value) {
				Assert.assertTrue("Signal0 apply was called when dispatched", true);
			}
		});

		signal.dispatch("Hello");
	}

	@Test
	public void verify_that_multiple_listeners_are_called_after_dispatch() throws Throwable {
		final int total = 10;
		final ArrayList<String> active = new ArrayList<String>();

		final String expected = "Hello";

		for (int i = 0; i < total; i++) {
			final SignalListener1<String> listener = new SignalListener1<String>() {
				public void apply(String value) {
					if (expected.equals(value))
						active.add(value);
				}
			};

			signal.add(listener);
		}

		signal.dispatch(expected);

		Assert.assertEquals("Number of signals dispatched should equal total", 10, active.size());
	}
}
