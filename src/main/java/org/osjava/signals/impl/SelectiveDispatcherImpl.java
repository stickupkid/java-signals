package org.osjava.signals.impl;

import java.util.List;

import org.osjava.signals.SelectiveDispatcher;
import org.osjava.signals.SelectiveSignal.SelectiveSignal0.SelectiveSignalComparator0;
import org.osjava.signals.SelectiveSignal.SelectiveSignal1.SelectiveSignalComparator1;
import org.osjava.signals.SelectiveSignal.SelectiveSignal2.SelectiveSignalComparator2;
import org.osjava.signals.SelectiveSignal.SelectiveSignalComparator;
import org.osjava.signals.SelectiveSlot;
import org.osjava.signals.SignalListener;
import org.osjava.signals.Slot;

public final class SelectiveDispatcherImpl<T, L extends SignalListener> extends DispatcherImpl<L>
		implements SelectiveDispatcher<T, L> {

	private SelectiveSignalComparator<T> _comparator;

	protected SelectiveDispatcherImpl(List<Slot<L>> bindings) {
		super(bindings);
	}

	/**
	 * {@inheritDoc}
	 */
	public SelectiveSignalComparator<T> getComparator() {
		return _comparator;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setComparator(SelectiveSignalComparator<T> comparator) {
		if (null == comparator)
			throw new AssertionError("Comparator can not be null");

		_comparator = comparator;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws NullPointerException
	 *             if the comparator is null
	 * @throws IllegalAccessError
	 *             if the comparator is not of type
	 *             {@link SelectiveSignalComparator0}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void dispatch() throws Throwable {
		// If there is no comparator then we should just dispatch them all?
		if (null == _comparator)
			throw new NullPointerException("Comparator can not be null");
		else if (!(_comparator instanceof SelectiveSignalComparator0))
			throw new IllegalAccessError("Comparator must be a type of SelectiveSignalComparator0");
		else {
			final SelectiveSignalComparator0<T> comparator = (SelectiveSignalComparator0<T>) _comparator;

			// Cache this so we can use it for applying with params.
			final Object[] values = {};

			for (final Slot<L> slot : bindings) {
				if (slot instanceof SelectiveSlot) {
					final SelectiveSlot<T, L> selectiveSlot = (SelectiveSlot<T, L>) slot;
					if (comparator.compare(selectiveSlot.getKey()))
						dispatchSlot0(selectiveSlot, values);
				} else
					dispatchSlot0(slot, values);
			}
		}
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @throws NullPointerException
	 *             if the comparator is null
	 * @throws IllegalAccessError
	 *             if the comparator is not of type
	 *             {@link SelectiveSignalComparator1}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public <A> void dispatch(A value0) throws Throwable {
		// If there is no comparator then we should just dispatch them all?
		if (null == _comparator)
			throw new NullPointerException("Comparator can not be null");
		else if (!(_comparator instanceof SelectiveSignalComparator1))
			throw new IllegalAccessError("Comparator must be a type of SelectiveSignalComparator1");
		else {
			final SelectiveSignalComparator1<T, A> comparator = (SelectiveSignalComparator1<T, A>) _comparator;

			// Cache this so we can use it for applying with params.
			final Object[] values = {value0};

			for (final Slot<L> slot : bindings) {
				if (slot instanceof SelectiveSlot) {
					final SelectiveSlot<T, L> selectiveSlot = (SelectiveSlot<T, L>) slot;
					if (comparator.compare(selectiveSlot.getKey(), value0))
						dispatchSlot1(selectiveSlot, value0, values);
				} else
					dispatchSlot1(slot, value0, values);
			}
		}
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @throws NullPointerException
	 *             if the comparator is null
	 * @throws IllegalAccessError
	 *             if the comparator is not of type
	 *             {@link SelectiveSignalComparator2}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public <A, B> void dispatch(A value0, B value1) throws Throwable {
		// If there is no comparator then we should just dispatch them all?
		if (null == _comparator)
			throw new NullPointerException("Comparator can not be null");
		else if (!(_comparator instanceof SelectiveSignalComparator2))
			throw new IllegalAccessError("Comparator must be a type of SelectiveSignalComparator2");
		else {
			final SelectiveSignalComparator2<T, A, B> comparator = (SelectiveSignalComparator2<T, A, B>) _comparator;

			// Cache this so we can use it for applying with params.
			final Object[] values = {value0, value1};

			for (final Slot<L> slot : bindings) {
				if (slot instanceof SelectiveSlot) {
					final SelectiveSlot<T, L> selectiveSlot = (SelectiveSlot<T, L>) slot;
					if (comparator.compare(selectiveSlot.getKey(), value0, value1))
						dispatchSlot2(selectiveSlot, value0, value1, values);
				} else
					dispatchSlot2(slot, value0, value1, values);
			}
		}
	}
}
