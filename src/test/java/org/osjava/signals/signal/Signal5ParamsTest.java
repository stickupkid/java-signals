package org.osjava.signals.signal;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.osjava.signals.Signal.Signal5;
import org.osjava.signals.SignalListener.SignalListener5;
import org.osjava.signals.Slot;
import org.osjava.signals.impl.SignalImpl.SignalImpl5;

public class Signal5ParamsTest {

	private Signal5<String, String, String, String, String> signal;

	@Before
	public void setUp() {
		signal = SignalImpl5.newInstance();
	}

	@After
	public void tearDown() {
		signal.removeAll();
	}

	@Test
	public void verify_callWith_does_not_throw_exception() {
		signal.add(new SignalListener5<String, String, String, String, String>() {
			@Override
			public void apply(String value0, String value1, String value2, String value3, String value4) {
			}
		}).callWith(Arrays.asList(55));
	}

	@Test
	public void verify_getParams_is_the_correct_length_after_callWith_is_called() {
		final List<Integer> list = Arrays.asList(55, 15, 55);

		Slot<SignalListener5<String, String, String, String, String>> slot = signal.add(
				new SignalListener5<String, String, String, String, String>() {
					@Override
					public void apply(String value0, String value1, String value2, String value3, String value4) {
					}
				}).callWith(list);

		compareLists(list, slot.getParams());
	}

	@Test
	public void verify_integer_method_is_called() throws Throwable {
		final List<Integer> list = Arrays.asList(55, 15, 55);
		final Object[] expected = { "Hello", "World", "!", "?", ".", list.get(0), list.get(1),
				list.get(2) };

		signal.add(new SignalListener5<String, String, String, String, String>() {
			@Override
			public void apply(String value0, String value1, String value2, String value3, String value4) {
				Assert.fail("Default SignalListener1.apply() should not be called as params are sent");
			}

			@SuppressWarnings("unused")
			public void calledWith(String value0, String value1, String value2, String value3, String value4,
					Integer a, Integer b, Integer c) {
				final Object[] result = { value0, value1, value2, value3, value4, a, b, c };
				compareObjects(expected, result);
			}
		}).callWith(list);

		signal.dispatch((String) expected[0], (String) expected[1], (String) expected[2],
				(String) expected[3], (String) expected[4]);
	}

	@Test
	public void verify_string_method_is_called() throws Throwable {
		final List<String> list = Arrays.asList("world", "!");
		final Object[] expected = { "Hello", "World", "!", "?", ".", list.get(0), list.get(1) };

		signal.add(new SignalListener5<String, String, String, String, String>() {
			@Override
			public void apply(String value0, String value1, String value2, String value3, String value4) {
				Assert.fail("Default SignalListener1.apply() should not be called as params are sent");
			}

			@SuppressWarnings("unused")
			public void calledWith(String value0, String value1, String value2, String value3, String value4,
					String a, String b) {
				final Object[] result = { value0, value1, value2, value3, value4, a, b };
				compareObjects(expected, result);
			}
		}).callWith(list);

		signal.dispatch((String) expected[0], (String) expected[1], (String) expected[2],
				(String) expected[3], (String) expected[4]);
	}

	private void compareLists(List<?> a, List<?> b) {
		Assert.assertTrue("Arrays not the same length", a.size() == b.size());
		for (int i = 0; i < a.size(); i++) {
			Assert.assertEquals(a.get(i), b.get(i));
		}
	}

	private void compareObjects(Object[] a, Object[] b) {
		Assert.assertTrue("Arrays not the same length", a.length == b.length);
		for (int i = 0; i < a.length; i++) {
			Assert.assertEquals(a[i], b[i]);
		}
	}

}
