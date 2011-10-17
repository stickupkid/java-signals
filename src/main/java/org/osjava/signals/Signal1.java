package org.osjava.signals;

import org.osjava.signals.Signal1.SignalListener1;

/**
 * Created by IntelliJ IDEA. User: cereals Date: 16/09/2011
 */
public interface Signal1<A> extends Signal<SignalListener1<A>> {
	/**
	 * Dispatches an object to listeners.
	 * 
	 * @param value
	 *            which is the first passed argument
	 */
	public void dispatch(A value);

	public interface SignalListener1<A> extends Signal.SignalListener {
		/**
		 * Listener called when dispatch on the signal is called.
		 * 
		 * @param value
		 *            which is the first passed argument
		 */
		public void apply(A value);
	}
}
