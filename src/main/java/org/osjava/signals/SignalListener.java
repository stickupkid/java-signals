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
	
	public static interface SignalListener3<A, B, C> extends SignalListener {
		/**
		 * Listener called when dispatch on the signal is called.
		 * 
		 * @param value0
		 *            which is the first passed argument
		 * @param value1
		 *            which is the second passed argument
		 * @param value2
		 *            which is the third passed argument                      
		 */
		public void apply(A value0, B value1, C value2);
	}

	public static interface SignalListener4<A, B, C, D> extends SignalListener {
		/**
		 * Listener called when dispatch on the signal is called.
		 * 
		 * @param value0
		 *            which is the first passed argument
		 * @param value1
		 *            which is the second passed argument
		 * @param value2
		 *            which is the third passed argument
		 * @param value3
		 *            which is the fourth passed argument
		 */
		public void apply(A value0, B value1, C value2, D value3);
	}
	
	public static interface SignalListener5<A, B, C, D, E> extends SignalListener {
		/**
		 * Listener called when dispatch on the signal is called.
		 * 
		 * @param value0
		 *            which is the first passed argument
		 * @param value1
		 *            which is the second passed argument
		 * @param value2
		 *            which is the third passed argument  
		 * @param value3
		 *            which is the fourth passed argument
		 * @param value4
		 *            which is the fifth passed argument                               
		 */
		public void apply(A value0, B value1, C value2, D value3, E value4);
	}
}
