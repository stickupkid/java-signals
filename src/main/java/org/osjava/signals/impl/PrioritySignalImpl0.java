package org.osjava.signals.impl;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.osjava.signals.Dispatcher;
import org.osjava.signals.PrioritySignal0;
import org.osjava.signals.Slot;

public class PrioritySignalImpl0 implements PrioritySignal0 {

	private final List<Slot<SignalListener0>> _bindings = new CopyOnWriteArrayList<Slot<SignalListener0>>();

	private final Dispatcher<SignalListener0> _dispatcher = DispatcherImpl.newInstance(_bindings);

	private final PrioritySignalImpl<SignalListener0> _signal = PrioritySignalImpl
			.newInstance(_bindings);

	private PrioritySignalImpl0() {
		// Private constructor
	}

	/**
	 * Create a newInstance of PrioritySignal0
	 * 
	 * @return {@link PrioritySignal0}
	 */
	public static PrioritySignalImpl0 newInstance() {
		return new PrioritySignalImpl0();
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
	public Slot<SignalListener0> addWithPriority(SignalListener0 listener, int priority) {
		return _signal.add(listener);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Slot<SignalListener0> addOnceWithPriority(SignalListener0 listener, int priority) {
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
