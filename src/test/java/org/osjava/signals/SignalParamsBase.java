package org.osjava.signals;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class SignalParamsBase {

	protected void compareLists(List<?> a, List<?> b) {
		assertTrue("Arrays not the same length", a.size() == b.size());
		for (int i = 0; i < a.size(); i++) {
			assertEquals(a.get(i), b.get(i));
		}
	}

	protected void compareObjects(Object[] a, Object[] b) {
		assertTrue("Arrays not the same length", a.length == b.length);
		for (int i = 0; i < a.length; i++) {
			assertEquals(a[i], b[i]);
		}
	}
}
