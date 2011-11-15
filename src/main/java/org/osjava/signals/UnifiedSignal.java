package org.osjava.signals;

public interface UnifiedSignal<T, L extends SignalListener> extends Signal<L>, PrioritySignal<L>,
		SelectiveSignal<T, L> {

}
