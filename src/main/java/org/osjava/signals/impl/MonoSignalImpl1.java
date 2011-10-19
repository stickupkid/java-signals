package org.osjava.signals.impl;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.osjava.signals.Dispatcher;
import org.osjava.signals.Signal1;
import org.osjava.signals.Slot;

public class MonoSignalImpl1<A> implements Signal1<A> {

	private final List<Slot<SignalListener1<A>>> _bindings = new CopyOnWriteArrayList<Slot<SignalListener1<A>>>();

	private final Dispatcher<SignalListener1<A>> _dispatcher = DispatcherImpl
			.newInstance(_bindings);

	private final MonoSignalImpl<SignalListener1<A>> _signal = MonoSignalImpl
			.newInstance(_bindings);

	/**
	 * Private constructor
	 */
	private MonoSignalImpl1() {

	}

	/**
	 * Create a newInstance of MonoSignalImpl1
	 * 
	 * @return {@link Signal1}
	 */
	public static <A> Signal1<A> newInstance() {
		return new MonoSignalImpl1<A>();
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
