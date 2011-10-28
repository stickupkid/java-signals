package org.osjava.signals.impl;

import org.osjava.signals.PrioritySlot;
import org.osjava.signals.Signal;
import org.osjava.signals.SignalListener;

public final class PrioritySlotImpl<L extends SignalListener> extends SlotImpl<L> implements
		PrioritySlot<L> {

	private final int _priority;

	public PrioritySlotImpl(Signal<L> signal, boolean once, int priority) {
		super(signal, once);

		_priority = priority;
	}

	public PrioritySlotImpl(Signal<L> signal, L listener, boolean once, int priority) {
		super(signal, listener, once);

		_priority = priority;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getPriority() {
		return _priority;
	}
}
