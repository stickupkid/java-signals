package org.osjava.signals;



public interface Dispatcher<L extends SignalListener> {

	public void dispatch() throws Throwable;

	public <A> void dispatch(A value0) throws Throwable;

	public <A, B> void dispatch(A value0, B value1) throws Throwable;
}
