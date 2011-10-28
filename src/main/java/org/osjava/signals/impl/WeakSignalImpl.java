package org.osjava.signals.impl;

import java.util.List;

import org.osjava.signals.SignalListener;
import org.osjava.signals.Slot;
import org.osjava.signals.WeakRefSignal;

public class WeakSignalImpl<L extends SignalListener> extends SignalImpl<L> implements
		WeakRefSignal<L> {

	private final static boolean DEFAULT_WEAK_REF = true;

	public WeakSignalImpl(List<Slot<L>> bindings) {
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
	public static <L extends SignalListener> WeakSignalImpl<L> newInstance(List<Slot<L>> bindings) {
		return new WeakSignalImpl<L>(bindings);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Slot<L> add(L listener) {
		assert null != listener : "Listener can not be null";

		return registerListener(listener, false);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Slot<L> addOnce(L listener) {
		assert null != listener : "Listener can not be null";

		return registerListener(listener, true);
	}

	/**
	 * {@inheritDoc}
	 */
	public Slot<L> addWithWeakRef(L listener, boolean weakRef) {
		assert null != listener : "Listener can not be null";

		return registerListener(listener, false, weakRef);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Slot<L> addOnceWithWeakRef(L listener, boolean weakRef) {
		assert null != listener : "Listener can not be null";

		return registerListener(listener, true, weakRef);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Slot<L> registerListener(L listener, boolean once) {
		assert null != listener : "Listener can not be null";

		return registerListener(listener, once, DEFAULT_WEAK_REF);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @param listener
	 *            which is the type of SignalListenerType
	 * @param once
	 *            if the listener should just be called once
	 * @param weakRef
	 *            weakRef to add a listener to the bindings in a weak way so
	 *            that it can be gc'd
	 * @return a SlotType, which contains the Function passed as the parameter
	 */
	protected Slot<L> registerListener(L listener, boolean once, boolean weakRef) {
		assert null != listener : "Listener can not be null";

		Slot<L> slot = null;
		if (registrationPossible(listener, once)) {
			bindings.add(slot = new WeakRefSlotImpl<L>(this, listener, once, weakRef));
		} else {
			slot = findSlotByListener(listener);
		}
		return slot;
	}
}
