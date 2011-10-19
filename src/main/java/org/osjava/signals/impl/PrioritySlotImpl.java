package org.osjava.signals.impl;

import org.osjava.signals.PrioritySlot;
import org.osjava.signals.Signal;
import org.osjava.signals.Signal.SignalListener;

public class PrioritySlotImpl<L extends SignalListener> extends SlotImpl<L> implements
		PrioritySlot<L> {

	private int _priority;

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
