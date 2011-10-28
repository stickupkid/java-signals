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

public class PrioritySignalImpl<L extends SignalListener> extends SignalImpl<L> implements
		PrioritySignal<L> {

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
	 */
	public static <L extends SignalListener> PrioritySignalImpl<L> newInstance(
			List<Slot<L>> bindings) {
		return new PrioritySignalImpl<L>(bindings);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Slot<L> addWithPriority(L listener, int priority) {
		return registerListener(listener, false, priority);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Slot<L> addOnceWithPriority(L listener, int priority) {
		return registerListener(listener, true, priority);
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
	 */
	@SuppressWarnings("unchecked")
	protected Slot<L> registerListener(L listener, boolean once, int priority) {
		Slot<L> slot = null;
		if (registrationPossible(listener, once)) {
			slot = new PrioritySlotImpl<L>(this, listener, once, priority);
			if (slot != null) {
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
		public Slot<SignalListener1<A>> addOnceWithPriority(SignalListener1<A> listener,
				int priority) {
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
		public Slot<SignalListener2<A, B>> addWithPriority(SignalListener2<A, B> listener,
				int priority) {
			return _signal.add(listener);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Slot<SignalListener2<A, B>> addOnceWithPriority(SignalListener2<A, B> listener,
				int priority) {
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

}
