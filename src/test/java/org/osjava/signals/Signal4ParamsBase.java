package org.osjava.signals;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.osjava.signals.Signal.Signal4;
import org.osjava.signals.SignalListener.SignalListener4;

public class Signal4ParamsBase extends SignalParamsBase {
	
	protected Signal4<String, String, String, String> signal;

	@After
	public void tearDown() {
		signal.removeAll();
	}

	@Test
	public void verify_callWith_does_not_throw_exception() {
		signal.add(new SignalListener4<String, String, String, String>() {
			@Override
			public void apply(String value0, String value1, String value2, String value3) {
			}
		}).callWith(Arrays.asList(44));
	}

	@Test
	public void verify_getParams_is_the_correct_length_after_callWith_is_called() {
		final List<Integer> list = Arrays.asList(44, 14, 44);

		Slot<SignalListener4<String, String, String, String>> slot = signal.add(
				new SignalListener4<String, String, String, String>() {
					@Override
					public void apply(String value0, String value1, String value2, String value3) {
					}
				}).callWith(list);

		compareLists(list, slot.getParams());
	}

	@Test
	public void verify_integer_method_is_called() throws Throwable {
		final List<Integer> list = Arrays.asList(44, 14, 44);
		final Object[] expected = { "Hello", "World", "!", "?", list.get(0), list.get(1),
				list.get(2) };

		signal.add(new SignalListener4<String, String, String, String>() {
			@Override
			public void apply(String value0, String value1, String value2, String value3) {
				fail("Default SignalListener1.apply() should not be called as params are sent");
			}

			@SuppressWarnings("unused")
			public void calledWith(String value0, String value1, String value2, String value3,
					Integer a, Integer b, Integer c) {
				final Object[] result = { value0, value1, value2, value3, a, b, c };
				compareObjects(expected, result);
			}
		}).callWith(list);

		signal.dispatch((String) expected[0], (String) expected[1], (String) expected[2],
				(String) expected[3]);
	}

	@Test
	public void verify_string_method_is_called() throws Throwable {
		final List<String> list = Arrays.asList("world", "!");
		final Object[] expected = { "Hello", "World", "!", "?", list.get(0), list.get(1) };

		signal.add(new SignalListener4<String, String, String, String>() {
			@Override
			public void apply(String value0, String value1, String value2, String value3) {
				fail("Default SignalListener1.apply() should not be called as params are sent");
			}

			@SuppressWarnings("unused")
			public void calledWith(String value0, String value1, String value2, String value3,
					String a, String b) {
				final Object[] result = { value0, value1, value2, value3, a, b };
				compareObjects(expected, result);
			}
		}).callWith(list);

		signal.dispatch((String) expected[0], (String) expected[1], (String) expected[2],
				(String) expected[3]);
	}	
	
	@Test
	public void verify_method_is_called_when_there_are_two_listeners() throws Throwable {
		final List<String> list = Arrays.asList("world", "!");
		final Object[] expected = { "Hello", "World", "!", "?", list.get(0), list.get(1) };

		signal.add(new SignalListener4<String, String, String, String>() {
			@Override
			public void apply(String value0, String value1, String value2, String value3) {
				fail("Default SignalListener1.apply() should not be called as params are sent");
			}

			@SuppressWarnings("unused")
			public void calledWith(String value0, String value1, String value2, String value3,
					String a, String b) {
				final Object[] result = { value0, value1, value2, value3, a, b };
				compareObjects(expected, result);
			}
		}).callWith(list);
		
		signal.add(new SignalListener4<String, String, String, String>() {
			@Override
			public void apply(String value0, String value1, String value2, String value3) {
				assertTrue(true);
			}
		});

		signal.dispatch((String) expected[0], (String) expected[1], (String) expected[2],
				(String) expected[3]);
	}
}
