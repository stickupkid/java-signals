package org.osjava.signals;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.osjava.signals.Signal.Signal0;
import org.osjava.signals.SignalListener.SignalListener0;
import org.osjava.signals.impl.SignalImpl.SignalImpl0;

public class Signal0ParamsTest {

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
	public void verify_callWith_does_not_throw_exception() {
		signal.add(new SignalListener0() {
			@Override
			public void apply() {
			}
		}).callWith(Arrays.asList(42));
	}

	@Test
	public void verify_getParams_is_the_correct_length_after_callWith_is_called() {
		final List<Integer> list = Arrays.asList(42, 12, 24);

		Slot<SignalListener0> slot = signal.add(new SignalListener0() {
			@Override
			public void apply() {
			}
		}).callWith(list);

		compare(list, slot.getParams());
	}

	@Test
	public void verify_integer_method_is_called() throws Throwable {
		final List<Integer> list = Arrays.asList(42, 12, 24);

		signal.add(new SignalListener0() {
			@Override
			public void apply() {
				Assert.fail("Default SignalListener0.apply() should not be called as params are sent");
			}

			@SuppressWarnings("unused")
			public void callWith(Integer a, Integer b, Integer c) {
				compare(list, Arrays.asList(a, b, c));
			}
		}).callWith(list);

		signal.dispatch();
	}

	@Test
	public void verify_string_method_is_called() throws Throwable {
		final List<String> list = Arrays.asList("a", "b", "c", "d");

		signal.add(new SignalListener0() {
			@Override
			public void apply() {
				Assert.fail("Default SignalListener0.apply() should not be called as params are sent");
			}

			@SuppressWarnings("unused")
			public void callWith(String a, String b, String c, String d) {
				compare(list, Arrays.asList(a, b, c, d));
			}
		}).callWith(list);

		signal.dispatch();
	}
	
	@Test
	public void verify_method_is_called_when_there_are_two_listeners() throws Throwable {
		final List<Integer> list = Arrays.asList(32, 3);

		signal.add(new SignalListener0() {
			@Override
			public void apply() {
				Assert.fail("Default SignalListener0.apply() should not be called as params are sent");
			}

			@SuppressWarnings("unused")
			public void callWith(Integer a, Integer b) {
				compare(list, Arrays.asList(a, b));
			}
		}).callWith(list);

		signal.add(new SignalListener0() {
			@Override
			public void apply() {
				Assert.assertTrue(true);
			}
		});

		signal.dispatch();
	}

	private void compare(List<?> a, List<?> b) {
		Assert.assertTrue("Arrays not the same length", a.size() == b.size());
		for (int i = 0; i < a.size(); i++) {
			Assert.assertEquals(a.get(i), b.get(i));
		}
	}
}
