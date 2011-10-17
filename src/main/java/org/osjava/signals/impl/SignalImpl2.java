package org.osjava.signals.impl;

import java.util.Iterator;

import org.osjava.signals.Signal2;
import org.osjava.signals.Slot;

/**
 * Created by IntelliJ IDEA. User: cereals Date: 16/09/2011
 */
public class SignalImpl2<A, B> implements Signal2<A, B> {

	private final SignalImpl<SignalListener2<A, B>> signal = SignalImpl.newInstance();

	/**
	 * Private constructor
	 */
	private SignalImpl2() {

	}

	/**
	 * Create a newInstance of Signal2
	 * 
	 * @return {@link Signal2}
	 */
	public static <A, B> Signal2<A, B> newInstance() {
		return new SignalImpl2<A, B>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Slot<SignalListener2<A, B>> add(SignalListener2<A, B> listener) {
		return signal.add(listener);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Slot<SignalListener2<A, B>> add(SignalListener2<A, B> listener, boolean once) {
		return signal.add(listener, once);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Slot<SignalListener2<A, B>> remove(SignalListener2<A, B> listener) {
		return signal.remove(listener);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeAll() {
		signal.removeAll();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getNumListeners() {
		return signal.getNumListeners();
	}

	/**
	 * {@inheritDoc}
	 */
	public void dispatch(A value0, B value1) {
		Iterator<Slot<SignalListener2<A, B>>> iterator = signal.getIterator();
		while (iterator.hasNext()) {
			Slot<SignalListener2<A, B>> slot = iterator.next();
			SignalListener2<A, B> listener = slot.getListener();
			if (listener != null && slot.getEnabled()) {
				if (slot.getOnce())
					slot.remove();
				if (listener != null)
					listener.apply(value0, value1);
			}
		}
	}
}
