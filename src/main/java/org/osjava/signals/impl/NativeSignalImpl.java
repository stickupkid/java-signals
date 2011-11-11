package org.osjava.signals.impl;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.osjava.signals.Dispatcher;
import org.osjava.signals.NativeSignal;
import org.osjava.signals.SignalListener;
import org.osjava.signals.SignalListener.SignalListener1;
import org.osjava.signals.SignalListener.SignalListener2;
import org.osjava.signals.SignalListener.SignalListener3;
import org.osjava.signals.SignalListener.SignalListener4;
import org.osjava.signals.SignalListener.SignalListener5;
import org.osjava.signals.Slot;

public class NativeSignalImpl<L extends SignalListener, T> extends SignalImpl<L> implements
		NativeSignal<L, T> {

	private T _target;

	public NativeSignalImpl(List<Slot<L>> bindings) {
		super(bindings);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T getTarget() {
		return _target;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setTarget(T target) {
		if (null == target)
			throw new IllegalArgumentException("Target can not be null");

		_target = target;
	}

	public static class NativeSignalImpl1<A> implements NativeSignal1<A> {

		private final List<Slot<SignalListener1<A>>> _bindings = new CopyOnWriteArrayList<Slot<SignalListener1<A>>>();

		private final Dispatcher<SignalListener1<A>> _dispatcher = DispatcherImpl
				.newInstance(_bindings);

		private final NativeSignalImpl<SignalListener1<A>, A> _signal = new NativeSignalImpl<SignalListener1<A>, A>(
				_bindings);

		/**
		 * Private constructor
		 */
		protected NativeSignalImpl1() {
		}

		/**
		 * Create a newInstance of NativeSignal1
		 * 
		 * @return {@link NativeSignal1}
		 */
		public static <A> NativeSignalImpl1<A> newInstance() {
			return new NativeSignalImpl1<A>();
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
		 * 
		 * @throws IllegalAccessError
		 *             if target is null when the dispatch method is called.
		 */
		public void dispatch(A value0) throws Throwable {
			if (null == _signal.getTarget())
				throw new IllegalAccessError("Target can not be null");

			_dispatcher.dispatch(value0);
		}

		@Override
		public A getTarget() {
			return _signal.getTarget();
		}

		@Override
		public void setTarget(A target) {
			removeTargetListener();

			_signal.setTarget(target);

			registerTargetListener();
		}

		/**
		 * Register the target listener
		 */
		protected void registerTargetListener() {
			throw new AbstractMethodError();
		}

		/**
		 * Remove the target listener
		 */
		protected void removeTargetListener() {
			throw new AbstractMethodError();
		}
	}

	public static class NativeSignalImpl2<A, B> implements NativeSignal2<A, B> {

		private final List<Slot<SignalListener2<A, B>>> _bindings = new CopyOnWriteArrayList<Slot<SignalListener2<A, B>>>();

		private final Dispatcher<SignalListener2<A, B>> _dispatcher = DispatcherImpl
				.newInstance(_bindings);

		private final NativeSignalImpl<SignalListener2<A, B>, A> _signal = new NativeSignalImpl<SignalListener2<A, B>, A>(
				_bindings);

		/**
		 * Private constructor
		 */
		protected NativeSignalImpl2() {
		}

		/**
		 * Create a newInstance of NativeSignal1
		 * 
		 * @return {@link NativeSignal1}
		 */
		public static <A, B> NativeSignalImpl2<A, B> newInstance() {
			return new NativeSignalImpl2<A, B>();
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
		 * 
		 * @throws IllegalAccessError
		 *             if target is null when the dispatch method is called.
		 */
		public void dispatch(A value0, B value1) throws Throwable {
			if (null == _signal.getTarget())
				throw new IllegalAccessError("Target can not be null");

			_dispatcher.dispatch(value0, value1);
		}

		@Override
		public A getTarget() {
			return _signal.getTarget();
		}

		@Override
		public void setTarget(A target) {
			removeTargetListener();

			_signal.setTarget(target);

			registerTargetListener();
		}

		/**
		 * Register the target listener
		 */
		protected void registerTargetListener() {
			throw new AbstractMethodError();
		}

		/**
		 * Remove the target listener
		 */
		protected void removeTargetListener() {
			throw new AbstractMethodError();
		}
	}

	public static class NativeSignalImpl3<A, B, C> implements NativeSignal3<A, B, C> {

		private final List<Slot<SignalListener3<A, B, C>>> _bindings = new CopyOnWriteArrayList<Slot<SignalListener3<A, B, C>>>();

		private final Dispatcher<SignalListener3<A, B, C>> _dispatcher = DispatcherImpl
				.newInstance(_bindings);

		private final NativeSignalImpl<SignalListener3<A, B, C>, A> _signal = new NativeSignalImpl<SignalListener3<A, B, C>, A>(
				_bindings);

		/**
		 * Private constructor
		 */
		protected NativeSignalImpl3() {
		}

		/**
		 * Create a newInstance of NativeSignal1
		 * 
		 * @return {@link NativeSignal1}
		 */
		public static <A, B, C> NativeSignalImpl3<A, B, C> newInstance() {
			return new NativeSignalImpl3<A, B, C>();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Slot<SignalListener3<A, B, C>> add(SignalListener3<A, B, C> listener) {
			return _signal.add(listener);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Slot<SignalListener3<A, B, C>> addOnce(SignalListener3<A, B, C> listener) {
			return _signal.addOnce(listener);
		}

		/**
		 * {@inheritDoc}
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
		 * 
		 * @throws IllegalAccessError
		 *             if target is null when the dispatch method is called.
		 */
		public void dispatch(A value0, B value1, C value2) throws Throwable {
			if (null == _signal.getTarget())
				throw new IllegalAccessError("Target can not be null");

			_dispatcher.dispatch(value0, value1, value2);
		}

		@Override
		public A getTarget() {
			return _signal.getTarget();
		}

		@Override
		public void setTarget(A target) {
			removeTargetListener();

			_signal.setTarget(target);

			registerTargetListener();
		}

		/**
		 * Register the target listener
		 */
		protected void registerTargetListener() {
			throw new AbstractMethodError();
		}

		/**
		 * Remove the target listener
		 */
		protected void removeTargetListener() {
			throw new AbstractMethodError();
		}
	}

	public static class NativeSignalImpl4<A, B, C, D> implements NativeSignal4<A, B, C, D> {

		private final List<Slot<SignalListener4<A, B, C, D>>> _bindings = new CopyOnWriteArrayList<Slot<SignalListener4<A, B, C, D>>>();

		private final Dispatcher<SignalListener4<A, B, C, D>> _dispatcher = DispatcherImpl
				.newInstance(_bindings);

		private final NativeSignalImpl<SignalListener4<A, B, C, D>, A> _signal = new NativeSignalImpl<SignalListener4<A, B, C, D>, A>(
				_bindings);

		/**
		 * Private constructor
		 */
		protected NativeSignalImpl4() {
		}

		/**
		 * Create a newInstance of NativeSignal1
		 * 
		 * @return {@link NativeSignal1}
		 */
		public static <A, B, C, D> NativeSignalImpl4<A, B, C, D> newInstance() {
			return new NativeSignalImpl4<A, B, C, D>();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Slot<SignalListener4<A, B, C, D>> add(SignalListener4<A, B, C, D> listener) {
			return _signal.add(listener);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Slot<SignalListener4<A, B, C, D>> addOnce(SignalListener4<A, B, C, D> listener) {
			return _signal.addOnce(listener);
		}

		/**
		 * {@inheritDoc}
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
		 * 
		 * @throws IllegalAccessError
		 *             if target is null when the dispatch method is called.
		 */
		public void dispatch(A value0, B value1, C value2, D value3) throws Throwable {
			if (null == _signal.getTarget())
				throw new IllegalAccessError("Target can not be null");

			_dispatcher.dispatch(value0, value1, value2, value3);
		}

		@Override
		public A getTarget() {
			return _signal.getTarget();
		}

		@Override
		public void setTarget(A target) {
			removeTargetListener();

			_signal.setTarget(target);

			registerTargetListener();
		}

		/**
		 * Register the target listener
		 */
		protected void registerTargetListener() {
			throw new AbstractMethodError();
		}

		/**
		 * Remove the target listener
		 */
		protected void removeTargetListener() {
			throw new AbstractMethodError();
		}
	}

	public static class NativeSignalImpl5<A, B, C, D, E> implements NativeSignal5<A, B, C, D, E> {

		private final List<Slot<SignalListener5<A, B, C, D, E>>> _bindings = new CopyOnWriteArrayList<Slot<SignalListener5<A, B, C, D, E>>>();

		private final Dispatcher<SignalListener5<A, B, C, D, E>> _dispatcher = DispatcherImpl
				.newInstance(_bindings);

		private final NativeSignalImpl<SignalListener5<A, B, C, D, E>, A> _signal = new NativeSignalImpl<SignalListener5<A, B, C, D, E>, A>(
				_bindings);

		/**
		 * Private constructor
		 */
		protected NativeSignalImpl5() {
		}

		/**
		 * Create a newInstance of NativeSignal1
		 * 
		 * @return {@link NativeSignal1}
		 */
		public static <A, B, C, D, E> NativeSignalImpl5<A, B, C, D, E> newInstance() {
			return new NativeSignalImpl5<A, B, C, D, E>();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Slot<SignalListener5<A, B, C, D, E>> add(SignalListener5<A, B, C, D, E> listener) {
			return _signal.add(listener);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Slot<SignalListener5<A, B, C, D, E>> addOnce(SignalListener5<A, B, C, D, E> listener) {
			return _signal.addOnce(listener);
		}

		/**
		 * {@inheritDoc}
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
		 * 
		 * @throws IllegalAccessError
		 *             if target is null when the dispatch method is called.
		 */
		public void dispatch(A value0, B value1, C value2, D value3, E value4) throws Throwable {
			if (null == _signal.getTarget())
				throw new IllegalAccessError("Target can not be null");

			_dispatcher.dispatch(value0, value1, value2, value3, value4);
		}

		@Override
		public A getTarget() {
			return _signal.getTarget();
		}

		@Override
		public void setTarget(A target) {
			removeTargetListener();

			_signal.setTarget(target);

			registerTargetListener();
		}

		/**
		 * Register the target listener
		 */
		protected void registerTargetListener() {
			throw new AbstractMethodError();
		}

		/**
		 * Remove the target listener
		 */
		protected void removeTargetListener() {
			throw new AbstractMethodError();
		}
	}
}
