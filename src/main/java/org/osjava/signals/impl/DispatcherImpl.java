package org.osjava.signals.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.osjava.signals.Dispatcher;
import org.osjava.signals.SignalListener;
import org.osjava.signals.SignalListener.SignalListener0;
import org.osjava.signals.SignalListener.SignalListener1;
import org.osjava.signals.SignalListener.SignalListener2;
import org.osjava.signals.SignalListener.SignalListener3;
import org.osjava.signals.SignalListener.SignalListener4;
import org.osjava.signals.SignalListener.SignalListener5;
import org.osjava.signals.Slot;

public class DispatcherImpl<L extends SignalListener> implements Dispatcher<L> {

	protected List<Slot<L>> bindings;

	protected DispatcherImpl(List<Slot<L>> bindings) {
		if (null == bindings)
			new AssertionError("Bindings can not be null");

		this.bindings = bindings;
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
		assert null != bindings : "Bindings can not be null";

		// Cache this so we can use it for applying with parameters.
		final Object[] values = {};

		for (final Slot<L> slot : bindings) {
			dispatchSlot0(slot, values);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws Throwable
	 */
	@Override
	public <A> void dispatch(A value0) throws Throwable {
		assert null != bindings : "Bindings can not be null";

		// Cache this so we can use it for applying with params.
		final Object[] values = { value0 };

		for (final Slot<L> slot : bindings) {
			dispatchSlot1(slot, value0, values);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws Throwable
	 */
	@Override
	public <A, B> void dispatch(A value0, B value1) throws Throwable {
		assert null != bindings : "Bindings can not be null";

		// Cache this so we can use it for applying with params.
		Object[] values = { value0, value1 };

		for (final Slot<L> slot : bindings) {
			dispatchSlot2(slot, value0, value1, values);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws Throwable
	 */
	@Override
	public <A, B, C> void dispatch(A value0, B value1, C value2) throws Throwable {
		assert null != bindings : "Bindings can not be null";

		// Cache this so we can use it for applying with params.
		Object[] values = { value0, value1, value2 };

		for (final Slot<L> slot : bindings) {
			dispatchSlot3(slot, value0, value1, value2, values);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws Throwable
	 */
	@Override
	public <A, B, C, D> void dispatch(A value0, B value1, C value2, D value3) throws Throwable {
		assert null != bindings : "Bindings can not be null";

		// Cache this so we can use it for applying with params.
		Object[] values = { value0, value1, value2, value3 };

		for (final Slot<L> slot : bindings) {
			dispatchSlot4(slot, value0, value1, value2, value3, values);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws Throwable
	 */
	@Override
	public <A, B, C, D, E> void dispatch(A value0, B value1, C value2, D value3, E value4)
			throws Throwable {
		assert null != bindings : "Bindings can not be null";

		// Cache this so we can use it for applying with params.
		Object[] values = { value0, value1, value2, value3, value4 };

		for (final Slot<L> slot : bindings) {
			dispatchSlot5(slot, value0, value1, value2, value3, value4, values);
		}
	}

	/**
	 * Dispatch the slot for SignalListener0
	 * 
	 * @param slot
	 *            to be used to execute the listener on
	 * @param values
	 *            the default values to enable additional parameters on
	 * @throws Throwable
	 * @throws {@link IllegalAccessError} if SlotListener does not implement
	 *         SignalListener0
	 */
	protected final void dispatchSlot0(final Slot<L> slot, final Object[] values) throws Throwable {
		final SignalListener slotListener = slot.getListener();
		if (slotListener instanceof SignalListener0) {

			// If it's not enable skip this
			if (slot.getEnabled()) {

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
			}
		} else
			throw new IllegalAccessError("SlotListener does not implement SignalListener0");
	}

	/**
	 * Dispatch the slot for SignalListener1
	 * 
	 * @param slot
	 *            to be used to execute the listener on
	 * @param value0
	 *            value to be executed on the interface
	 * @param values
	 *            the default values to enable additional parameters on
	 * @throws Throwable
	 * @throws {@link IllegalAccessError} if SlotListener does not implement
	 *         SignalListener1
	 */
	@SuppressWarnings("unchecked")
	protected final <A> void dispatchSlot1(final Slot<L> slot, final A value0, final Object[] values)
			throws Throwable {
		final SignalListener slotListener = slot.getListener();
		if (slotListener instanceof SignalListener1) {

			// If it's not enable skip this
			if (slot.getEnabled()) {
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
			}
		} else
			throw new IllegalAccessError("SlotListener does not implement SignalListener1");
	}

	/**
	 * Dispatch the slot for SignalListener2
	 * 
	 * @param slot
	 *            to be used to execute the listener on
	 * @param value0
	 *            value to be executed on the interface
	 * @param value1
	 *            value to be executed on the interface
	 * @param values
	 *            the default values to enable additional parameters on
	 * @throws Throwable
	 * @throws {@link IllegalAccessError} if SlotListener does not implement
	 *         SignalListener2
	 */
	@SuppressWarnings("unchecked")
	protected final <A, B> void dispatchSlot2(final Slot<L> slot, final A value0, B value1,
			final Object[] values) throws Throwable {
		final SignalListener slotListener = slot.getListener();
		if (slotListener instanceof SignalListener2) {

			// If it's not enable skip this
			if (slot.getEnabled()) {
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
			}
		} else
			throw new IllegalAccessError("SlotListener does not implement SignalListener2");
	}

	/**
	 * Dispatch the slot for SignalListener3
	 * 
	 * @param slot
	 *            to be used to execute the listener on
	 * @param value0
	 *            value to be executed on the interface
	 * @param value1
	 *            value to be executed on the interface
	 * @param value2
	 *            value to be executed on the interface
	 * @param values
	 *            the default values to enable additional parameters on
	 * @throws Throwable
	 * @throws {@link IllegalAccessError} if SlotListener does not implement
	 *         SignalListener3
	 */
	@SuppressWarnings("unchecked")
	protected final <A, B, C> void dispatchSlot3(final Slot<L> slot, final A value0, B value1,
			C value2, final Object[] values) throws Throwable {
		final SignalListener slotListener = slot.getListener();
		if (slotListener instanceof SignalListener3) {

			// If it's not enable skip this
			if (slot.getEnabled()) {
				// See if the slot has any parameters
				final List<?> params = slot.getParams();
				if (null != params && params.size() > 0) {
					invoke(slotListener, values, params);
				} else {
					// Normal interface access
					final SignalListener3<A, B, C> listener = (SignalListener3<A, B, C>) slotListener;
					if (slot.getOnce())
						slot.remove();
					if (null != listener)
						listener.apply(value0, value1, value2);
				}
			}
		} else
			throw new IllegalAccessError("SlotListener does not implement SignalListener3");
	}

	/**
	 * Dispatch the slot for SignalListener4
	 * 
	 * @param slot
	 *            to be used to execute the listener on
	 * @param value0
	 *            value to be executed on the interface
	 * @param value1
	 *            value to be executed on the interface
	 * @param value2
	 *            value to be executed on the interface
	 * @param value3
	 *            value to be executed on the interface
	 * @param values
	 *            the default values to enable additional parameters on
	 * @throws Throwable
	 * @throws {@link IllegalAccessError} if SlotListener does not implement
	 *         SignalListener4
	 */
	@SuppressWarnings("unchecked")
	protected final <A, B, C, D> void dispatchSlot4(final Slot<L> slot, final A value0, B value1,
			C value2, D value3, final Object[] values) throws Throwable {
		final SignalListener slotListener = slot.getListener();
		if (slotListener instanceof SignalListener4) {

			// If it's not enable skip this
			if (slot.getEnabled()) {
				// See if the slot has any parameters
				final List<?> params = slot.getParams();
				if (null != params && params.size() > 0) {
					invoke(slotListener, values, params);
				} else {
					// Normal interface access
					final SignalListener4<A, B, C, D> listener = (SignalListener4<A, B, C, D>) slotListener;
					if (slot.getOnce())
						slot.remove();
					if (null != listener)
						listener.apply(value0, value1, value2, value3);
				}
			}
		} else
			throw new IllegalAccessError("SlotListener does not implement SignalListener3");
	}

	/**
	 * Dispatch the slot for SignalListener4
	 * 
	 * @param slot
	 *            to be used to execute the listener on
	 * @param value0
	 *            value to be executed on the interface
	 * @param value1
	 *            value to be executed on the interface
	 * @param value2
	 *            value to be executed on the interface
	 * @param value3
	 *            value to be executed on the interface
	 * @param value4
	 *            value to be executed on the interface
	 * @param values
	 *            the default values to enable additional parameters on
	 * @throws Throwable
	 * @throws {@link IllegalAccessError} if SlotListener does not implement
	 *         SignalListener5
	 */
	@SuppressWarnings("unchecked")
	protected final <A, B, C, D, E> void dispatchSlot5(final Slot<L> slot, final A value0,
			B value1, C value2, D value3, E value4, final Object[] values) throws Throwable {
		final SignalListener slotListener = slot.getListener();
		if (slotListener instanceof SignalListener5) {

			// If it's not enable skip this
			if (slot.getEnabled()) {
				// See if the slot has any parameters
				final List<?> params = slot.getParams();
				if (null != params && params.size() > 0) {
					invoke(slotListener, values, params);
				} else {
					// Normal interface access
					final SignalListener5<A, B, C, D, E> listener = (SignalListener5<A, B, C, D, E>) slotListener;
					if (slot.getOnce())
						slot.remove();
					if (null != listener)
						listener.apply(value0, value1, value2, value3, value4);
				}
			}
		} else
			throw new IllegalAccessError("SlotListener does not implement SignalListener3");
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
