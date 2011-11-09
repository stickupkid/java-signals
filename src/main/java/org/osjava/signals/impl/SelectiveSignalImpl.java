package org.osjava.signals.impl;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.osjava.signals.SelectiveDispatcher;
import org.osjava.signals.SelectiveSignal;
import org.osjava.signals.SignalListener;
import org.osjava.signals.SignalListener.SignalListener0;
import org.osjava.signals.SignalListener.SignalListener1;
import org.osjava.signals.SignalListener.SignalListener2;
import org.osjava.signals.Slot;

public class SelectiveSignalImpl<T, L extends SignalListener> extends SignalImpl<L> implements
		SelectiveSignal<T, L> {

	public SelectiveSignalImpl(List<Slot<L>> bindings) {
		super(bindings);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Slot<L> addFor(T key, L listener) {
		if (null == listener)
			throw new IllegalArgumentException("Listener can not be null");

		return registerListener(listener, false, key);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Slot<L> addOnceFor(T key, L listener) {
		if (null == listener)
			throw new IllegalArgumentException("Listener can not be null");

		return registerListener(listener, true, key);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SelectiveSignalComparator<T> getComparator() {
		throw new AbstractMethodError();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setComparator(SelectiveSignalComparator<T> comparator) {
		throw new AbstractMethodError();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @param listener
	 *            which is the type of SignalListenerType
	 * @param once
	 *            if the listener should just be called once
	 * @param priority
	 *            priority at which to add the signal at
	 * @return a SlotType, which contains the Function passed as the parameter
	 * @throws AssertionError
	 *             if listener argument is null
	 */
	protected Slot<L> registerListener(L listener, boolean once, T key) {
		assert null != listener : "Listener can not be null";

		Slot<L> slot = null;
		if (registrationPossible(listener, once)) {
			slot = new SelectiveSlotImpl<T, L>(this, once, key);
			slot.setListener(listener);

			bindings.add(slot);
		} else {
			slot = findSlotByListener(listener);
		}
		return slot;
	}

	public static class SelectiveSignalImpl0<T> implements SelectiveSignal0<T> {

		private final List<Slot<SignalListener0>> _bindings = new CopyOnWriteArrayList<Slot<SignalListener0>>();

		private final SelectiveDispatcher<T, SignalListener0> _dispatcher = new SelectiveDispatcherImpl<T, SignalListener0>(
				_bindings);

		private final SelectiveSignalImpl<T, SignalListener0> _signal = new SelectiveSignalImpl<T, SignalListener0>(
				_bindings);

		private SelectiveSignalImpl0() {
			// Private constructor
		}

		/**
		 * Create a newInstance of SelectiveSignal0
		 * 
		 * @return {@link SelectiveSignal0}
		 */
		public static <T> SelectiveSignalImpl0<T> newInstance() {
			return new SelectiveSignalImpl0<T>();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException
		 *             if listener argument is null
		 */
		@Override
		public Slot<SignalListener0> add(SignalListener0 listener) {
			return _signal.add(listener);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException
		 *             if listener argument is null
		 */
		@Override
		public Slot<SignalListener0> addOnce(SignalListener0 listener) {
			return _signal.addOnce(listener);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException
		 *             if listener argument is null
		 */
		@Override
		public Slot<SignalListener0> addFor(T key, SignalListener0 listener) {
			return _signal.addFor(key, listener);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException
		 *             if listener argument is null
		 */
		@Override
		public Slot<SignalListener0> addOnceFor(T key, SignalListener0 listener) {
			return _signal.addOnceFor(key, listener);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException
		 *             if listener argument is null
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
		public SelectiveSignalComparator<T> getComparator() {
			return _dispatcher.getComparator();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void setComparator(SelectiveSignalComparator<T> comparator) {
			if (null == comparator)
				throw new AssertionError("Comparator can not be null");
			
			_dispatcher.setComparator(comparator);
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
		@Override
		public void dispatch() throws Throwable {
			_dispatcher.dispatch();
		}
	}
	
	public static class SelectiveSignalImpl1<T, A> implements SelectiveSignal1<T, A> {

		private final List<Slot<SignalListener1<A>>> _bindings = new CopyOnWriteArrayList<Slot<SignalListener1<A>>>();

		private final SelectiveDispatcher<T, SignalListener1<A>> _dispatcher = new SelectiveDispatcherImpl<T, SignalListener1<A>>(
				_bindings);

		private final SelectiveSignalImpl<T, SignalListener1<A>> _signal = new SelectiveSignalImpl<T, SignalListener1<A>>(
				_bindings);

		private SelectiveSignalImpl1() {
			// Private constructor
		}

		/**
		 * Create a newInstance of SelectiveSignal1
		 * 
		 * @return {@link SelectiveSignal1}
		 */
		public static <T, A> SelectiveSignalImpl1<T, A> newInstance() {
			return new SelectiveSignalImpl1<T, A>();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException
		 *             if listener argument is null
		 */
		@Override
		public Slot<SignalListener1<A>> add(SignalListener1<A> listener) {
			return _signal.add(listener);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException
		 *             if listener argument is null
		 */
		@Override
		public Slot<SignalListener1<A>> addOnce(SignalListener1<A> listener) {
			return _signal.addOnce(listener);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException
		 *             if listener argument is null
		 */
		@Override
		public Slot<SignalListener1<A>> addFor(T key, SignalListener1<A> listener) {
			return _signal.addFor(key, listener);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException
		 *             if listener argument is null
		 */
		@Override
		public Slot<SignalListener1<A>> addOnceFor(T key, SignalListener1<A> listener) {
			return _signal.addOnceFor(key, listener);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException
		 *             if listener argument is null
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
		public SelectiveSignalComparator<T> getComparator() {
			return _dispatcher.getComparator();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void setComparator(SelectiveSignalComparator<T> comparator) {
			if (null == comparator)
				throw new AssertionError("Comparator can not be null");
			
			_dispatcher.setComparator(comparator);
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
		@Override
		public void dispatch(A value0) throws Throwable {
			_dispatcher.dispatch(value0);
		}
	}
	
	public static class SelectiveSignalImpl2<T, A, B> implements SelectiveSignal2<T, A, B> {

		private final List<Slot<SignalListener2<A, B>>> _bindings = new CopyOnWriteArrayList<Slot<SignalListener2<A, B>>>();

		private final SelectiveDispatcher<T, SignalListener2<A, B>> _dispatcher = new SelectiveDispatcherImpl<T, SignalListener2<A, B>>(
				_bindings);

		private final SelectiveSignalImpl<T, SignalListener2<A, B>> _signal = new SelectiveSignalImpl<T, SignalListener2<A, B>>(
				_bindings);

		private SelectiveSignalImpl2() {
			// Private constructor
		}

		/**
		 * Create a newInstance of SelectiveSignal1
		 * 
		 * @return {@link SelectiveSignal1}
		 */
		public static <T, A, B> SelectiveSignalImpl2<T, A, B> newInstance() {
			return new SelectiveSignalImpl2<T, A, B>();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException
		 *             if listener argument is null
		 */
		@Override
		public Slot<SignalListener2<A, B>> add(SignalListener2<A, B> listener) {
			return _signal.add(listener);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException
		 *             if listener argument is null
		 */
		@Override
		public Slot<SignalListener2<A, B>> addOnce(SignalListener2<A, B> listener) {
			return _signal.addOnce(listener);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException
		 *             if listener argument is null
		 */
		@Override
		public Slot<SignalListener2<A, B>> addFor(T key, SignalListener2<A, B> listener) {
			return _signal.addFor(key, listener);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException
		 *             if listener argument is null
		 */
		@Override
		public Slot<SignalListener2<A, B>> addOnceFor(T key, SignalListener2<A, B> listener) {
			return _signal.addOnceFor(key, listener);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException
		 *             if listener argument is null
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
		public SelectiveSignalComparator<T> getComparator() {
			return _dispatcher.getComparator();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void setComparator(SelectiveSignalComparator<T> comparator) {
			if (null == comparator)
				throw new AssertionError("Comparator can not be null");
			
			_dispatcher.setComparator(comparator);
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
		@Override
		public void dispatch(A value0, B value1) throws Throwable {
			_dispatcher.dispatch(value0, value1);
		}
	}
}
