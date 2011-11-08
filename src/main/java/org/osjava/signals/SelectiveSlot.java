package org.osjava.signals;

public interface SelectiveSlot<T, L extends SignalListener> extends Slot<L> {

	public T getKey();
}
