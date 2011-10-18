package org.osjava.signals.impl;

import java.util.List;

import org.osjava.signals.Dispatcher;
import org.osjava.signals.Signal.SignalListener;
import org.osjava.signals.Signal0.SignalListener0;
import org.osjava.signals.Signal1.SignalListener1;
import org.osjava.signals.Signal2.SignalListener2;
import org.osjava.signals.Slot;

public final class DispatcherImpl<L extends SignalListener> implements Dispatcher<L> {

	private final List<Slot<L>> _bindings;

	private DispatcherImpl(List<Slot<L>> bindings) {
		_bindings = bindings;
	}

	public static <L extends SignalListener> Dispatcher<L> newInstance(final List<Slot<L>> bindings) {
		return new DispatcherImpl<L>(bindings);
	}

	@Override
	public void dispatch() {
		for (Slot<L> slot : _bindings) {
			SignalListener slotListener = slot.getListener();
			if (slotListener instanceof SignalListener0) {
				SignalListener0 listener = (SignalListener0) slot.getListener();
				if (listener != null && slot.getEnabled()) {
					if (slot.getOnce())
						slot.remove();
					if (listener != null)
						listener.apply();
				}
			} else
				throw new IllegalArgumentException();
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public <A> void dispatch(A value0) {
		for (Slot<L> slot : _bindings) {
			SignalListener slotListener = slot.getListener();
			if (slotListener instanceof SignalListener1) {
				SignalListener1<A> listener = (SignalListener1<A>) slot.getListener();
				if (listener != null && slot.getEnabled()) {
					if (slot.getOnce())
						slot.remove();
					if (listener != null)
						listener.apply(value0);
				}
			} else
				throw new IllegalArgumentException();
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public <A, B> void dispatch(A value0, B value1) {
		for (Slot<L> slot : _bindings) {
			SignalListener slotListener = slot.getListener();
			if (slotListener instanceof SignalListener2) {
				SignalListener2<A, B> listener = (SignalListener2<A, B>) slot.getListener();
				if (listener != null && slot.getEnabled()) {
					if (slot.getOnce())
						slot.remove();
					if (listener != null)
						listener.apply(value0, value1);
				}
			} else
				throw new IllegalArgumentException();
		}
	}
}
