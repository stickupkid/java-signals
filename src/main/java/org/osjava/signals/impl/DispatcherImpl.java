package org.osjava.signals.impl;

import java.lang.reflect.InvocationTargetException;
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
	 * 
	 * @throws Throwable
	 */
	@Override
	public void dispatch() throws Throwable {
		assert null != _bindings : "Bindings can not be null";

		// Cache this so we can use it for applying with params.
		Object[] values = {};

		for (final Slot<L> slot : _bindings) {
			final SignalListener slotListener = slot.getListener();
			if (slotListener instanceof SignalListener0) {

				// If it's not enable skip this
				if (!slot.getEnabled())
					continue;

				// See if the slot has any parameters
				final List<?> params = slot.getParams();
				if (null != params && params.size() > 0) {
					invoke(slotListener, values, params);
				} else {
					// Normal interface access
					final SignalListener0 listener = (SignalListener0) slotListener;
					if (slot.getOnce())
						slot.remove();
					if (null != listener)
						listener.apply();
				}
			} else
				throw new IllegalAccessError("SlotListener does not implement SignalListener0");
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws IllegalAccessException
	 */
	@Override
	@SuppressWarnings("unchecked")
	public <A> void dispatch(A value0) throws Throwable {
		assert null != _bindings : "Bindings can not be null";

		// Cache this so we can use it for applying with params.
		Object[] values = { value0 };

		for (final Slot<L> slot : _bindings) {
			final SignalListener slotListener = slot.getListener();
			if (slotListener instanceof SignalListener1) {

				// If it's not enable skip this
				if (!slot.getEnabled())
					continue;

				// See if the slot has any parameters
				final List<?> params = slot.getParams();
				if (null != params && params.size() > 0) {
					invoke(slotListener, values, params);
				} else {
					// Normal interface access
					final SignalListener1<A> listener = (SignalListener1<A>) slotListener;
					if (slot.getOnce())
						slot.remove();
					if (null != listener)
						listener.apply(value0);
				}
			} else
				throw new IllegalAccessError("SlotListener does not implement SignalListener1");
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws IllegalAccessException
	 */
	@Override
	@SuppressWarnings("unchecked")
	public <A, B> void dispatch(A value0, B value1) throws Throwable {
		assert null != _bindings : "Bindings can not be null";

		// Cache this so we can use it for applying with params.
		Object[] values = { value0, value1 };

		for (final Slot<L> slot : _bindings) {
			final SignalListener slotListener = slot.getListener();
			if (slotListener instanceof SignalListener2) {

				// If it's not enable skip this
				if (!slot.getEnabled())
					continue;

				// See if the slot has any parameters
				final List<?> params = slot.getParams();
				if (null != params && params.size() > 0) {
					invoke(slotListener, values, params);
				} else {
					// Normal interface access
					final SignalListener2<A, B> listener = (SignalListener2<A, B>) slotListener;
					if (slot.getOnce())
						slot.remove();
					if (null != listener)
						listener.apply(value0, value1);
				}
			} else
				throw new IllegalAccessError("SlotListener does not implement SignalListener1");
		}
	}

	/**
	 * Specifies the value of slotListener to be used within any function that
	 * is executed. This method also specifies the parameters to be passed to
	 * any called listener.
	 * 
	 * @param slotListener
	 *            SignalListener to apply the parameters to.
	 * @param values
	 *            List of non-optional parameters to pass
	 * @param params
	 *            List of parameters to pass
	 * @throws Throwable
	 *             throws the internal exception if when invoke is called.
	 */
	private void invoke(final SignalListener slotListener, final Object[] values,
			final List<?> params) throws Throwable {

		assert null != slotListener : "SignalListener can not be null";
		assert null != values : "Non-optional parameters can not be null";
		assert null != params : "Optional parameters can not be null";

		try {
			// Invoke method here
			// Get all the methods in the class using reflection
			Class<?> slotListenerClass = slotListener.getClass();
			Method[] slotListenerMethods = slotListenerClass.getDeclaredMethods();

			// Locate the current class type
			final Class<?> paramClassType = params.get(0).getClass();

			boolean valid = false;

			// Iterate through them and try and match it
			for (final Method slotMethod : slotListenerMethods) {
				Class<?>[] slotMethodParamTypes = slotMethod.getParameterTypes();

				// If the paramTypes length match the params size
				// then we can nail it down
				int numParamTypes = slotMethodParamTypes.length;

				final int total = params.size() + values.length;
				if (numParamTypes == total) {
					// Iterate through the methods parameters
					for (int i = values.length; i < total; i++) {
						Class<?> slotMethodParamType = slotMethodParamTypes[i];
						// TODO : Workout the boxed and unboxed versions i.e.
						// Integer = int
						if (slotMethodParamType.equals(paramClassType)) {
							numParamTypes--;
						} else {
							// Exit out early, because we've not
							// matched.
							break;
						}
					}

					// Find out if the slot method isAccessible
					if (numParamTypes == values.length) {
						if (!slotMethod.isAccessible()) {
							slotMethod.setAccessible(true);
						}

						// We have to make an Object[] to call the invoke method
						// hence the toArray. Ideally we could keep it all a
						// type of List<T> but this won't allow it
						// To top it off we have to concat to Object[]s
						// together...
						Object[] optionalParams = params.toArray();
						Object[] allParams = concat(values, optionalParams);
						
						// Invoke it!
						slotMethod.invoke(slotListener, allParams);
						valid = true;
						break;
					}
				}
			}

			if (!valid) {
				throw new IllegalAccessError("No method found with associated parameters");
			}
		} catch (InvocationTargetException e) {
			// Re-throw the cause of the exception, otherwise the
			// InvocationTargetException will swallow all exceptions that where
			// thrown inside the method
			throw e.getTargetException();
		}
	}

	/**
	 * Method to concat two different arrays into one.
	 * 
	 * @param a
	 *            array of Object[]
	 * @param b
	 *            array of Object[]
	 * @return a concat of both a and b, or in some cases just a or b if either
	 *         one is empty.
	 */
	private Object[] concat(Object[] a, Object[] b) {
		// We don't need to concat if the items are already 0
		final int aLength = a.length;
		if (aLength == 0)
			return b;

		final int bLength = b.length;
		if (bLength == 0)
			return a;

		final Object[] result = new Object[aLength + bLength];

		// Insert the items into the array
		System.arraycopy(a, 0, result, 0, aLength);
		System.arraycopy(b, 0, result, aLength, bLength);

		return result;
	}
}
