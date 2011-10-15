package org.osjava.signals;

/**
 * Created by IntelliJ IDEA. User: cereals Date: 16/09/2011
 */
public interface Signal2<A, B, SlotType extends Slot<SignalListenerType>, SignalListenerType extends Signal2.SignalListener2<A, B>>
		extends Signal<SlotType, SignalListenerType> {
	/**
	 * Dispatches an object to listeners.
	 * 
	 * @param value0
	 *            which is the first passed argument
	 * @param value1
	 *            which is the second passed argument
	 */
	public void dispatch(A value0, B value1);

	public interface SignalListener2<A, B> extends Signal.SignalListener {
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
