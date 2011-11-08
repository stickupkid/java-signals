package org.osjava.signals.impl;

import java.util.List;

import org.osjava.signals.SelectiveSignal;
import org.osjava.signals.SignalListener;
import org.osjava.signals.Slot;

public class SelectiveSignalImpl<T, L extends SignalListener> extends SignalImpl<L> implements
		SelectiveSignal<T, L> {

	public SelectiveSignalImpl(List<Slot<L>> bindings) {
		super(bindings);
	}

	@Override
	public Slot<L> addFor(T key, L listener) {
		return null;
	}

	@Override
	public Slot<L> addOnceFor(T key, L listener) {
		return null;
	}

}
