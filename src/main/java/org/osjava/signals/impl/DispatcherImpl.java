package org.osjava.signals.impl;

import java.lang.reflect.Method;
import java.util.List;

import org.osjava.signals.Dispatcher;
import org.osjava.signals.SignalListener;
import org.osjava.signals.SignalListener.SignalListener0;
import org.osjava.signals.SignalListener.SignalListener1;
import org.osjava.signals.SignalListener.SignalListener2;
import org.osjava.signals.Slot;

public final class DispatcherImpl<L extends SignalListener> implements Dispatcher<L> {

	private final List<Slot<L>> _bindings;

	private DispatcherImpl(List<Slot<L>> bindings) {
		_bindings = bindings;
	}

	public static <L extends SignalListener> Dispatcher<L> newInstance(final List<Slot<L>> bindings) {
		assert null != bindings : "Bindings can not be null";
		return new DispatcherImpl<L>(bindings);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean dispatch() {
		boolean result = true;
		
		for (final Slot<L> slot : _bindings) {
			// If it's not enable skip this
			if (!slot.getEnabled())
				continue;

			// Move through the following
			final SignalListener slotListener = slot.getListener();
			if (null == slotListener)
				continue;

			// See if the slot has any parameters
			final List<?> params = slot.getParams();
			if (null != params && params.size() > 0) {
				// Invoke method here
				try {
					// Get all the methods in the class using reflection
					Class<?> slotListenerClass = slotListener.getClass();
					Method[] slotListenerMethods = slotListenerClass.getDeclaredMethods();
					
					// Locate the current class type
					final Class<?> paramClassType = params.get(0).getClass();
					
					// Iterate through them and try and match it
					for (final Method slotMethod : slotListenerMethods) {
						Class<?>[] slotMethodParamTypes = slotMethod.getParameterTypes();

						// If the paramTypes length match the params size
						// then we can nail it down
						int numParamTypes = slotMethodParamTypes.length;
						if (numParamTypes == params.size()) {
							// Iterate through the methods parameters
							for (Class<?> slotMethodParamType : slotMethodParamTypes) {
								if (slotMethodParamType.equals(paramClassType)) {
									numParamTypes--;
								} else {
									// Exit out early, because we've not
									// matched.
									break;
								}
							}

							// Find out if the slot method isAccessible
							if (numParamTypes == 0) {
								if (!slotMethod.isAccessible()) {
									slotMethod.setAccessible(true);
								}
								// We have to make an Object[] hence the toArray method
								slotMethod.invoke(slotListener, params.toArray());
							}
						}
					}
				} catch (Exception e) {
					// Any exception we get, exit out of the dispatch quickly.
					result = false;
					break;
				} 
			} else {
				// Normal interface access
				if (slotListener instanceof SignalListener0) {
					final SignalListener0 listener = (SignalListener0) slotListener;
					if (slot.getOnce())
						slot.remove();
					if (null != listener)
						listener.apply();
				} else {
					result = false;
					break;
				}
			}
		}
		
		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws IllegalAccessException
	 */
	@Override
	@SuppressWarnings("unchecked")
	public <A> void dispatch(A value0) throws IllegalAccessException {
		for (Slot<L> slot : _bindings) {
			SignalListener slotListener = slot.getListener();
			if (null != slotListener) {
				if (slotListener instanceof SignalListener1) {
					SignalListener1<A> listener = (SignalListener1<A>) slotListener;
					if (slot.getEnabled()) {
						if (slot.getOnce())
							slot.remove();
						if (listener != null)
							listener.apply(value0);
					}
				} else
					throw new IllegalArgumentException();
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws IllegalAccessException
	 */
	@Override
	@SuppressWarnings("unchecked")
	public <A, B> void dispatch(A value0, B value1) throws IllegalAccessException {
		for (Slot<L> slot : _bindings) {
			SignalListener slotListener = slot.getListener();
			if (null != slotListener) {
				if (slotListener instanceof SignalListener2) {
					SignalListener2<A, B> listener = (SignalListener2<A, B>) slotListener;
					if (slot.getEnabled()) {
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
}
