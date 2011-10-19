package org.osjava.signals.impl;

import java.util.List;

import org.osjava.signals.PrioritySignal;
import org.osjava.signals.PrioritySlot;
import org.osjava.signals.Signal.SignalListener;
import org.osjava.signals.Slot;

public class PrioritySignalImpl<L extends SignalListener> extends SignalImpl<L> implements
		PrioritySignal<L> {

	public PrioritySignalImpl(List<Slot<L>> bindings) {
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
	public static <L extends SignalListener> PrioritySignalImpl<L> newInstance(
			List<Slot<L>> bindings) {
		return new PrioritySignalImpl<L>(bindings);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Slot<L> addWithPriority(L listener, int priority) {
		return registerListener(listener, false, priority);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Slot<L> addOnceWithPriority(L listener, int priority) {
		return registerListener(listener, true, priority);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @param listener
	 *            which is the type of SignalListenerType
	 * @param once
	 *            if the listener should just be called once
	 * @param priority
	 *            priority at which to add the signal at
	 * @return a SlotType, which contains the Function passed as the parameter
	 */
	@SuppressWarnings("unchecked")
	protected Slot<L> registerListener(L listener, boolean once, int priority) {
		Slot<L> slot = null;
		if (registrationPossible(listener, once)) {
			slot = new PrioritySlotImpl<L>(this, listener, once, priority);
			if (slot != null) {
				// Make sure that bindings is synchronised
				synchronized (bindings) {
					final int total = bindings.size();
					if (total == 0)
						bindings.add(slot);
					else {
						for (int i = 0; i < total; i++) {
							Slot<L> s = bindings.get(i);
							if (s instanceof PrioritySlot) {
								PrioritySlot<L> prioritySlot = (PrioritySlot<L>) s;
								if (priority > prioritySlot.getPriority()) {
									bindings.add(i, slot);
									break;
								}
							} else {
								bindings.add(i, slot);
								break;
							}
						}
					}
				}
			}
		} else {
			slot = findSlotByListener(listener);
		}
		return slot;
	}

}
