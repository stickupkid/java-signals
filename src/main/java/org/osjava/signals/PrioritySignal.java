package org.osjava.signals;

import org.osjava.signals.SignalListener.SignalListener0;
import org.osjava.signals.SignalListener.SignalListener1;
import org.osjava.signals.SignalListener.SignalListener2;
import org.osjava.signals.SignalListener.SignalListener3;
import org.osjava.signals.SignalListener.SignalListener4;
import org.osjava.signals.SignalListener.SignalListener5;

public interface PrioritySignal<L extends SignalListener> extends Signal<L> {

	/**
	 * Subscribes a listener for the signal. After you successfully register an
	 * event listener, you cannot change its priority through additional calls
	 * to add(). To change a listener's priority, you must first call remove().
	 * Then you can register the listener again with the new priority level.
	 * 
	 * @param listener
	 *            A function with an argument that matches the type of event
	 *            dispatched by the signal. If eventClass is not specified, the
	 *            listener and dispatch() can be called without an argument.
	 * @return a Slot, which contains the Function passed as the parameter
	 * @see Slot
	 * @throws flash.errors.IllegalOperationError
	 *             <code>IllegalOperationError</code>: You cannot addOnce() then
	 *             add() the same listener without removing the relationship
	 *             first.
	 * @throws ArgumentError
	 *             <code>ArgumentError</code>: Given listener is
	 *             <code>null</code>.
	 */
	public Slot<L> addWithPriority(L listener, int priority);

	/**
	 * Subscribes a one-time listener for this signal. The signal will remove
	 * the listener automatically the first time it is called, after the
	 * dispatch to all listeners is complete.
	 * 
	 * @param listener
	 *            A function with an argument that matches the type of event
	 *            dispatched by the signal. If eventClass is not specified, the
	 *            listener and dispatch() can be called without an argument.
	 * @param priority
	 *            The priority level of the event listener. The priority is
	 *            designated by a signed 32-bit integer. The higher the number,
	 *            the higher the priority. All listeners with priority n are
	 *            processed before listeners of priority n-1.
	 * @return a Slot, which contains the Function passed as the parameter
	 * @see Slot
	 * @throws flash.errors.IllegalOperationError
	 *             <code>IllegalOperationError</code>: You cannot addOnce() then
	 *             add() the same listener without removing the relationship
	 *             first.
	 * @throws ArgumentError
	 *             <code>ArgumentError</code>: Given listener is
	 *             <code>null</code>.
	 */
	public Slot<L> addOnceWithPriority(L listener, int priority);

	public static interface PrioritySignal0 extends PrioritySignal<SignalListener0>, Signal0 {

	}

	public static interface PrioritySignal1<A> extends PrioritySignal<SignalListener1<A>>,
			Signal1<A> {

	}

	public static interface PrioritySignal2<A, B> extends PrioritySignal<SignalListener2<A, B>>,
			Signal2<A, B> {

	}

	public static interface PrioritySignal3<A, B, C> extends
			PrioritySignal<SignalListener3<A, B, C>>, Signal3<A, B, C> {

	}

	public static interface PrioritySignal4<A, B, C, D> extends
			PrioritySignal<SignalListener4<A, B, C, D>>, Signal4<A, B, C, D> {

	}

	public static interface PrioritySignal5<A, B, C, D, E> extends
			PrioritySignal<SignalListener5<A, B, C, D, E>>, Signal5<A, B, C, D, E> {

	}
}
