package org.osjava.signals;

import org.osjava.signals.Signal.SignalListener;

public interface PrioritySlot<L extends SignalListener> {
	
	public int getPriority();
}
