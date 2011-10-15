package org.osjava.signals.impl;

import java.util.List;

import org.osjava.signals.Signal;
import org.osjava.signals.Signal0;
import org.osjava.signals.Signal1;
import org.osjava.signals.Signal2;
import org.osjava.signals.Slot;

/**
 * Created by IntelliJ IDEA. User: simonrichardson Date: 19/09/2011 Time: 21:31
 */
public class DispatcherImpl<SlotType extends Slot<Signal.SignalListener>> {

	private final List<SlotType> bindings;

	public DispatcherImpl(List<SlotType> bindings) {
		this.bindings = bindings;
	}

	@SuppressWarnings("unchecked")
	final public <SignalListenerType extends Signal0.SignalListener0> void dispatch() {
		SignalListenerType listener = null;
		for (SlotType slot : bindings) {
			try {
				listener = (SignalListenerType) slot.getListener();
			} catch (ClassCastException e) {
			} finally {
				if (listener != null && slot.getEnabled()) {
					if (slot.getOnce())
						slot.remove();
					if (listener != null)
						listener.apply();
				}
			}

		}
	}

	@SuppressWarnings("unchecked")
	final public <A, SignalListenerType extends Signal1.SignalListener1<A>> void dispatch(A value0) {
		SignalListenerType listener = null;
		for (SlotType slot : bindings) {
			try {
				listener = (SignalListenerType) slot.getListener();
			} catch (ClassCastException e) {
			} finally {
				if (listener != null && slot.getEnabled()) {
					if (slot.getOnce())
						slot.remove();
					if (listener != null)
						listener.apply(value0);
				}
			}

		}
	}

	@SuppressWarnings("unchecked")
	final public <A, B, SignalListenerType extends Signal2.SignalListener2<A, B>> void dispatch(
			A value0, B value1) {
		SignalListenerType listener = null;
		for (SlotType slot : bindings) {
			try {
				listener = (SignalListenerType) slot.getListener();
			} catch (ClassCastException e) {
			} finally {
				if (listener != null && slot.getEnabled()) {
					if (slot.getOnce())
						slot.remove();
					if (listener != null)
						listener.apply(value0, value1);
				}
			}

		}
	}
}
