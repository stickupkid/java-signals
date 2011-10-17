package org.osjava.signals.impl;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

import org.osjava.signals.Signal;
import org.osjava.signals.Signal.SignalListener;
import org.osjava.signals.Slot;

/**
 * Created by IntelliJ IDEA. User: simonrichardson Date: 15/09/2011
 */
public class SignalImpl<L extends SignalListener> implements Signal<L> {

	private final CopyOnWriteArrayList<Slot<L>> bindings = new CopyOnWriteArrayList<Slot<L>>();

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
	public static <L extends SignalListener> SignalImpl<L> newInstance() {
		return new SignalImpl<L>();
	}

	/**
	 * {@inheritDoc}
	 */
	public Slot<L> add(L listener) {
		return registerListener(listener, false);
	}

	/**
	 * {@inheritDoc}
	 */
	public Slot<L> addOnce(L listener) {
		return registerListener(listener, true);
	}

	/**
	 * {@inheritDoc}
	 */
	public Slot<L> remove(L listener) {
		final Slot<L> slot = findSlotByListener(listener);
		if (slot != null) {
			bindings.remove(slot);
			return slot;
		} else
			return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeAll() {
		bindings.clear();
	}

	/**
	 * {@inheritDoc}
	 */
	public int getNumListeners() {
		return bindings.size();
	}

	/**
	 * {@inheritDoc}
	 */
	public Iterator<Slot<L>> getIterator() {
		return bindings.listIterator();
	}

	/**
	 * Find the slot by the associated listener
	 * 
	 * @param listener
	 *            which is the type of SignalListenerType to look for
	 * @return a SlotType, which contains the Function passed as the parameter
	 */
	private Slot<L> findSlotByListener(L listener) {
		for (Slot<L> slot : bindings) {
			if (slot.equals(listener))
				return slot;
		}
		return null;
	}

	/**
	 * Register a listener
	 * 
	 * @param listener
	 *            which is the type of SignalListenerType
	 * @param once
	 *            if the listener should just be called once
	 * @return a SlotType, which contains the Function passed as the parameter
	 */
	private Slot<L> registerListener(L listener, boolean once) {
		Slot<L> slot = null;
		if (registrationPossible(listener, once)) {
			slot = new SlotImpl<L>(this, listener, once);
			if (slot != null)
				bindings.add(slot);
		} else {
			slot = findSlotByListener(listener);
		}
		return slot;
	}

	/**
	 * @param listener
	 *            which is the type of SignalListenerType
	 * @param once
	 *            if the listener should just be called once
	 * @return boolean if successful
	 * @throws IllegalArgumentException
	 *             if you try to re-add with a different add type
	 */
	private boolean registrationPossible(L listener, boolean once) {
		if (bindings.size() > 0)
			return true;
		else {
			final Slot<L> slot = findSlotByListener(listener);
			if (slot == null)
				return true;
			else {
				if (slot.getOnce() != once) {
					throw new IllegalArgumentException("You cannot addOnce() then add() the "
							+ "same listener without removing the relationship first.");
				}

				return false;
			}
		}
	}
}
