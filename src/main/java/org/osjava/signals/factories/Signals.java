package org.osjava.signals.factories;

import org.osjava.signals.impl.SignalImpl0;
import org.osjava.signals.impl.SignalImpl1;
import org.osjava.signals.impl.SignalImpl2;

/**
 * Created by IntelliJ IDEA. User: simonrichardson Date: 15/09/2011
 */
public class Signals {

	public static SignalImpl0 createSignal0() {
		return new SignalImpl0();
	}

	public static <A> SignalImpl1<A> createSignal1() {
		return new SignalImpl1<A>();
	}

	public static <A, B> SignalImpl2<A, B> createSignal2() {
		return new SignalImpl2<A, B>();
	}
}
