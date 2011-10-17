package org.osjava.signals.impl;

import java.util.Iterator;

import org.osjava.signals.Signal1;
import org.osjava.signals.Slot;

/**
 * Created by IntelliJ IDEA. User: cereals Date: 16/09/2011
 */
public class SignalImpl1<A> implements Signal1<A> {

	private final SignalImpl<SignalListener1<A>> signal = SignalImpl.newInstance();

	/**
	 * Private constructor
	 */
	private SignalImpl1() {

	}

	/**
	 * Create a newInstance of Signal1
	 * 
	 * @return {@link Signal1}
	 */
	public static <A> Signal1<A> newInstance() {
		return new SignalImpl1<A>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Slot<SignalListener1<A>> add(SignalListener1<A> listener) {
		return signal.add(listener);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Slot<SignalListener1<A>> addOnce(SignalListener1<A> listener) {
		return signal.addOnce(listener);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Slot<SignalListener1<A>> remove(SignalListener1<A> listener) {
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
	public void dispatch(A value0) {
		Iterator<Slot<SignalListener1<A>>> iterator = signal.getIterator();
		while (iterator.hasNext()) {
			Slot<SignalListener1<A>> slot = iterator.next();
			SignalListener1<A> listener = (SignalListener1<A>) slot.getListener();
			if (listener != null && slot.getEnabled()) {
				if (slot.getOnce())
					slot.remove();
				if (listener != null)
					listener.apply(value0);
			}
		}
	}
}
