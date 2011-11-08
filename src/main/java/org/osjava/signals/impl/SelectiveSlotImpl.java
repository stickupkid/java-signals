package org.osjava.signals.impl;

import org.osjava.signals.SelectiveSlot;
import org.osjava.signals.Signal;
import org.osjava.signals.SignalListener;

public final class SelectiveSlotImpl<T, L extends SignalListener> extends SlotImpl<L> implements
		SelectiveSlot<T, L> {

	private final T _key;

	/**
	 * Priority slot implementation, which holds associated values in a common
	 * class.
	 * 
	 * @param signal
	 *            associated with the slot
	 * @param once
	 *            if the slot is only executed once before removal
	 * @param key
	 *            the key the signal is executed on
	 * 
	 */
	public SelectiveSlotImpl(Signal<L> signal, boolean once, T key) {
		super(signal, once);

		_key = key;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T getKey() {
		return _key;
	}

}
