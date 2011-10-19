package org.osjava.signals.impl;

import java.util.List;

import org.osjava.signals.Signal.SignalListener;
import org.osjava.signals.Slot;

public class MonoSignalImpl<L extends SignalListener> extends SignalImpl<L> {

	public MonoSignalImpl(List<Slot<L>> bindings) {
		super(bindings);
	}

	/**
	 * Create a new instance of the SignalImplementation.
	 * 
	 * @param <T>
	 *            Type of slot required useful for bindings.
	 * @param <L>
	 *            The listener which will be called and will be associated with
	 *            the binding.
	 * @return A new instance of Signal
	 */
	public static <L extends SignalListener> MonoSignalImpl<L> newInstance(List<Slot<L>> bindings) {
		return new MonoSignalImpl<L>(bindings);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean registrationPossible(L listener, boolean once) {
		if (getNumListeners() > 0) {
			throw new IllegalArgumentException(
					"You cannot add or addOnce with a listener already added, remove the current listener first.");
		}
		return true;
	}
}
