package org.osjava.signals;

import org.osjava.signals.SignalListener.SignalListener0;
import org.osjava.signals.SignalListener.SignalListener1;
import org.osjava.signals.SignalListener.SignalListener2;
import org.osjava.signals.SignalListener.SignalListener3;
import org.osjava.signals.SignalListener.SignalListener4;
import org.osjava.signals.SignalListener.SignalListener5;

public interface UnifiedSignal<T, L extends SignalListener> extends Signal<L>, PrioritySignal<L>,
		SelectiveSignal<T, L> {

	public static interface UnifiedSignal0<T> extends UnifiedSignal<T, SignalListener0>, Signal0 {

	}

	public static interface UnifiedSignal1<T, A> extends UnifiedSignal<T, SignalListener1<A>>,
			Signal1<A> {

	}

	public static interface UnifiedSignal2<T, A, B> extends
			UnifiedSignal<T, SignalListener2<A, B>>, Signal2<A, B> {

	}

	public static interface UnifiedSignal3<T, A, B, C> extends
			UnifiedSignal<T, SignalListener3<A, B, C>>, Signal3<A, B, C> {

	}

	public static interface UnifiedSignal4<T, A, B, C, D> extends
			UnifiedSignal<T, SignalListener4<A, B, C, D>>, Signal4<A, B, C, D> {

	}

	public static interface UnifiedSignal5<T, A, B, C, D, E> extends
			UnifiedSignal<T, SignalListener5<A, B, C, D, E>>, Signal5<A, B, C, D, E> {

	}
}
