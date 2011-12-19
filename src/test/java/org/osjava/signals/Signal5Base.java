package org.osjava.signals;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Test;
import org.osjava.signals.Signal.Signal5;
import org.osjava.signals.SignalListener.SignalListener5;

public class Signal5Base {
	protected Signal5<String, String, String, String, Boolean> signal;

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
		signal.add(new SignalListener5<String, String, String, String, Boolean>() {
			public void apply(String value0, String value1, String value2, String value3,
					Boolean value4) {
			}
		});

		Assert.assertEquals("Signal getNumListeners should equal one after add", 1,
				signal.getNumListeners());
	}

	@Test
	public void verify_that_add_makes_getNumListeners_equal_ten() {
		final int total = 10;

		for (int i = 0; i < total; i++) {
			final SignalListener5<String, String, String, String, Boolean> listener =
					new SignalListener5<String, String, String, String, Boolean>() {
						public void apply(String value0, String value1, String value2,
								String value3, Boolean value4) {
						}
					};

			signal.add(listener);
		}

		Assert.assertEquals("Signal getNumListeners should equal total after add", total,
				signal.getNumListeners());
	}

	@Test
	public void verify_that_add_once_makes_getNumListeners_equal_one() {
		signal.addOnce(new SignalListener5<String, String, String, String, Boolean>() {
			public void apply(String value0, String value1, String value2, String value3,
					Boolean value4) {
			}
		});

		Assert.assertEquals("Signal getNumListeners should equal one after add once", 1,
				signal.getNumListeners());
	}

	@Test
	public void verify_that_add_once_makes_getNumListeners_equal_ten() {
		final int total = 10;

		for (int i = 0; i < total; i++) {
			final SignalListener5<String, String, String, String, Boolean> listener =
					new SignalListener5<String, String, String, String, Boolean>() {
						public void apply(String value0, String value1, String value2,
								String value3, Boolean value5) {
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
		signal.add(new SignalListener5<String, String, String, String, Boolean>() {
			public void apply(String value0, String value1, String value2, String value3,
					Boolean value4) {
			}
		});

		signal.dispatch("Hello", "World", "!", "?", true);

		Assert.assertEquals("Signal getNumListeners should equal one after add and then dispatch",
				1, signal.getNumListeners());
	}

	@Test
	public void verify_that_after_add_once_that_getNumListeners_equal_one_after_dispatch()
			throws Throwable {
		signal.addOnce(new SignalListener5<String, String, String, String, Boolean>() {
			public void apply(String value0, String value1, String value2, String value3,
					Boolean value4) {
			}
		});

		signal.dispatch("Hello", "World", "!", "?", true);

		Assert.assertEquals("Signal getNumListeners should equal one after add once and then "
				+ "dispatch", 0, signal.getNumListeners());
	}

	@Test
	public void verify_that_a_listener_is_called_after_dispatch() throws Throwable {
		signal.add(new SignalListener5<String, String, String, String, Boolean>() {
			public void apply(String value0, String value1, String value2, String value3,
					Boolean value4) {
				Assert.assertTrue("Signal0 apply was called when dispatched", true);
			}
		});

		signal.dispatch("Hello", "World", "!", "?", true);
	}

	@Test
	public void verify_that_multiple_listeners_are_called_after_dispatch() throws Throwable {
		final int total = 10;
		final ArrayList<Boolean> active = new ArrayList<Boolean>();

		for (int i = 0; i < total; i++) {
			final SignalListener5<String, String, String, String, Boolean> listener =
					new SignalListener5<String, String, String, String, Boolean>() {
						public void apply(String value0, String value1, String value2,
								String value3, Boolean value4) {
							if (value0.equals("Hello") && value1.equals("World")
									&& value2.equals("!") && value3.equals("?") && value4)
								active.add(true);
						}
					};

			signal.add(listener);
		}

		signal.dispatch("Hello", "World", "!", "?", true);

		Assert.assertEquals("Number of signals dispatched should equal total", 10, active.size());
	}
}
