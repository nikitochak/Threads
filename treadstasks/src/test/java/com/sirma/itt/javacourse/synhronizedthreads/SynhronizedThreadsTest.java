package com.sirma.itt.javacourse.synhronizedthreads;

import org.junit.Test;

/**
 * Tests the synchronized threads.
 * 
 * @author Nikolay Ch
 * 
 */
public class SynhronizedThreadsTest {

	/**
	 * Tests the running method.
	 * 
	 * @throws InterruptedException
	 *             when a thread is interrupted.
	 */
	@Test
	public void testRun() throws InterruptedException {
		int start = 1;
		int finish = 5;
		CounterHelper counter = new CounterHelper();
		Counter counter1 = new Counter(start, finish, counter);
		Counter counter2 = new Counter(start, 10, counter);

		counter1.setName("First");
		counter2.setName("Second");

		counter1.start();
		counter2.start();

		counter1.join(20);
		counter2.join();
	}

}
