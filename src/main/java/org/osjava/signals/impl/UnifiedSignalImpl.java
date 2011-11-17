package org.osjava.signals.impl;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.osjava.signals.Dispatcher;
import org.osjava.signals.PrioritySignal;
import org.osjava.signals.SelectiveSignal;
import org.osjava.signals.SignalListener;
import org.osjava.signals.SignalListener.SignalListener0;
import org.osjava.signals.SignalListener.SignalListener1;
import org.osjava.signals.SignalListener.SignalListener2;
import org.osjava.signals.SignalListener.SignalListener3;
import org.osjava.signals.SignalListener.SignalListener4;
import org.osjava.signals.SignalListener.SignalListener5;
import org.osjava.signals.Slot;
import org.osjava.signals.UnifiedSignal;

public class UnifiedSignalImpl<T, L extends SignalListener> extends SignalImpl<L> implements
		UnifiedSignal<T, L> {

	protected PrioritySignal<L> prioritySignalImpl;

	protected SelectiveSignal<T, L> selectiveSignalImpl;

	public UnifiedSignalImpl(List<Slot<L>> bindings) {
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
	 * @throws IllegalArgumentException
	 *             if bindings argument is null
	 */
	public static <T, L extends SignalListener> UnifiedSignalImpl<T, L> newInstance(
			List<Slot<L>> bindings) {
		if (null == bindings)
			throw new IllegalArgumentException("Bindings can not be null");

		return new UnifiedSignalImpl<T, L>(bindings);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws IllegalArgumentException
	 *             if listener argument is null
	 */
	@Override
	public Slot<L> add(L listener) {
		if (null == listener)
			throw new IllegalArgumentException("Listener can not be null");

		return prioritySignalImpl.add(listener);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws IllegalArgumentException
	 *             if listener argument is null
	 */
	@Override
	public Slot<L> addOnce(L listener) {
		if (null == listener)
			throw new IllegalArgumentException("Listener can not be null");

		return prioritySignalImpl.addOnce(listener);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws IllegalArgumentException
	 *             if listener argument is null
	 */
	public Slot<L> addWithPriority(L listener, int priority) {
		if (null == listener)
			throw new IllegalArgumentException("Listener can not be null");

		return prioritySignalImpl.addWithPriority(listener, priority);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws IllegalArgumentException
	 *             if listener argument is null
	 */
	public Slot<L> addOnceWithPriority(L listener, int priority) {
		if (null == listener)
			throw new IllegalArgumentException("Listener can not be null");

		return prioritySignalImpl.addOnceWithPriority(listener, priority);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Slot<L> addFor(T key, L listener) {
		if (null == listener)
			throw new IllegalArgumentException("Listener can not be null");

		return selectiveSignalImpl.addFor(key, listener);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Slot<L> addOnceFor(T key, L listener) {
		if (null == listener)
			throw new IllegalArgumentException("Listener can not be null");

		return selectiveSignalImpl.addOnceFor(key, listener);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SelectiveSignalComparator<T> getComparator() {
		return selectiveSignalImpl.getComparator();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setComparator(SelectiveSignalComparator<T> comparator) {
		if (null == comparator)
			throw new AssertionError("Comparator can not be null");

		selectiveSignalImpl.setComparator(comparator);
	}

	public static class UnifiedSignalImpl0<T> implements UnifiedSignal0<T> {

		private final List<Slot<SignalListener0>> _bindings = new CopyOnWriteArrayList<Slot<SignalListener0>>();

		private final Dispatcher<SignalListener0> _dispatcher = DispatcherImpl
				.newInstance(_bindings);

		private final UnifiedSignalImpl<T, SignalListener0> _signal = new UnifiedSignalImpl<T, SignalListener0>(
				_bindings);
		{
			_signal.prioritySignalImpl = new PrioritySignalImpl<SignalListener0>(_bindings);
			_signal.selectiveSignalImpl = new SelectiveSignalImpl<T, SignalListener0>(_bindings);
		}

		private UnifiedSignalImpl0() {
		}

		/**
		 * Create a newInstance of UnifiedSignal0
		 * 
		 * @return {@link UnifiedSignal0}
		 */
		public static <T> UnifiedSignalImpl0<T> newInstance() {
			return new UnifiedSignalImpl0<T>();
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
		public Slot<SignalListener0> addWithPriority(SignalListener0 listener, int priority) {
			return _signal.addWithPriority(listener, priority);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException
		 *             if listener argument is null
		 */
		@Override
		public Slot<SignalListener0> addOnceWithPriority(SignalListener0 listener, int priority) {
			return _signal.addOnceWithPriority(listener, priority);
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
		 */
		@Override
		public SelectiveSignalComparator<T> getComparator() {
			return _signal.getComparator();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException
		 *             if listener argument is null
		 */
		@Override
		public void setComparator(SelectiveSignalComparator<T> comparator) {
			_signal.setComparator(comparator);
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

	public static class UnifiedSignalImpl1<T, A> implements UnifiedSignal1<T, A> {

		private final List<Slot<SignalListener1<A>>> _bindings = new CopyOnWriteArrayList<Slot<SignalListener1<A>>>();

		private final Dispatcher<SignalListener1<A>> _dispatcher = DispatcherImpl
				.newInstance(_bindings);

		private final UnifiedSignalImpl<T, SignalListener1<A>> _signal = new UnifiedSignalImpl<T, SignalListener1<A>>(
				_bindings);
		{
			// Add two different signal implementations, they both should play
			// together.
			_signal.prioritySignalImpl = new PrioritySignalImpl<SignalListener1<A>>(_bindings);
			_signal.selectiveSignalImpl = new SelectiveSignalImpl<T, SignalListener1<A>>(_bindings);
		}

		private UnifiedSignalImpl1() {
		}

		/**
		 * Create a newInstance of UnifiedSignal0
		 * 
		 * @return {@link UnifiedSignal0}
		 */
		public static <T, A> UnifiedSignalImpl1<T, A> newInstance() {
			return new UnifiedSignalImpl1<T, A>();
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
		public Slot<SignalListener1<A>> addWithPriority(SignalListener1<A> listener, int priority) {
			return _signal.addWithPriority(listener, priority);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException
		 *             if listener argument is null
		 */
		@Override
		public Slot<SignalListener1<A>> addOnceWithPriority(SignalListener1<A> listener,
				int priority) {
			return _signal.addOnceWithPriority(listener, priority);
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
		 */
		@Override
		public SelectiveSignalComparator<T> getComparator() {
			return _signal.getComparator();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException
		 *             if listener argument is null
		 */
		@Override
		public void setComparator(SelectiveSignalComparator<T> comparator) {
			_signal.setComparator(comparator);
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

	public static class UnifiedSignalImpl2<T, A, B> implements UnifiedSignal2<T, A, B> {

		private final List<Slot<SignalListener2<A, B>>> _bindings = new CopyOnWriteArrayList<Slot<SignalListener2<A, B>>>();

		private final Dispatcher<SignalListener2<A, B>> _dispatcher = DispatcherImpl
				.newInstance(_bindings);

		private final UnifiedSignalImpl<T, SignalListener2<A, B>> _signal = new UnifiedSignalImpl<T, SignalListener2<A, B>>(
				_bindings);
		{
			// Add two different signal implementations, they both should play
			// together.
			_signal.prioritySignalImpl = new PrioritySignalImpl<SignalListener2<A, B>>(_bindings);
			_signal.selectiveSignalImpl = new SelectiveSignalImpl<T, SignalListener2<A, B>>(
					_bindings);
		}

		private UnifiedSignalImpl2() {
		}

		/**
		 * Create a newInstance of UnifiedSignal0
		 * 
		 * @return {@link UnifiedSignal0}
		 */
		public static <T, A, B> UnifiedSignalImpl2<T, A, B> newInstance() {
			return new UnifiedSignalImpl2<T, A, B>();
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
		public Slot<SignalListener2<A, B>> addWithPriority(SignalListener2<A, B> listener,
				int priority) {
			return _signal.addWithPriority(listener, priority);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException
		 *             if listener argument is null
		 */
		@Override
		public Slot<SignalListener2<A, B>> addOnceWithPriority(SignalListener2<A, B> listener,
				int priority) {
			return _signal.addOnceWithPriority(listener, priority);
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
		 */
		@Override
		public SelectiveSignalComparator<T> getComparator() {
			return _signal.getComparator();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException
		 *             if listener argument is null
		 */
		@Override
		public void setComparator(SelectiveSignalComparator<T> comparator) {
			_signal.setComparator(comparator);
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

	public static class UnifiedSignalImpl3<T, A, B, C> implements UnifiedSignal3<T, A, B, C> {

		private final List<Slot<SignalListener3<A, B, C>>> _bindings = new CopyOnWriteArrayList<Slot<SignalListener3<A, B, C>>>();

		private final Dispatcher<SignalListener3<A, B, C>> _dispatcher = DispatcherImpl
				.newInstance(_bindings);

		private final UnifiedSignalImpl<T, SignalListener3<A, B, C>> _signal = new UnifiedSignalImpl<T, SignalListener3<A, B, C>>(
				_bindings);
		{
			// Add two different signal implementations, they both should play
			// together.
			_signal.prioritySignalImpl = new PrioritySignalImpl<SignalListener3<A, B, C>>(_bindings);
			_signal.selectiveSignalImpl = new SelectiveSignalImpl<T, SignalListener3<A, B, C>>(
					_bindings);
		}

		private UnifiedSignalImpl3() {
		}

		/**
		 * Create a newInstance of UnifiedSignal0
		 * 
		 * @return {@link UnifiedSignal0}
		 */
		public static <T, A, B, C> UnifiedSignalImpl3<T, A, B, C> newInstance() {
			return new UnifiedSignalImpl3<T, A, B, C>();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException
		 *             if listener argument is null
		 */
		@Override
		public Slot<SignalListener3<A, B, C>> add(SignalListener3<A, B, C> listener) {
			return _signal.add(listener);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException
		 *             if listener argument is null
		 */
		@Override
		public Slot<SignalListener3<A, B, C>> addOnce(SignalListener3<A, B, C> listener) {
			return _signal.addOnce(listener);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException
		 *             if listener argument is null
		 */
		@Override
		public Slot<SignalListener3<A, B, C>> addWithPriority(SignalListener3<A, B, C> listener,
				int priority) {
			return _signal.addWithPriority(listener, priority);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException
		 *             if listener argument is null
		 */
		@Override
		public Slot<SignalListener3<A, B, C>> addOnceWithPriority(
				SignalListener3<A, B, C> listener, int priority) {
			return _signal.addOnceWithPriority(listener, priority);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException
		 *             if listener argument is null
		 */
		@Override
		public Slot<SignalListener3<A, B, C>> addFor(T key, SignalListener3<A, B, C> listener) {
			return _signal.addFor(key, listener);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException
		 *             if listener argument is null
		 */
		@Override
		public Slot<SignalListener3<A, B, C>> addOnceFor(T key, SignalListener3<A, B, C> listener) {
			return _signal.addOnceFor(key, listener);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public SelectiveSignalComparator<T> getComparator() {
			return _signal.getComparator();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException
		 *             if listener argument is null
		 */
		@Override
		public void setComparator(SelectiveSignalComparator<T> comparator) {
			_signal.setComparator(comparator);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException
		 *             if listener argument is null
		 */
		@Override
		public Slot<SignalListener3<A, B, C>> remove(SignalListener3<A, B, C> listener) {
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
		@Override
		public void dispatch(A value0, B value1, C value2) throws Throwable {
			_dispatcher.dispatch(value0, value1, value2);
		}
	}

	public static class UnifiedSignalImpl4<T, A, B, C, D> implements UnifiedSignal4<T, A, B, C, D> {

		private final List<Slot<SignalListener4<A, B, C, D>>> _bindings = new CopyOnWriteArrayList<Slot<SignalListener4<A, B, C, D>>>();

		private final Dispatcher<SignalListener4<A, B, C, D>> _dispatcher = DispatcherImpl
				.newInstance(_bindings);

		private final UnifiedSignalImpl<T, SignalListener4<A, B, C, D>> _signal = new UnifiedSignalImpl<T, SignalListener4<A, B, C, D>>(
				_bindings);
		{
			// Add two different signal implementations, they both should play
			// together.
			_signal.prioritySignalImpl = new PrioritySignalImpl<SignalListener4<A, B, C, D>>(
					_bindings);
			_signal.selectiveSignalImpl = new SelectiveSignalImpl<T, SignalListener4<A, B, C, D>>(
					_bindings);
		}

		private UnifiedSignalImpl4() {
		}

		/**
		 * Create a newInstance of UnifiedSignal0
		 * 
		 * @return {@link UnifiedSignal0}
		 */
		public static <T, A, B, C, D> UnifiedSignalImpl4<T, A, B, C, D> newInstance() {
			return new UnifiedSignalImpl4<T, A, B, C, D>();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException
		 *             if listener argument is null
		 */
		@Override
		public Slot<SignalListener4<A, B, C, D>> add(SignalListener4<A, B, C, D> listener) {
			return _signal.add(listener);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException
		 *             if listener argument is null
		 */
		@Override
		public Slot<SignalListener4<A, B, C, D>> addOnce(SignalListener4<A, B, C, D> listener) {
			return _signal.addOnce(listener);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException
		 *             if listener argument is null
		 */
		@Override
		public Slot<SignalListener4<A, B, C, D>> addWithPriority(
				SignalListener4<A, B, C, D> listener, int priority) {
			return _signal.addWithPriority(listener, priority);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException
		 *             if listener argument is null
		 */
		@Override
		public Slot<SignalListener4<A, B, C, D>> addOnceWithPriority(
				SignalListener4<A, B, C, D> listener, int priority) {
			return _signal.addOnceWithPriority(listener, priority);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException
		 *             if listener argument is null
		 */
		@Override
		public Slot<SignalListener4<A, B, C, D>> addFor(T key, SignalListener4<A, B, C, D> listener) {
			return _signal.addFor(key, listener);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException
		 *             if listener argument is null
		 */
		@Override
		public Slot<SignalListener4<A, B, C, D>> addOnceFor(T key,
				SignalListener4<A, B, C, D> listener) {
			return _signal.addOnceFor(key, listener);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public SelectiveSignalComparator<T> getComparator() {
			return _signal.getComparator();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException
		 *             if listener argument is null
		 */
		@Override
		public void setComparator(SelectiveSignalComparator<T> comparator) {
			_signal.setComparator(comparator);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException
		 *             if listener argument is null
		 */
		@Override
		public Slot<SignalListener4<A, B, C, D>> remove(SignalListener4<A, B, C, D> listener) {
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
		@Override
		public void dispatch(A value0, B value1, C value2, D value3) throws Throwable {
			_dispatcher.dispatch(value0, value1, value2, value3);
		}
	}

	public static class UnifiedSignalImpl5<T, A, B, C, D, E> implements
			UnifiedSignal5<T, A, B, C, D, E> {

		private final List<Slot<SignalListener5<A, B, C, D, E>>> _bindings = new CopyOnWriteArrayList<Slot<SignalListener5<A, B, C, D, E>>>();

		private final Dispatcher<SignalListener5<A, B, C, D, E>> _dispatcher = DispatcherImpl
				.newInstance(_bindings);

		private final UnifiedSignalImpl<T, SignalListener5<A, B, C, D, E>> _signal = new UnifiedSignalImpl<T, SignalListener5<A, B, C, D, E>>(
				_bindings);
		{
			// Add two different signal implementations, they both should play
			// together.
			_signal.prioritySignalImpl = new PrioritySignalImpl<SignalListener5<A, B, C, D, E>>(
					_bindings);
			_signal.selectiveSignalImpl = new SelectiveSignalImpl<T, SignalListener5<A, B, C, D, E>>(
					_bindings);
		}

		private UnifiedSignalImpl5() {
		}

		/**
		 * Create a newInstance of UnifiedSignal0
		 * 
		 * @return {@link UnifiedSignal0}
		 */
		public static <T, A, B, C, D, E> UnifiedSignalImpl5<T, A, B, C, D, E> newInstance() {
			return new UnifiedSignalImpl5<T, A, B, C, D, E>();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException
		 *             if listener argument is null
		 */
		@Override
		public Slot<SignalListener5<A, B, C, D, E>> add(SignalListener5<A, B, C, D, E> listener) {
			return _signal.add(listener);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException
		 *             if listener argument is null
		 */
		@Override
		public Slot<SignalListener5<A, B, C, D, E>> addOnce(SignalListener5<A, B, C, D, E> listener) {
			return _signal.addOnce(listener);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException
		 *             if listener argument is null
		 */
		@Override
		public Slot<SignalListener5<A, B, C, D, E>> addWithPriority(
				SignalListener5<A, B, C, D, E> listener, int priority) {
			return _signal.addWithPriority(listener, priority);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException
		 *             if listener argument is null
		 */
		@Override
		public Slot<SignalListener5<A, B, C, D, E>> addOnceWithPriority(
				SignalListener5<A, B, C, D, E> listener, int priority) {
			return _signal.addOnceWithPriority(listener, priority);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException
		 *             if listener argument is null
		 */
		@Override
		public Slot<SignalListener5<A, B, C, D, E>> addFor(T key,
				SignalListener5<A, B, C, D, E> listener) {
			return _signal.addFor(key, listener);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException
		 *             if listener argument is null
		 */
		@Override
		public Slot<SignalListener5<A, B, C, D, E>> addOnceFor(T key,
				SignalListener5<A, B, C, D, E> listener) {
			return _signal.addOnceFor(key, listener);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public SelectiveSignalComparator<T> getComparator() {
			return _signal.getComparator();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException
		 *             if listener argument is null
		 */
		@Override
		public void setComparator(SelectiveSignalComparator<T> comparator) {
			_signal.setComparator(comparator);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException
		 *             if listener argument is null
		 */
		@Override
		public Slot<SignalListener5<A, B, C, D, E>> remove(SignalListener5<A, B, C, D, E> listener) {
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
		@Override
		public void dispatch(A value0, B value1, C value2, D value3, E value4) throws Throwable {
			_dispatcher.dispatch(value0, value1, value2, value3, value4);
		}
	}
}
