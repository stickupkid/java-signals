package org.osjava.signals.impl;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.osjava.signals.Dispatcher;
import org.osjava.signals.PrioritySignal1;
import org.osjava.signals.Slot;

public class PrioritySignalImpl1<A> implements PrioritySignal1<A> {

	private final List<Slot<SignalListener1<A>>> _bindings = new CopyOnWriteArrayList<Slot<SignalListener1<A>>>();

	private final Dispatcher<SignalListener1<A>> _dispatcher = DispatcherImpl.newInstance(_bindings);

	private final PrioritySignalImpl<SignalListener1<A>> _signal = PrioritySignalImpl
			.newInstance(_bindings);

	private PrioritySignalImpl1() {
		// Private constructor
	}

	/**
	 * Create a newInstance of PrioritySignal1
	 * 
	 * @return {@link PrioritySignal1}
	 */
	public static <A> PrioritySignalImpl1<A> newInstance() {
		return new PrioritySignalImpl1<A>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Slot<SignalListener1<A>> add(SignalListener1<A> listener) {
		return _signal.add(listener);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Slot<SignalListener1<A>> addOnce(SignalListener1<A> listener) {
		return _signal.addOnce(listener);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Slot<SignalListener1<A>> addWithPriority(SignalListener1<A> listener, int priority) {
		return _signal.add(listener);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Slot<SignalListener1<A>> addOnceWithPriority(SignalListener1<A> listener, int priority) {
		return _signal.addOnce(listener);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Slot<SignalListener1<A>> remove(SignalListener1<A> listener) {
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
	public void dispatch(A value0) {
		_dispatcher.dispatch(value0);
	}
}
