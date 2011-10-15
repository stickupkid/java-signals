package org.osjava.signals.impl;

import org.osjava.signals.Signal;
import org.osjava.signals.Slot;

/**
 * Created by IntelliJ IDEA. User: simonrichardson Date: 15/09/2011
 */
public class SlotImpl<SlotType extends Slot<Signal.SignalListener>, SignalListenerType extends Signal.SignalListener>
		implements Slot<SignalListenerType> {

	private final Signal<SlotType, SignalListenerType> signal;

	private SignalListenerType listener;

	private boolean once;

	private boolean enabled;

	public SlotImpl(Signal<SlotType, SignalListenerType> signal, SignalListenerType listener,
			boolean once) {
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
	public SignalListenerType getListener() {
		return listener;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setListener(SignalListenerType value) {
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
