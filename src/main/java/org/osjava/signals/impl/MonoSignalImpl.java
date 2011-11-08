package org.osjava.signals.impl;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.osjava.signals.Dispatcher;
import org.osjava.signals.SignalListener;
import org.osjava.signals.SignalListener.SignalListener0;
import org.osjava.signals.SignalListener.SignalListener1;
import org.osjava.signals.SignalListener.SignalListener2;
import org.osjava.signals.Slot;

public final class MonoSignalImpl<L extends SignalListener> extends SignalImpl<L> {

	public MonoSignalImpl(List<Slot<L>> bindings) {
		super(bindings);
	}

	/**
	 * Create a new instance of the SignalImplementation.
	 * 
	 * @param <T>
	 *            Type of slot required useful for bindings.
	 * @param <L>
	 *            The listener which will be called and will be associated with
	 *            the binding.
	 * @return A new instance of Signal
	 */
	public static <L extends SignalListener> MonoSignalImpl<L> newInstance(List<Slot<L>> bindings) {
		return new MonoSignalImpl<L>(bindings);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean registrationPossible(L listener, boolean once) {
		assert null != listener : "Listener can not be null";
		
		if (getNumListeners() > 0) {
			throw new IllegalArgumentException(
					"You cannot add or addOnce with a listener already added,"
							+ " remove the current listener first.");
		}
		return true;
	}

	public static class MonoSignalImpl0 implements Signal0 {

		private final List<Slot<SignalListener0>> _bindings = new CopyOnWriteArrayList<Slot<SignalListener0>>();

		private final Dispatcher<SignalListener0> _dispatcher = DispatcherImpl
				.newInstance(_bindings);

		private final MonoSignalImpl<SignalListener0> _signal = MonoSignalImpl
				.newInstance(_bindings);

		private MonoSignalImpl0() {
			// Private constructor
		}

		/**
		 * Create a newInstance of MonoSignal0
		 * 
		 * @return {@link Signal0}
		 */
		public static Signal0 newInstance() {
			return new MonoSignalImpl0();
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
		public void dispatch() throws Throwable {
			_dispatcher.dispatch();
		}
	}

	public static class MonoSignalImpl1<A> implements Signal1<A> {

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
		public void dispatch(A value0) throws Throwable {
			_dispatcher.dispatch(value0);
		}
	}

	public static class MonoSignalImpl2<A, B> implements Signal2<A, B> {

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
		public void dispatch(A value0, B value1) throws Throwable {
			_dispatcher.dispatch(value0, value1);
		}
	}
}
