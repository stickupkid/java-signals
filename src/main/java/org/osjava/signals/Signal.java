package org.osjava.signals;

import org.osjava.signals.SignalListener.SignalListener0;
import org.osjava.signals.SignalListener.SignalListener1;
import org.osjava.signals.SignalListener.SignalListener2;

/**
 * Created by IntelliJ IDEA. User: simonrichardson Date: 15/09/2011
 */
public interface Signal<L extends SignalListener> {
	/**
	 * Subscribes a listener for the signal.
	 * 
	 * @return a SlotType, which contains the Function passed as the parameter
	 * @param listener
	 *            A function with arguments that matches the value classes
	 *            dispatched by the signal. If value classes are not specified
	 *            (e.g. via Signal constructor), dispatch() can be called
	 *            without arguments.
	 */
	public Slot<L> add(L listener);

	/**
	 * Subscribes a one-time listener for this signal. The signal will remove
	 * the listener automatically the first time it is called, after the
	 * dispatch to all listeners is complete.
	 * 
	 * @return a SlotType, which contains the Function passed as the parameter
	 * @param listener
	 *            A function with arguments that matches the value classes
	 *            dispatched by the signal. If value classes are not specified
	 *            (e.g. via Signal constructor), dispatch() can be called
	 *            without arguments.
	 */
	public Slot<L> addOnce(L listener);

	/**
	 * Unsubscribes a listener from the signal.
	 * 
	 * @return a SlotType, which contains the Function passed as the parameter
	 * @param listener
	 *            A function with arguments
	 */
	public Slot<L> remove(L listener);

	/**
	 * Unsubscribes all listeners from the signal.
	 */
	public void removeAll();

	/**
	 * The current number of listeners for the signal.
	 * 
	 * @return a int of the number of listeners
	 */
	public int getNumListeners();

	public static interface Signal0 extends Signal<SignalListener0> {
		/**
		 * Dispatches an object to listeners.
		 */
		public boolean dispatch();
	}

	public static interface Signal1<A> extends Signal<SignalListener1<A>> {
		/**
		 * Dispatches an object to listeners.
		 * 
		 * @param value
		 *            which is the first passed argument
		 */
		public void dispatch(A value);
	}

	public static interface Signal2<A, B> extends Signal<SignalListener2<A, B>> {
		/**
		 * Dispatches an object to listeners.
		 * 
		 * @param value0
		 *            which is the first passed argument
		 * @param value1
		 *            which is the second passed argument
		 */
		public void dispatch(A value0, B value1);
	}
}
