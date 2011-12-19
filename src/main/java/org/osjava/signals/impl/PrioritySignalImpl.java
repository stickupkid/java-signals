package org.osjava.signals.impl;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.osjava.signals.Dispatcher;
import org.osjava.signals.PrioritySignal;
import org.osjava.signals.PrioritySlot;
import org.osjava.signals.SignalListener;
import org.osjava.signals.SignalListener.SignalListener0;
import org.osjava.signals.SignalListener.SignalListener1;
import org.osjava.signals.SignalListener.SignalListener2;
import org.osjava.signals.SignalListener.SignalListener3;
import org.osjava.signals.SignalListener.SignalListener4;
import org.osjava.signals.SignalListener.SignalListener5;
import org.osjava.signals.Slot;

public final class PrioritySignalImpl<L extends SignalListener> extends SignalImpl<L> implements
		PrioritySignal<L> {

	private final static int DEFAULT_PRIORITY = -1;

	public PrioritySignalImpl(List<Slot<L>> bindings) {
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
	public static <L extends SignalListener> PrioritySignalImpl<L> newInstance(
			List<Slot<L>> bindings) {
		if (null == bindings)
			throw new IllegalArgumentException("Bindings can not be null");

		return new PrioritySignalImpl<L>(bindings);
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

		return registerListener(listener, false);
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

		return registerListener(listener, true);
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

		return registerListener(listener, false, priority);
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

		return registerListener(listener, true, priority);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws IllegalArgumentException
	 *             if listener argument is null
	 */
	@Override
	protected Slot<L> registerListener(L listener, boolean once) {
		assert null != listener : "Listener can not be null";

		return registerListener(listener, once, DEFAULT_PRIORITY);
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
	protected Slot<L> registerListener(L listener, boolean once, int priority) {
		assert null != listener : "Listener can not be null";

		Slot<L> slot = null;
		if (registrationPossible(listener, once)) {
			slot = new PrioritySlotImpl<L>(this, once, priority);
			slot.setListener(listener);

			// Make sure that bindings is synchronised
			synchronized (bindings) {
				final int total = bindings.size();
				if (total <= 0)
					bindings.add(slot);
				else {
					int index = 0;
					for (int i = 0; i < total; i++) {
						final Slot<L> bindingSlot = bindings.get(i);
						if (bindingSlot instanceof PrioritySlot) {
							final PrioritySlot<L> prioritySlot = (PrioritySlot<L>) bindingSlot;
							if (priority > prioritySlot.getPriority())
								break;
							else
								index++;
						} else
							index = total;
					}
					bindings.add(index, slot);
				}
			}

		} else {
			slot = findSlotByListener(listener);
		}
		return slot;
	}

	public static class PrioritySignalImpl0 implements PrioritySignal0 {

		private final List<Slot<SignalListener0>> _bindings =
				new CopyOnWriteArrayList<Slot<SignalListener0>>();

		private final Dispatcher<SignalListener0> _dispatcher = DispatcherImpl
				.newInstance(_bindings);

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

	public static class PrioritySignalImpl1<A> implements PrioritySignal1<A> {

		private final List<Slot<SignalListener1<A>>> _bindings =
				new CopyOnWriteArrayList<Slot<SignalListener1<A>>>();

		private final Dispatcher<SignalListener1<A>> _dispatcher = DispatcherImpl
				.newInstance(_bindings);

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
		public Slot<SignalListener1<A>> remove(SignalListener1<A> listener) {
			return _signal.remove(listener);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException
		 *             if listener argument is null
		 */
		@Override
		public void removeAll() {
			_signal.removeAll();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException
		 *             if listener argument is null
		 */
		@Override
		public int getNumListeners() {
			return _signal.getNumListeners();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException
		 *             if listener argument is null
		 */
		@Override
		public void dispatch(A value0) throws Throwable {
			_dispatcher.dispatch(value0);
		}
	}

	public static class PrioritySignalImpl2<A, B> implements PrioritySignal2<A, B> {

		private final List<Slot<SignalListener2<A, B>>> _bindings =
				new CopyOnWriteArrayList<Slot<SignalListener2<A, B>>>();

		private final Dispatcher<SignalListener2<A, B>> _dispatcher = DispatcherImpl
				.newInstance(_bindings);

		private final PrioritySignalImpl<SignalListener2<A, B>> _signal = PrioritySignalImpl
				.newInstance(_bindings);

		private PrioritySignalImpl2() {
			// Private constructor
		}

		/**
		 * Create a newInstance of PrioritySignal2
		 * 
		 * @return {@link PrioritySignal2}
		 */
		public static <A, B> PrioritySignalImpl2<A, B> newInstance() {
			return new PrioritySignalImpl2<A, B>();
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

	public static class PrioritySignalImpl3<A, B, C> implements PrioritySignal3<A, B, C> {

		private final List<Slot<SignalListener3<A, B, C>>> _bindings =
				new CopyOnWriteArrayList<Slot<SignalListener3<A, B, C>>>();

		private final Dispatcher<SignalListener3<A, B, C>> _dispatcher = DispatcherImpl
				.newInstance(_bindings);

		private final PrioritySignalImpl<SignalListener3<A, B, C>> _signal = PrioritySignalImpl
				.newInstance(_bindings);

		private PrioritySignalImpl3() {
			// Private constructor
		}

		/**
		 * Create a newInstance of PrioritySignal3
		 * 
		 * @return {@link PrioritySignal3}
		 */
		public static <A, B, C> PrioritySignalImpl3<A, B, C> newInstance() {
			return new PrioritySignalImpl3<A, B, C>();
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

	public static class PrioritySignalImpl4<A, B, C, D> implements PrioritySignal4<A, B, C, D> {

		private final List<Slot<SignalListener4<A, B, C, D>>> _bindings =
				new CopyOnWriteArrayList<Slot<SignalListener4<A, B, C, D>>>();

		private final Dispatcher<SignalListener4<A, B, C, D>> _dispatcher = DispatcherImpl
				.newInstance(_bindings);

		private final PrioritySignalImpl<SignalListener4<A, B, C, D>> _signal = PrioritySignalImpl
				.newInstance(_bindings);

		private PrioritySignalImpl4() {
			// Private constructor
		}

		/**
		 * Create a newInstance of PrioritySignal4
		 * 
		 * @return {@link PrioritySignal4}
		 */
		public static <A, B, C, D> PrioritySignalImpl4<A, B, C, D> newInstance() {
			return new PrioritySignalImpl4<A, B, C, D>();
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

	public static class PrioritySignalImpl5<A, B, C, D, E> implements
			PrioritySignal5<A, B, C, D, E> {

		private final List<Slot<SignalListener5<A, B, C, D, E>>> _bindings =
				new CopyOnWriteArrayList<Slot<SignalListener5<A, B, C, D, E>>>();

		private final Dispatcher<SignalListener5<A, B, C, D, E>> _dispatcher = DispatcherImpl
				.newInstance(_bindings);

		private final PrioritySignalImpl<SignalListener5<A, B, C, D, E>> _signal =
				PrioritySignalImpl.newInstance(_bindings);

		private PrioritySignalImpl5() {
			// Private constructor
		}

		/**
		 * Create a newInstance of PrioritySignal5
		 * 
		 * @return {@link PrioritySignal5}
		 */
		public static <A, B, C, D, E> PrioritySignalImpl5<A, B, C, D, E> newInstance() {
			return new PrioritySignalImpl5<A, B, C, D, E>();
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
		public Slot<SignalListener5<A, B, C, D, E>>
				addOnce(SignalListener5<A, B, C, D, E> listener) {
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
