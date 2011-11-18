package org.osjava.signals;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.osjava.signals.Signal.Signal0;
import org.osjava.signals.SignalListener.SignalListener0;

public class Signal0ParamsBase extends SignalParamsBase {

	protected Signal0 signal;

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

		compareLists(list, slot.getParams());
	}

	@Test
	public void verify_integer_method_is_called() throws Throwable {
		final List<Integer> list = Arrays.asList(42, 12, 24);

		signal.add(new SignalListener0() {
			@Override
			public void apply() {
				fail("Default SignalListener0.apply() should not be called as params are sent");
			}

			@SuppressWarnings("unused")
			public void calledWith(Integer a, Integer b, Integer c) {
				compareLists(list, Arrays.asList(a, b, c));
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
				fail("Default SignalListener0.apply() should not be called as params are sent");
			}

			@SuppressWarnings("unused")
			public void calledWith(String a, String b, String c, String d) {
				compareLists(list, Arrays.asList(a, b, c, d));
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
				fail("Default SignalListener0.apply() should not be called as params are sent");
			}

			@SuppressWarnings("unused")
			public void calledWith(Integer a, Integer b) {
				compareLists(list, Arrays.asList(a, b));
			}
		}).callWith(list);

		signal.add(new SignalListener0() {
			@Override
			public void apply() {
				assertTrue(true);
			}
		});

		signal.dispatch();
	}
}
