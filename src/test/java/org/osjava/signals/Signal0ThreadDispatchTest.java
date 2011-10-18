package org.osjava.signals;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.osjava.signals.Signal0.SignalListener0;
import org.osjava.signals.impl.SignalImpl0;

public class Signal0ThreadDispatchTest extends SignalThreadTest {

	private Signal0 signal;

	@Before
	public void setUp() {
		signal = SignalImpl0.newInstance();
	}

	@After
	public void tearDown() {
		signal.removeAll();
	}
	
	@Test
	public void test_adding_two_listeners_in_two_threads_and_dispatching()
			throws InterruptedException, ExecutionException {
		testDispatchWithMultipleThreads(2);
	}

	@Test
	public void test_adding_two_listeners_in_four_threads_and_dispatching()
			throws InterruptedException, ExecutionException {
		testDispatchWithMultipleThreads(4);
	}

	private void testDispatchWithMultipleThreads(final int threadCount)
			throws InterruptedException, ExecutionException {
		testDispatchWithMultipleThreads(threadCount, false);
	}

	private void testDispatchWithMultipleThreads(final int threadCount, final boolean isOnce)
			throws InterruptedException, ExecutionException {
		Callable<SignalDispatchRunnable> task = new Callable<SignalDispatchRunnable>() {
			public SignalDispatchRunnable call() throws Exception {
				final SignalDispatchListener listener = new SignalDispatchListener();

				if (isOnce) {
					signal.addOnce(listener);
				} else {
					signal.add(listener);
				}

				listener.setNumListeners(signal.getNumListeners());

				SignalDispatchRunnable runnable = listener.getRunnable();

				ExecutorService executor = Executors.newSingleThreadExecutor();
				executor.execute((Runnable) runnable);
				executor.shutdown();

				return runnable;
			}
		};

		testDispatchWithMultipleThreads(signal, task, threadCount);
	}

	private class SignalDispatchListener implements SignalListener0 {

		private final SignalDispatchRunnable _runnable = new SignalDispatchRunnableImpl();

		private int _numListeners;

		public SignalDispatchListener() {
		}

		public void setNumListeners(int numListeners) {
			_numListeners = numListeners;
		}

		@Override
		public void apply() {
			_runnable.setNumListeners(_numListeners);
		}

		public SignalDispatchRunnable getRunnable() {
			return _runnable;
		}

		private class SignalDispatchRunnableImpl implements Runnable, SignalDispatchRunnable {

			private int _numListeners = -1;

			public SignalDispatchRunnableImpl() {
			}

			public int getNumListeners() {
				return _numListeners;
			}

			public void setNumListeners(final int numListeners) {
				_numListeners = numListeners;
			}

			@Override
			public void run() {
				for (;;) {
					if (_numListeners >= 0)
						break;
				}
			}
		}
	}
}
