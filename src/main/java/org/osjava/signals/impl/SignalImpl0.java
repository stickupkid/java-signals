package org.osjava.signals.impl;

import java.util.Iterator;

import org.osjava.signals.Signal0;
import org.osjava.signals.Slot;

/**
 * Created by IntelliJ IDEA. User: simonrichardson Date: 15/09/2011
 */
public class SignalImpl0 implements Signal0 {

	private final SignalImpl<SignalListener0> signal = SignalImpl.newInstance();

	/**
	 * Private constructor
	 */
	private SignalImpl0() {

	}

	/**
	 * Create a newInstance of Signal0
	 * 
	 * @return {@link Signal0}
	 */
	public static Signal0 newInstance() {
		return new SignalImpl0();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Slot<SignalListener0> add(SignalListener0 listener) {
		return signal.add(listener);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Slot<SignalListener0> addOnce(SignalListener0 listener) {
		return signal.addOnce(listener);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Slot<SignalListener0> remove(SignalListener0 listener) {
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
	public void dispatch() {
		Iterator<Slot<SignalListener0>> iterator = signal.getIterator();
		while (iterator.hasNext()) {
			Slot<SignalListener0> slot = iterator.next();
			SignalListener0 listener = slot.getListener();
			if (listener != null && slot.getEnabled()) {
				if (slot.getOnce())
					slot.remove();
				if (listener != null)
					listener.apply();
			}
		}
	}
}
