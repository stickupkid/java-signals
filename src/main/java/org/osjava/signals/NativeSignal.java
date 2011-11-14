package org.osjava.signals;

import org.osjava.signals.SignalListener.SignalListener1;
import org.osjava.signals.SignalListener.SignalListener2;
import org.osjava.signals.SignalListener.SignalListener3;
import org.osjava.signals.SignalListener.SignalListener4;
import org.osjava.signals.SignalListener.SignalListener5;


public interface NativeSignal<L extends SignalListener, T> extends Signal<L> {

	/**
	 * The object considered the source of the dispatched events.
	 */
	public T getTarget();

	public void setTarget(T target);
	
	/**
	 * Is the current native method available to register on the signal
	 * 
	 * @param True if the native listener method is available
	 */
	public boolean isAvailable();
	
	public static interface NativeSignal1<T> extends NativeSignal<SignalListener1<T>, T> {

	}

	public static interface NativeSignal2<T, B> extends NativeSignal<SignalListener2<T, B>, T> {

	}
	
	public static interface NativeSignal3<T, B, C> extends NativeSignal<SignalListener3<T, B, C>, T> {

	}
	
	public static interface NativeSignal4<T, B, C, D> extends NativeSignal<SignalListener4<T, B, C, D>, T> {

	}
	
	public static interface NativeSignal5<T, B, C, D, E> extends NativeSignal<SignalListener5<T, B, C, D, E>, T> {

	}
}
