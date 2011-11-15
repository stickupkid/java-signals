package org.osjava.signals;

public interface UnifiedSlot<T, L extends SignalListener> extends Slot<L>, PrioritySlot<L>,
		SelectiveSlot<T, L> {

}
