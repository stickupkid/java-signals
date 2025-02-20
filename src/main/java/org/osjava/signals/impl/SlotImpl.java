package org.osjava.signals.impl;

import java.util.List;

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
	
	private List<?> _params;
	
	public SlotImpl(Signal<L> signal, boolean once) {
		_signal = signal;
		_enabled = true;
		_once = once;
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

	/**
	 * {@inheritDoc}
	 */
	public Slot<L> callWith(List<?> params) {
		_params = params;
		return this;
	}
	
	/**
	 * 
	 */
	public List<?> getParams() {
		return _params;
	}
}
