package org.osjava.signals;

/**
 * Created by IntelliJ IDEA. User: cereals Date: 16/09/2011
 */
public interface Signal1<A, SlotType extends Slot<SignalListenerType>, SignalListenerType extends Signal1.SignalListener1<A>>
		extends Signal<SlotType, SignalListenerType> {
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
