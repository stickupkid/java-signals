package org.osjava.signals.impl;

import org.osjava.signals.Signal;
import org.osjava.signals.SignalListener;
import org.osjava.signals.Slot;

/**
 * Created by IntelliJ IDEA. User: simonrichardson Date: 15/09/2011
 */
public class SlotImpl<L extends SignalListener> implements Slot<L> {

	private final Signal<L> _signal;

	private L _listener;

	private boolean _once;

	private boolean _enabled;
	
	public SlotImpl(Signal<L> signal, boolean once) {
		_signal = signal;
		_enabled = true;
		_once = once;
	}
	
	public SlotImpl(Signal<L> signal, L listener, boolean once) {
		_signal = signal;
		_enabled = true;
		_once = once;
		
		setListener(listener);
	}

	/**
	 * {@inheritDoc}
	 */
	public void remove() {
		_signal.remove(getListener());
	}

	/**
	 * {@inheritDoc}
	 */
	public L getListener() {
		return _listener;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setListener(L value) {
		assert null != value : "Listener can not be null";
		
		_listener = value;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean getOnce() {
		return _once;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setOnce(boolean value) {
		_once = value;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean getEnabled() {
		return _enabled;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setEnabled(boolean value) {
		_enabled = value;
	}
}
