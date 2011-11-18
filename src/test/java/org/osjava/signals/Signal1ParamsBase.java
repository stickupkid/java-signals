package org.osjava.signals;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.osjava.signals.Signal.Signal1;
import org.osjava.signals.SignalListener.SignalListener1;

public class Signal1ParamsBase extends SignalParamsBase {
	
	protected Signal1<String> signal;

	@After
	public void tearDown() {
		signal.removeAll();
	}

	@Test
	public void verify_callWith_does_not_throw_exception() {
		signal.add(new SignalListener1<String>() {
			@Override
			public void apply(String value0) {
			}
		}).callWith(Arrays.asList(42));
	}

	@Test
	public void verify_getParams_is_the_correct_length_after_callWith_is_called() {
		final List<Integer> list = Arrays.asList(42, 12, 24);

		Slot<SignalListener1<String>> slot = signal.add(new SignalListener1<String>() {
			@Override
			public void apply(String value0) {
			}
		}).callWith(list);

		compareLists(list, slot.getParams());
	}

	@Test
	public void verify_integer_method_is_called() throws Throwable {
		final List<Integer> list = Arrays.asList(42, 12, 24);
		final Object[] expected = {"Hello", list.get(0), list.get(1), list.get(2)};
		
		signal.add(new SignalListener1<String>() {
			@Override
			public void apply(String value0) {
				fail("Default SignalListener1.apply() should not be called as params are sent");
			}

			@SuppressWarnings("unused")
			public void calledWith(String a, Integer b, Integer c, Integer d) {
				final Object[] result = {a, b, c, d};
				compareObjects(expected, result);
			}
		}).callWith(list);

		signal.dispatch((String) expected[0]);
	}
	
	@Test
	public void verify_string_method_is_called() throws Throwable {
		final List<String> list = Arrays.asList("world", "!");
		final Object[] expected = {"Hello", list.get(0), list.get(1)};
		
		signal.add(new SignalListener1<String>() {
			@Override
			public void apply(String value0) {
				fail("Default SignalListener1.apply() should not be called as params are sent");
			}

			@SuppressWarnings("unused")
			public void calledWith(String a, String b, String c) {
				final Object[] result = {a, b, c};
				compareObjects(expected, result);
			}
		}).callWith(list);

		signal.dispatch((String) expected[0]);
	}
	
	@Test
	public void verify_method_is_called_when_there_are_two_listeners() throws Throwable {
		final List<String> list = Arrays.asList("world", "!");
		final Object[] expected = {"Hello", list.get(0), list.get(1)};
		
		signal.add(new SignalListener1<String>() {
			@Override
			public void apply(String value0) {
				fail("Default SignalListener1.apply() should not be called as params are sent");
			}

			@SuppressWarnings("unused")
			public void calledWith(String a, String b, String c) {
				final Object[] result = {a, b, c};
				compareObjects(expected, result);
			}
		}).callWith(list);

		signal.add(new SignalListener1<String>() {
			@Override
			public void apply(String value1) {
				assertTrue(true);
			}
		});
		
		signal.dispatch((String) expected[0]);
	}
}
