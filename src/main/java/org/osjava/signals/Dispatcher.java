package org.osjava.signals;

public interface Dispatcher<L extends SignalListener> {

	public void dispatch() throws Throwable;

	public <A> void dispatch(A value0) throws Throwable;

	public <A, B> void dispatch(A value0, B value1) throws Throwable;

	public <A, B, C> void dispatch(A value0, B value1, C value2) throws Throwable;

	public <A, B, C, D> void dispatch(A value0, B value1, C value2, D value3) throws Throwable;

	public <A, B, C, D, E> void dispatch(A value0, B value1, C value2, D value3, E value4)
			throws Throwable;
}
