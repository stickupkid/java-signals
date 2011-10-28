package org.osjava.signals;


public interface PrioritySlot<L extends SignalListener> extends Slot<L> {
	
	public int getPriority();
}
