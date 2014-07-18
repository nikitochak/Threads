package com.sirma.itt.javacourse.sleepingthreads;

import org.junit.Test;

/**
 * Tests the Waiting and the waiting of a thread. The threads of the previous
 * task are used.
 * 
 * @author Nikolay Ch
 * 
 */
public class SleepAndWaitTest {

	/**
	 * Tests the sleeping of a thread.
	 * 
	 * @throws InterruptedException
	 *             when a thread is interrupted
	 */
	@Test
	public void testSleep() throws InterruptedException {

		SleepCounter firstCounter = new SleepCounter(3, 34);
		SleepCounter secondCounter = new SleepCounter(1, 4);

		firstCounter.setName("First");
		secondCounter.setName("Second");

		firstCounter.setCounter(secondCounter);
		secondCounter.setCounter(firstCounter);

		firstCounter.start();
		secondCounter.start();

		firstCounter.join();
		secondCounter.join();

	}

	/**
	 * Tests the waiting of a thread.
	 * 
	 * @throws InterruptedException
	 *             if the thread is interrupted
	 */
	@Test
	public void testWait() throws InterruptedException {

		WaitCounter waitCounter = new WaitCounter(3, 34);
		WaitCounter wait2Counter = new WaitCounter(1, 4);

		waitCounter.setName("First");
		wait2Counter.setName("Second");

		waitCounter.setCounter(wait2Counter);
		wait2Counter.setCounter(waitCounter);

		waitCounter.start();
		wait2Counter.start();

		waitCounter.join();
		wait2Counter.join();

	}

}
