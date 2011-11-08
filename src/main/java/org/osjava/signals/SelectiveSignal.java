package org.osjava.signals;

import org.osjava.signals.SignalListener.SignalListener0;
import org.osjava.signals.SignalListener.SignalListener1;
import org.osjava.signals.SignalListener.SignalListener2;

public interface SelectiveSignal<T, L extends SignalListener> extends Signal<L> {

	public Slot<L> addFor(T key, L listener);

	public Slot<L> addOnceFor(T key, L listener);

	public static interface SelectiveSignal0<T> extends SelectiveSignal<T, SignalListener0>,
			Signal0 {

	}

	public static interface SelectiveSignal1<T, A> extends SelectiveSignal<T, SignalListener1<A>>,
			Signal1<A> {

	}

	public static interface SelectiveSignal2<T, A, B> extends
			SelectiveSignal<T, SignalListener2<A, B>>, Signal2<A, B> {

	}
}
