package org.osjava.signals.impl;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.osjava.signals.Dispatcher;
import org.osjava.signals.SignalListener;
import org.osjava.signals.SignalListener.SignalListener0;
import org.osjava.signals.SignalListener.SignalListener1;
import org.osjava.signals.SignalListener.SignalListener2;
import org.osjava.signals.Slot;
import org.osjava.signals.WeakRefSignal;

public class WeakRefSignalImpl<L extends SignalListener> extends SignalImpl<L> implements
		WeakRefSignal<L> {

	private final static boolean DEFAULT_WEAK_REF = true;

	public WeakRefSignalImpl(List<Slot<L>> bindings) {
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
	public static <L extends SignalListener> WeakRefSignalImpl<L> newInstance(List<Slot<L>> bindings) {
		return new WeakRefSignalImpl<L>(bindings);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Slot<L> add(L listener) {
		assert null != listener : "Listener can not be null";

		return registerListener(listener, false);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Slot<L> addOnce(L listener) {
		assert null != listener : "Listener can not be null";

		return registerListener(listener, true);
	}

	/**
	 * {@inheritDoc}
	 */
	public Slot<L> addWithWeakRef(L listener, boolean weakRef) {
		assert null != listener : "Listener can not be null";

		return registerListener(listener, false, weakRef);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Slot<L> addOnceWithWeakRef(L listener, boolean weakRef) {
		assert null != listener : "Listener can not be null";

		return registerListener(listener, true, weakRef);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Slot<L> registerListener(L listener, boolean once) {
		assert null != listener : "Listener can not be null";

		return registerListener(listener, once, DEFAULT_WEAK_REF);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @param listener
	 *            which is the type of SignalListenerType
	 * @param once
	 *            if the listener should just be called once
	 * @param weakRef
	 *            weakRef to add a listener to the bindings in a weak way so
	 *            that it can be gc'd
	 * @return a SlotType, which contains the Function passed as the parameter
	 */
	protected Slot<L> registerListener(L listener, boolean once, boolean weakRef) {
		assert null != listener : "Listener can not be null";

		Slot<L> slot = null;
		if (registrationPossible(listener, once)) {
			bindings.add(slot = new WeakRefSlotImpl<L>(this, listener, once, weakRef));
		} else {
			slot = findSlotByListener(listener);
		}
		return slot;
	}

	public static class WeakRefSignalImpl0 implements WeakRefSignal0 {

		private final List<Slot<SignalListener0>> _bindings = new CopyOnWriteArrayList<Slot<SignalListener0>>();

		private final Dispatcher<SignalListener0> _dispatcher = DispatcherImpl
				.newInstance(_bindings);

		private final WeakRefSignalImpl<SignalListener0> _signal = WeakRefSignalImpl
				.newInstance(_bindings);

		private WeakRefSignalImpl0() {
			// Private constructor
		}

		/**
		 * Create a newInstance of WeakRefSignal0
		 * 
		 * @return {@link WeakRefSignal0}
		 */
		public static WeakRefSignalImpl0 newInstance() {
			return new WeakRefSignalImpl0();
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
		public Slot<SignalListener0> addWithWeakRef(SignalListener0 listener, boolean weakRef) {
			return _signal.addWithWeakRef(listener, weakRef);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Slot<SignalListener0> addOnceWithWeakRef(SignalListener0 listener, boolean weakRef) {
			return _signal.addOnceWithWeakRef(listener, weakRef);
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
		public boolean dispatch() {
			return _dispatcher.dispatch();
		}
	}

	public static class WeakRefSignalImpl1<A> implements WeakRefSignal1<A> {

		private final List<Slot<SignalListener1<A>>> _bindings = new CopyOnWriteArrayList<Slot<SignalListener1<A>>>();

		private final Dispatcher<SignalListener1<A>> _dispatcher = DispatcherImpl
				.newInstance(_bindings);

		private final WeakRefSignalImpl<SignalListener1<A>> _signal = WeakRefSignalImpl
				.newInstance(_bindings);

		private WeakRefSignalImpl1() {
			// Private constructor
		}

		/**
		 * Create a newInstance of WeakRefSignal1
		 * 
		 * @return {@link WeakRefSignal1}
		 */
		public static <A> WeakRefSignalImpl1<A> newInstance() {
			return new WeakRefSignalImpl1<A>();
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
		public Slot<SignalListener1<A>> addWithWeakRef(SignalListener1<A> listener, boolean weakRef) {
			return _signal.addWithWeakRef(listener, weakRef);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Slot<SignalListener1<A>> addOnceWithWeakRef(SignalListener1<A> listener,
				boolean weakRef) {
			return _signal.addOnceWithWeakRef(listener, weakRef);
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
			try {
				_dispatcher.dispatch(value0);
			} catch (IllegalAccessException e) {
				// TODO : We should do something here
			}
		}
	}

	public static class WeakRefSignalImpl2<A, B> implements WeakRefSignal2<A, B> {

		private final List<Slot<SignalListener2<A, B>>> _bindings = new CopyOnWriteArrayList<Slot<SignalListener2<A, B>>>();

		private final Dispatcher<SignalListener2<A, B>> _dispatcher = DispatcherImpl
				.newInstance(_bindings);

		private final WeakRefSignalImpl<SignalListener2<A, B>> _signal = WeakRefSignalImpl
				.newInstance(_bindings);

		private WeakRefSignalImpl2() {
			// Private constructor
		}

		/**
		 * Create a newInstance of WeakRefSignal2
		 * 
		 * @return {@link WeakRefSignal2}
		 */
		public static <A, B> WeakRefSignalImpl2<A, B> newInstance() {
			return new WeakRefSignalImpl2<A, B>();
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
		public Slot<SignalListener2<A, B>> addWithWeakRef(SignalListener2<A, B> listener,
				boolean weakRef) {
			return _signal.addWithWeakRef(listener, weakRef);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Slot<SignalListener2<A, B>> addOnceWithWeakRef(SignalListener2<A, B> listener,
				boolean weakRef) {
			return _signal.addOnceWithWeakRef(listener, weakRef);
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
			try {
				_dispatcher.dispatch(value0, value1);
			} catch (IllegalAccessException e) {
				// TODO : We should do something here
			}
		}
	}
}
