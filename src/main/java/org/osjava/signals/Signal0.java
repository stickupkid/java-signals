package org.osjava.signals;

import org.osjava.signals.Signal.SignalListener;
import org.osjava.signals.Signal0.SignalListener0;

/**
 * Created by IntelliJ IDEA. User: cereals Date: 16/09/2011
 */
public interface Signal0 extends Signal<SignalListener0> {
	/**
	 * Dispatches an object to listeners.
	 */
	public void dispatch();

	public interface SignalListener0 extends SignalListener {
		/**
		 * Listener called when dispatch on the signal is called.
		 */
		public void apply();
	}
}
