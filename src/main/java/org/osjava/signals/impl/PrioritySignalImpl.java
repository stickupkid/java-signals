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
	 * @throws IllegalArgumentException if bindings argument is null
	 */
	public static <L extends SignalListener> PrioritySignalImpl<L> newInstance(
			List<Slot<L>> bindings) {
		if(null == bindings) throw new IllegalArgumentException("Bindings can not be null");
		
		return new PrioritySignalImpl<L>(bindings);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws IllegalArgumentException if listener argument is null
	 */
	@Override
	public Slot<L> add(L listener) {
		if(null == listener) throw new IllegalArgumentException("Listener can not be null");
		
		return registerListener(listener, false);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws IllegalArgumentException if listener argument is null
	 */
	@Override
	public Slot<L> addOnce(L listener) {
		if(null == listener) throw new IllegalArgumentException("Listener can not be null");
		
		return registerListener(listener, true);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws IllegalArgumentException if listener argument is null
	 */
	public Slot<L> addWithPriority(L listener, int priority) {
		if(null == listener) throw new IllegalArgumentException("Listener can not be null");
		
		return registerListener(listener, false, priority);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws IllegalArgumentException if listener argument is null
	 */
	public Slot<L> addOnceWithPriority(L listener, int priority) {
		if(null == listener) throw new IllegalArgumentException("Listener can not be null");

		return registerListener(listener, true, priority);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws IllegalArgumentException if listener argument is null
	 */
	@Override
	protected Slot<L> registerListener(L listener, boolean once) {
		if(null == listener) throw new IllegalArgumentException("Listener can not be null");

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
	 * @throws AssertionError if listener argument is null
	 */
	protected Slot<L> registerListener(L listener, boolean once, int priority) {
		assert null != listener : "Listener can not be null";

		Slot<L> slot = null;
		if (registrationPossible(listener, once)) {
			slot = new PrioritySlotImpl<L>(this, listener, once, priority);

			// Make sure that bindings is synchronised
			synchronized (bindings) {
				final int total = bindings.size();
				if (total == 0)
					bindings.add(slot);
				else {
					for (int i = 0; i < total; i++) {
						Slot<L> s = bindings.get(i);
						if (s instanceof PrioritySlot) {
							PrioritySlot<L> prioritySlot = (PrioritySlot<L>) s;
							if (priority > prioritySlot.getPriority()) {
								bindings.add(i, slot);
								break;
							}
						} else {
							bindings.add(i, slot);
							break;
						}
					}
				}
			}

		} else {
			slot = findSlotByListener(listener);
		}
		return slot;
	}

	public static class PrioritySignalImpl0 implements PrioritySignal0 {

		private final List<Slot<SignalListener0>> _bindings = new CopyOnWriteArrayList<Slot<SignalListener0>>();

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
		 * @throws IllegalArgumentException if listener argument is null
		 */
		@Override
		public Slot<SignalListener0> add(SignalListener0 listener) {
			return _signal.add(listener);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException if listener argument is null
		 */
		@Override
		public Slot<SignalListener0> addOnce(SignalListener0 listener) {
			return _signal.addOnce(listener);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException if listener argument is null
		 */
		@Override
		public Slot<SignalListener0> addWithPriority(SignalListener0 listener, int priority) {
			return _signal.addWithPriority(listener, priority);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException if listener argument is null
		 */
		@Override
		public Slot<SignalListener0> addOnceWithPriority(SignalListener0 listener, int priority) {
			return _signal.addOnceWithPriority(listener, priority);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException if listener argument is null
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

	public static class PrioritySignalImpl1<A> implements PrioritySignal1<A> {

		private final List<Slot<SignalListener1<A>>> _bindings = new CopyOnWriteArrayList<Slot<SignalListener1<A>>>();

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
		 * @throws IllegalArgumentException if listener argument is null
		 */
		@Override
		public Slot<SignalListener1<A>> add(SignalListener1<A> listener) {
			return _signal.add(listener);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException if listener argument is null
		 */
		@Override
		public Slot<SignalListener1<A>> addOnce(SignalListener1<A> listener) {
			return _signal.addOnce(listener);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException if listener argument is null
		 */
		@Override
		public Slot<SignalListener1<A>> addWithPriority(SignalListener1<A> listener, int priority) {
			return _signal.addWithPriority(listener, priority);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException if listener argument is null
		 */
		@Override
		public Slot<SignalListener1<A>> addOnceWithPriority(SignalListener1<A> listener,
				int priority) {
			return _signal.addOnceWithPriority(listener, priority);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException if listener argument is null
		 */
		@Override
		public Slot<SignalListener1<A>> remove(SignalListener1<A> listener) {
			return _signal.remove(listener);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException if listener argument is null
		 */
		@Override
		public void removeAll() {
			_signal.removeAll();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException if listener argument is null
		 */
		@Override
		public int getNumListeners() {
			return _signal.getNumListeners();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException if listener argument is null
		 */
		public void dispatch(A value0) {
			try {
				_dispatcher.dispatch(value0);
			} catch (IllegalAccessException e) {
				// TODO : We should do something here
			}
		}
	}

	public static class PrioritySignalImpl2<A, B> implements PrioritySignal2<A, B> {

		private final List<Slot<SignalListener2<A, B>>> _bindings = new CopyOnWriteArrayList<Slot<SignalListener2<A, B>>>();

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
		 * @throws IllegalArgumentException if listener argument is null
		 */
		@Override
		public Slot<SignalListener2<A, B>> add(SignalListener2<A, B> listener) {
			return _signal.add(listener);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException if listener argument is null
		 */
		@Override
		public Slot<SignalListener2<A, B>> addOnce(SignalListener2<A, B> listener) {
			return _signal.addOnce(listener);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException if listener argument is null
		 */
		@Override
		public Slot<SignalListener2<A, B>> addWithPriority(SignalListener2<A, B> listener,
				int priority) {
			return _signal.addWithPriority(listener, priority);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException if listener argument is null
		 */
		@Override
		public Slot<SignalListener2<A, B>> addOnceWithPriority(SignalListener2<A, B> listener,
				int priority) {
			return _signal.addOnceWithPriority(listener, priority);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws IllegalArgumentException if listener argument is null
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
