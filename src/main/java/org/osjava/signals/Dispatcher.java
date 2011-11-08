package org.osjava.signals;



public interface Dispatcher<L extends SignalListener> {

	public boolean dispatch() throws Throwable;

	public <A> void dispatch(A value0) throws IllegalAccessException;

	public <A, B> void dispatch(A value0, B value1) throws IllegalAccessException;
}
