package org.osjava.signals;

public interface SignalListener {

	public static interface SignalListener0 extends SignalListener {
		/**
		 * Listener called when dispatch on the signal is called.
		 */
		public void apply();
	}

	public static interface SignalListener1<A> extends SignalListener {
		/**
		 * Listener called when dispatch on the signal is called.
		 * 
		 * @param value
		 *            which is the first passed argument
		 */
		public void apply(A value);
	}

	public static interface SignalListener2<A, B> extends SignalListener {
		/**
		 * Listener called when dispatch on the signal is called.
		 * 
		 * @param value0
		 *            which is the first passed argument
		 * @param value1
		 *            which is the second passed argument
		 */
		public void apply(A value0, B value1);
	}
}
