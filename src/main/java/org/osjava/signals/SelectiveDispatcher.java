package org.osjava.signals;

import org.osjava.signals.SelectiveSignal.SelectiveSignalComparator;

public interface SelectiveDispatcher<T, L extends SignalListener> extends Dispatcher<L> {

	/**
	 * Get the comparator used by the dispatcher when executing the listeners
	 * 
	 * @return {@link SelectiveSignalComparator} which is used when executing
	 *         the listeners
	 */
	public SelectiveSignalComparator<T> getComparator();

	/**
	 * Set the comparator to be used with the dispatcher.
	 * 
	 * @param comparator
	 *            to be used when executing the listeners
	 */
	public void setComparator(SelectiveSignalComparator<T> comparator);

}
