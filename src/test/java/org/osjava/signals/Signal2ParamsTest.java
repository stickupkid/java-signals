package org.osjava.signals;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.osjava.signals.Signal.Signal2;
import org.osjava.signals.SignalListener.SignalListener2;
import org.osjava.signals.impl.SignalImpl.SignalImpl2;

public class Signal2ParamsTest {

	private Signal2<String, String> signal;

	@Before
	public void setUp() {
		signal = SignalImpl2.newInstance();
	}

	@After
	public void tearDown() {
		signal.removeAll();
	}

	@Test
	public void verify_callWith_does_not_throw_exception() {
		signal.add(new SignalListener2<String, String>() {
			@Override
			public void apply(String value0, String value1) {
			}
		}).callWith(Arrays.asList(42));
	}

	@Test
	public void verify_getParams_is_the_correct_length_after_callWith_is_called() {
		final List<Integer> list = Arrays.asList(42, 12, 24);

		Slot<SignalListener2<String, String>> slot =
				signal.add(new SignalListener2<String, String>() {
					@Override
					public void apply(String value0, String value1) {
					}
				}).callWith(list);

		compareLists(list, slot.getParams());
	}

	@Test
	public void verify_integer_method_is_called() throws Throwable {
		final List<Integer> list = Arrays.asList(42, 12, 24);
		final Object[] expected = { "Hello", "World", list.get(0), list.get(1), list.get(2) };

		signal.add(new SignalListener2<String, String>() {
			@Override
			public void apply(String value0, String value1) {
				Assert.fail("Default SignalListener1.apply() should not be called as params are sent");
			}

			@SuppressWarnings("unused")
			public void calledWith(String a, String b, Integer c, Integer d, Integer e) {
				final Object[] result = { a, b, c, d, e };
				compareObjects(expected, result);
			}
		}).callWith(list);

		signal.dispatch((String) expected[0], (String) expected[1]);
	}

	@Test
	public void verify_string_method_is_called() throws Throwable {
		final List<String> list = Arrays.asList("world", "!");
		final Object[] expected = { "Hello", "World", list.get(0), list.get(1) };

		signal.add(new SignalListener2<String, String>() {
			@Override
			public void apply(String value0, String value1) {
				Assert.fail("Default SignalListener1.apply() should not be called as params are sent");
			}

			@SuppressWarnings("unused")
			public void calledWith(String a, String b, String c, String d) {
				final Object[] result = { a, b, c, d };
				compareObjects(expected, result);
			}
		}).callWith(list);

		signal.dispatch((String) expected[0], (String) expected[1]);
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