package com.sirma.itt.javacourse.synhronizedthreads;

/**
 * Has à method for setting à thread to wait.
 * 
 * @author Nikolay Ch
 * 
 */
public class CounterHelper {
	/**
	 * Sets the thread to waits until its notified by another thread or if 500
	 * milliseconds pass.
	 * 
	 * @param connect
	 *            if true the thread is set to wait
	 * @throws InterruptedException
	 *             if the thread is interrupted
	 */
	synchronized void firstWait(boolean connect) throws InterruptedException {
		if (!connect) {
			notify();
			return;
		}

		notify();

		wait(500);
	}

}
