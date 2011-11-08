package org.osjava.signals;

import java.util.List;

/**
 * Created by IntelliJ IDEA. User: simonrichardson Date: 15/09/2011
 */
public interface Slot<L extends SignalListener> {

	/**
	 * Removes the slot from its signal.
	 */
	public void remove();

	/**
	 * Get the listener associated with this slot.
	 * 
	 * @return SignalListener associated with the slot
	 */
	public L getListener();

	/**
	 * Set the listener associated with this slot.
	 * 
	 * @param value
	 *            which is a type SignalListener
	 */
	public void setListener(L value);

	/**
	 * Get whether this slot is automatically removed after it has been used
	 * once.
	 * 
	 * @return boolean
	 */
	public boolean getOnce();

	/**
	 * Set whether this slot is automatically removed after it has been used.
	 * This doesn't take note if this has been called, it will take affect the
	 * next time around.
	 * 
	 * @param value
	 *            which is to set whether the slot will be removed after use.
	 */
	public void setOnce(boolean value);

	/**
	 * Get whether the listener is called on execution. Defaults to true.
	 * 
	 * @return True if the listener is called on execution
	 */
	public boolean getEnabled();

	/**
	 * Set whether the listener is called on execution
	 * 
	 * @param value
	 *            if true the listener is called on execution
	 */
	public void setEnabled(boolean value);
	
	/**
	 * Allows the Slot to inject parameters when dispatching. The params will be at 
	 * the tail of the arguments and the Signal arguments will be at the head.
	 * 
	 * {@code
	 * Signal<String> signal = SignalImpl1.newInstance();
	 * signal.add(handler).callWith(Arrays.asList(42));
	 * signal.dispatch("The Answer");
	 * }
	 * @return Slot which is the current slot instance
	 */
	public Slot<L> callWith(List<?> params);
	
	/**
	 * Get the Slot parameters for dispatching when executing.
	 * 
	 * @return the list of parameters when execution
	 */
	public List<?> getParams();
}
