package org.osjava.signals;

public interface SignalDispatchRunnable {
	public int getNumListeners();

	public void setNumListeners(final int numListeners);
}
