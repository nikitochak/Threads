package com.sirma.itt.javacourse.stopcounter;

import org.junit.Test;

/**
 * Tests the counter class.
 * 
 * @author Nikolay Ch
 * 
 */
public class CounterTest {

	/**
	 * Tests the stop of the thread.
	 */
	@Test
	public void testRun() {
		Counter counter = new Counter(12);
		counter.start();

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {

		}

		counter.setStopRun(false);

	}

}
