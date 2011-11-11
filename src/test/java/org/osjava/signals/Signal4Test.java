package org.osjava.signals;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.osjava.signals.Signal.Signal4;
import org.osjava.signals.SignalListener.SignalListener4;
import org.osjava.signals.impl.SignalImpl.SignalImpl4;

/**
 * Created by IntelliJ IDEA. User: cereals Date: 16/09/4011
 */
public class Signal4Test {
	private Signal4<Boolean, String, String, String> signal;

	@Before
	public void setUp() {
		signal = SignalImpl4.newInstance();
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
		signal.add(new SignalListener4<Boolean, String, String, String>() {
			public void apply(Boolean value0, String value1, String value2, String value3) {
			}
		});

		Assert.assertEquals("Signal getNumListeners should equal one after add", 1,
				signal.getNumListeners());
	}

	@Test
	public void verify_that_add_makes_getNumListeners_equal_ten() {
		final int total = 10;

		final SignalListener4<Boolean, String, String, String> listener = new SignalListener4<Boolean, String, String, String>() {
			public void apply(Boolean value0, String value1, String value2, String value3) {
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
		signal.addOnce(new SignalListener4<Boolean, String, String, String>() {
			public void apply(Boolean value0, String value1, String value2, String value3) {
			}
		});

		Assert.assertEquals("Signal getNumListeners should equal one after add once", 1,
				signal.getNumListeners());
	}

	@Test
	public void verify_that_add_once_makes_getNumListeners_equal_ten() {
		final int total = 10;

		final SignalListener4<Boolean, String, String, String> listener = new SignalListener4<Boolean, String, String, String>() {
			public void apply(Boolean value0, String value1, String value2, String value3) {
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
		signal.add(new SignalListener4<Boolean, String, String, String>() {
			public void apply(Boolean value0, String value1, String value2, String value3) {
			}
		});

		signal.dispatch(true, "Hello", "World", "!");

		Assert.assertEquals("Signal getNumListeners should equal one after add and then dispatch",
				1, signal.getNumListeners());
	}

	@Test
	public void verify_that_after_add_once_that_getNumListeners_equal_one_after_dispatch()
			throws Throwable {
		signal.addOnce(new SignalListener4<Boolean, String, String, String>() {
			public void apply(Boolean value0, String value1, String value2, String value3) {
			}
		});

		signal.dispatch(true, "Hello", "World", "!");

		Assert.assertEquals("Signal getNumListeners should equal one after add once and then "
				+ "dispatch", 0, signal.getNumListeners());
	}

	@Test
	public void verify_that_a_listener_is_called_after_dispatch() throws Throwable {
		signal.add(new SignalListener4<Boolean, String, String, String>() {
			public void apply(Boolean value0, String value1, String value2, String value3) {
				Assert.assertTrue("Signal0 apply was called when dispatched", true);
			}
		});

		signal.dispatch(true, "Hello", "World", "!");
	}

	@Test
	public void verify_that_multiple_listeners_are_called_after_dispatch() throws Throwable {
		final int total = 10;
		final ArrayList<Boolean> active = new ArrayList<Boolean>();

		final SignalListener4<Boolean, String, String, String> listener = new SignalListener4<Boolean, String, String, String>() {
			public void apply(Boolean value0, String value1, String value2, String value3) {
				if (value0 && value1.equals("Hello") && value2.equals("World")
						&& value3.equals("!"))
					active.add(true);
			}
		};

		for (int i = 0; i < total; i++) {
			signal.add(listener);
		}

		signal.dispatch(true, "Hello", "World", "!");

		Assert.assertEquals("Number of signals dispatched should equal total", 10, active.size());
	}
}
