package org.osjava.signals.impl;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.osjava.signals.Dispatcher;
import org.osjava.signals.Signal0;
import org.osjava.signals.Slot;

/**
 * Created by IntelliJ IDEA. User: simonrichardson Date: 15/09/2011
 */
public class SignalImpl0 implements Signal0 {
	
	private final List<Slot<SignalListener0>> _bindings = new CopyOnWriteArrayList<Slot<SignalListener0>>();
	
	private final Dispatcher<SignalListener0> _dispatcher = DispatcherImpl.newInstance(_bindings);
	
	private final SignalImpl<SignalListener0> _signal = SignalImpl.newInstance(_bindings);

	private SignalImpl0() {
		// Private constructor
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
		return _signal.add(listener);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Slot<SignalListener0> addOnce(SignalListener0 listener) {
		return _signal.addOnce(listener);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Slot<SignalListener0> remove(SignalListener0 listener) {
		return _signal.remove(listener);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeAll() {
		_signal.removeAll();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getNumListeners() {
		return _signal.getNumListeners();
	}

	/**
	 * {@inheritDoc}
	 */
	public void dispatch() {
		_dispatcher.dispatch();
	}
}
