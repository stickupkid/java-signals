package org.osjava.signals.impl;

import org.osjava.signals.PrioritySlot;
import org.osjava.signals.Signal;
import org.osjava.signals.SignalListener;

public final class PrioritySlotImpl<L extends SignalListener> extends SlotImpl<L> implements
		PrioritySlot<L> {
	
	private final int _priority;

	/**
	 * Priority slot implementation, which holds associated values in a common
	 * class.
	 * 
	 * @param signal
	 *            associated with the slot
	 * @param once
	 *            if the slot is only executed once before removal
	 * @param priority
	 *            at what priority the signal is executed
	 * 
	 */
	public PrioritySlotImpl(Signal<L> signal, boolean once, int priority) {
		super(signal, once);

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
