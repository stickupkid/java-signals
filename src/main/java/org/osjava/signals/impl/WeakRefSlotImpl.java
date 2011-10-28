package org.osjava.signals.impl;

import java.lang.ref.WeakReference;

import org.osjava.signals.Signal;
import org.osjava.signals.SignalListener;
import org.osjava.signals.WeakRefSlot;

public final class WeakRefSlotImpl<L extends SignalListener> extends SlotImpl<L> implements
		WeakRefSlot<L> {

	private WeakReference<L> _reference;

	private final boolean _weakRef;

	public WeakRefSlotImpl(Signal<L> signal, L listener, boolean once, boolean weakRef) {
		super(signal, once);

		_weakRef = weakRef;

		setListener(listener);
	}

	/**
	 * {@inheritDoc}
	 */
	public L getListener() {
		L listener;
		if (_weakRef)
			listener = (null != _reference) ? _reference.get() : null;
		else
			listener = super.getListener();
		return listener;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setListener(L value) {
		if (_weakRef) {
			if (null != _reference) {
				_reference.clear();
			}
			_reference = new WeakReference<L>(value);
		} else
			super.setListener(value);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean getWeakRef() {
		return _weakRef;
	}
}
