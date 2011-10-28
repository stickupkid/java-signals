package org.osjava.signals;

import org.osjava.signals.SignalListener.SignalListener0;
import org.osjava.signals.SignalListener.SignalListener1;
import org.osjava.signals.SignalListener.SignalListener2;

public interface WeakRefSignal<L extends SignalListener> extends Signal<L> {

	/**
	 * Subscribes a listener for the signal. After you successfully register an
	 * event listener, you cannot change its priority through additional calls
	 * to add(). To change a listener's weakRef, you must first call remove().
	 * Then you can register the listener again with the new weakRef.
	 * 
	 * @param listener
	 *            A function with an argument that matches the type of event
	 *            dispatched by the signal. If eventClass is not specified, the
	 *            listener and dispatch() can be called without an argument.
	 */
	public Slot<L> addWithWeakRef(L listener, boolean weakRef);

	/**
	 * Subscribes a one-time listener for this signal. The signal will remove
	 * the listener automatically the first time it is called, after the
	 * dispatch to all listeners is complete.
	 * 
	 * @param listener
	 *            A function with an argument that matches the type of event
	 *            dispatched by the signal. If eventClass is not specified, the
	 *            listener and dispatch() can be called without an argument.
	 */
	public Slot<L> addOnceWithWeakRef(L listener, boolean weakRef);

	public static interface WeakRefSignal0 extends WeakRefSignal<SignalListener0>, Signal0 {

	}

	public static interface WeakRefSignal1<A> extends WeakRefSignal<SignalListener1<A>>, Signal1<A> {

	}

	public static interface WeakRefSignal2<A, B> extends WeakRefSignal<SignalListener2<A, B>>,
			Signal2<A, B> {

	}
}
