package org.osjava.signals;

import org.osjava.signals.SignalListener.SignalListener0;
import org.osjava.signals.SignalListener.SignalListener1;
import org.osjava.signals.SignalListener.SignalListener2;
import org.osjava.signals.SignalListener.SignalListener3;
import org.osjava.signals.SignalListener.SignalListener4;
import org.osjava.signals.SignalListener.SignalListener5;

public interface SelectiveSignal<T, L extends SignalListener> extends Signal<L> {

	public Slot<L> addFor(T key, L listener);

	public Slot<L> addOnceFor(T key, L listener);

	public SelectiveSignalComparator<T> getComparator();

	public void setComparator(SelectiveSignalComparator<T> comparator);

	public static interface SelectiveSignalComparator<T> {

	}

	public static interface SelectiveSignal0<T> extends SelectiveSignal<T, SignalListener0>,
			Signal0 {

		public static interface SelectiveSignalComparator0<T> extends SelectiveSignalComparator<T> {

			public boolean compare(T key);
		}
	}

	public static interface SelectiveSignal1<T, A> extends SelectiveSignal<T, SignalListener1<A>>,
			Signal1<A> {

		public static interface SelectiveSignalComparator1<T, A> extends
				SelectiveSignalComparator<T> {

			public boolean compare(T key, A value0);
		}
	}

	public static interface SelectiveSignal2<T, A, B> extends
			SelectiveSignal<T, SignalListener2<A, B>>, Signal2<A, B> {

		public static interface SelectiveSignalComparator2<T, A, B> extends
				SelectiveSignalComparator<T> {

			public boolean compare(T key, A value0, B value1);
		}
	}

	public static interface SelectiveSignal3<T, A, B, C> extends
			SelectiveSignal<T, SignalListener3<A, B, C>>, Signal3<A, B, C> {

		public static interface SelectiveSignalComparator3<T, A, B, C> extends
				SelectiveSignalComparator<T> {

			public boolean compare(T key, A value0, B value1, C value2);
		}
	}

	public static interface SelectiveSignal4<T, A, B, C, D> extends
			SelectiveSignal<T, SignalListener4<A, B, C, D>>, Signal4<A, B, C, D> {

		public static interface SelectiveSignalComparator4<T, A, B, C, D> extends
				SelectiveSignalComparator<T> {

			public boolean compare(T key, A value0, B value1, C value2, D value3);
		}
	}

	public static interface SelectiveSignal5<T, A, B, C, D, E> extends
			SelectiveSignal<T, SignalListener5<A, B, C, D, E>>, Signal5<A, B, C, D, E> {

		public static interface SelectiveSignalComparator5<T, A, B, C, D, E> extends
				SelectiveSignalComparator<T> {

			public boolean compare(T key, A value0, B value1, C value2, D value3, E value4);
		}
	}

}
