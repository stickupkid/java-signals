package org.osjava.signals;


public interface Dispatcher<L extends SignalListener> {

	public void dispatch();

	public <A> void dispatch(A value0);

	public <A, B> void dispatch(A value0, B value1);
}
