package org.osjava.signals;

public interface WeakRefSlot<L extends SignalListener> extends Slot<L> {

	public boolean getWeakRef();
}
