package org.osjava.signals.impl;

import org.osjava.signals.Signal;
import org.osjava.signals.Signal.SignalListener;
import org.osjava.signals.Slot;

/**
 * Created by IntelliJ IDEA. User: simonrichardson Date: 15/09/2011
 */
public class SlotImpl<L extends SignalListener> implements Slot<L> {

	private final Signal<L> signal;

	private L listener;

	private boolean once;

	private boolean enabled;

	public SlotImpl(Signal<L> signal, L listener, boolean once) {
		this.signal = signal;
		this.enabled = true;

		setListener(listener);
		setOnce(once);
	}

	/**
	 * {@inheritDoc}
	 */
	public void remove() {
		signal.remove(getListener());
	}

	/**
	 * {@inheritDoc}
	 */
	public L getListener() {
		return listener;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setListener(L value) {
		listener = value;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean getOnce() {
		return once;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setOnce(boolean value) {
		once = value;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean getEnabled() {
		return enabled;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setEnabled(boolean value) {
		enabled = value;
	}
}
