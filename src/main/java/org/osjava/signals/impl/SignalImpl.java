package org.osjava.signals.impl;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.osjava.signals.Dispatcher;
import org.osjava.signals.Signal;
import org.osjava.signals.SignalListener;
import org.osjava.signals.SignalListener.SignalListener0;
import org.osjava.signals.SignalListener.SignalListener1;
import org.osjava.signals.SignalListener.SignalListener2;
import org.osjava.signals.Slot;

/**
 * Created by IntelliJ IDEA. User: simonrichardson Date: 15/09/2011
 */
public class SignalImpl<L extends SignalListener> implements Signal<L> {

	protected final List<Slot<L>> bindings;

	public SignalImpl(List<Slot<L>> bindings) {
		if (null == bindings)
			throw new IllegalArgumentException("Bindings can not be null");

		this.bindings = bindings;
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
	public static <L extends SignalListener> SignalImpl<L> newInstance(List<Slot<L>> bindings) {
		if (null == bindings)
			throw new IllegalArgumentException("Bindings can not be null");

		return new SignalImpl<L>(bindings);
	}

	/**
	 * {@inheritDoc}
	 */
	public Slot<L> add(L listener) {
		if (null == listener)
			throw new IllegalArgumentException("Listener can not be null");

		return registerListener(listener, false);
	}

	/**
	 * {@inheritDoc}
	 */
	public Slot<L> addOnce(L listener) {
		if (null == listener)
			throw new IllegalArgumentException("Listener can not be null");

		return registerListener(listener, true);
	}

	/**
	 * {@inheritDoc}
	 */
	public Slot<L> remove(L listener) {
		if (null == listener)
			throw new IllegalArgumentException("Listener can not be null");

		final Slot<L> slot = findSlotByListener(listener);
		if (slot != null) {
			bindings.remove(slot);
			return slot;
		} else
			return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeAll() {
		bindings.clear();
	}

	/**
	 * {@inheritDoc}
	 */
	public int getNumListeners() {
		return bindings.size();
	}

	/**
	 * Find the slot by the associated listener
	 * 
	 * @param listener
	 *            which is the type of SignalListenerType to look for
	 * @return a SlotType, which contains the Function passed as the parameter
	 */
	protected Slot<L> findSlotByListener(L listener) {
		assert null != listener : "Listener can not be null";

		for (Slot<L> slot : bindings) {
			if (slot.getListener().equals(listener))
				return slot;
		}
		return null;
	}

	/**
	 * Register a listener
	 * 
	 * @param listener
	 *            which is the type of SignalListenerType
	 * @param once
	 *            if the listener should just be called once
	 * @return a SlotType, which contains the Function passed as the parameter
	 */
	protected Slot<L> registerListener(L listener, boolean once) {
		assert null != listener : "Listener can not be null";

		Slot<L> slot = null;
		if (registrationPossible(listener, once))
		{
			slot = new SlotImpl<L>(this, once);
			slot.setListener(listener);
			
			bindings.add(slot);
		}
		else
			slot = findSlotByListener(listener);
		return slot;
	}

	/**
	 * @param listener
	 *            which is the type of SignalListenerType
	 * @param once
	 *            if the listener should just be called once
	 * @return boolean if successful
	 * @throws IllegalArgumentException
	 *             if you try to re-add with a different add type
	 */
	protected boolean registrationPossible(L listener, boolean once) {
		assert null != listener : "Listener can not be null";

		if (bindings.size() > 0)
			return true;
		else {
			final Slot<L> slot = findSlotByListener(listener);
			if (slot == null)
				return true;
			else {
				if (slot.getOnce() != once) {
					throw new IllegalArgumentException("You cannot addOnce() then add() the "
							+ "same listener without removing the relationship first.");
				}

				return false;
			}
		}
	}

	public static class SignalImpl0 implements Signal0 {

		private final List<Slot<SignalListener0>> _bindings = new CopyOnWriteArrayList<Slot<SignalListener0>>();

		private final Dispatcher<SignalListener0> _dispatcher = DispatcherImpl
				.newInstance(_bindings);

		private final SignalImpl<SignalListener0> _signal = SignalImpl.newInstance(_bindings);

		private SignalImpl0() {
			// Private constructor
		}

		/**
		 * Create a newInstance of Signal0
		 * 
		 * @return {@link Signal0}
		 */
		public static Signal0 newInstance() {
			return new SignalImpl0();
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

	public static class SignalImpl1<A> implements Signal1<A> {

		private final List<Slot<SignalListener1<A>>> _bindings = new CopyOnWriteArrayList<Slot<SignalListener1<A>>>();

		private final Dispatcher<SignalListener1<A>> _dispatcher = DispatcherImpl
				.newInstance(_bindings);

		private final SignalImpl<SignalListener1<A>> _signal = SignalImpl.newInstance(_bindings);

		/**
		 * Private constructor
		 */
		private SignalImpl1() {

		}

		/**
		 * Create a newInstance of Signal1
		 * 
		 * @return {@link Signal1}
		 */
		public static <A> Signal1<A> newInstance() {
			return new SignalImpl1<A>();
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

	public static class SignalImpl2<A, B> implements Signal2<A, B> {

		private final List<Slot<SignalListener2<A, B>>> _bindings = new CopyOnWriteArrayList<Slot<SignalListener2<A, B>>>();

		private final Dispatcher<SignalListener2<A, B>> _dispatcher = DispatcherImpl
				.newInstance(_bindings);

		private final SignalImpl<SignalListener2<A, B>> _signal = SignalImpl.newInstance(_bindings);

		/**
		 * Private constructor
		 */
		private SignalImpl2() {

		}

		/**
		 * Create a newInstance of Signal2
		 * 
		 * @return {@link Signal2}
		 */
		public static <A, B> Signal2<A, B> newInstance() {
			return new SignalImpl2<A, B>();
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
