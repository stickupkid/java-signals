package org.osjava.signals.impl;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.osjava.signals.Dispatcher;
import org.osjava.signals.Signal2;
import org.osjava.signals.Slot;

public class MonoSignalImpl2<A, B> implements Signal2<A, B> {

	private final List<Slot<SignalListener2<A, B>>> _bindings = new CopyOnWriteArrayList<Slot<SignalListener2<A, B>>>();

	private final Dispatcher<SignalListener2<A, B>> _dispatcher = DispatcherImpl
			.newInstance(_bindings);

	private final MonoSignalImpl<SignalListener2<A, B>> _signal = MonoSignalImpl
			.newInstance(_bindings);

	/**
	 * Private constructor
	 */
	private MonoSignalImpl2() {

	}

	/**
	 * Create a newInstance of Signal2
	 * 
	 * @return {@link Signal2}
	 */
	public static <A, B> Signal2<A, B> newInstance() {
		return new MonoSignalImpl2<A, B>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Slot<SignalListener2<A, B>> add(SignalListener2<A, B> listener) {
		return _signal.add(listener);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Slot<SignalListener2<A, B>> addOnce(SignalListener2<A, B> listener) {
		return _signal.addOnce(listener);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Slot<SignalListener2<A, B>> remove(SignalListener2<A, B> listener) {
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
	public void dispatch(A value0, B value1) {
		_dispatcher.dispatch(value0, value1);
	}
}
