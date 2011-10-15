package org.osjava.signals.impl;

import org.osjava.signals.Signal0;

/**
 * Created by IntelliJ IDEA. User: simonrichardson Date: 15/09/2011
 */
public class SignalImpl0 extends
		SignalImpl<SlotImpl<Signal0.SignalListener0>, Signal0.SignalListener0> implements
		Signal0<SlotImpl<SlotImpl, Signal0.SignalListener0>, Signal0.SignalListener0> {

	/**
	 * {@inheritDoc}
	 */
	public void dispatch() {
		dispatcher.dispatch();
	}
}
