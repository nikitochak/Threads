package com.sirma.itt.javacourse.twocounters;

import org.junit.Test;

/**
 * Tests the Counter class. If the one of the threads has finished its counting
 * that it must stop the other one.
 * 
 * @author Nikolay Ch
 * 
 */
public class TwoCountersTest {

	/**
	 * Makes the two threads and starts them. Tests if the first finishes the
	 * second would stop àss well.
	 * 
	 * @throws InterruptedException
	 *             if the thread is interrupted
	 */
	@Test
	public void test() throws InterruptedException {
		Counter thread1;
		Counter thread2;
		thread1 = new Counter(1, 4);
		thread2 = new Counter(1, 5);

		thread1.setCounter(thread2);
		thread2.setCounter(thread1);

		thread1.setName("First");
		thread2.setName("Second");

		thread1.start();
		thread2.start();

		thread1.join();
		thread2.join();

	}

}
