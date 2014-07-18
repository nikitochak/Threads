package com.sirma.itt.javacourse.stopcounter;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Tests the counter class.
 * 
 * @author Nikolay Ch
 * 
 */
public class CounterTest {
	public static final Logger LOGG = LoggerFactory
			.getLogger(CounterTest.class);

	/**
	 * Tests the stop of the thread.
	 */
	@Test
	public void testRun() {
		Counter counter = new Counter(123412431);
		counter.start();
		int i;
		int toWhere = (int) (Math.random() * 312344312 + 31241);
		for (i = 0; i < toWhere; i++)
			;

		counter.setStopRun(false);

		LOGG.info(counter.getCounter() + " " + toWhere);

	}

}
