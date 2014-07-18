package com.sirma.itt.javacourse.timeout;

import java.util.Map.Entry;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Tests the time out hash table class.
 * 
 * @author Nikolay Ch
 * 
 */
public class TimeOutTest {
	private static final Logger LOG = LoggerFactory
			.getLogger(TimeOutHashTable.class);

	/**
	 * Makes a thread that removes elements from a map if their time for exist
	 * is passed. Sets some elements in the table by different time and starts
	 * the thread.
	 * 
	 * @throws InterruptedException
	 *             if the thread is interrupted
	 */
	@Test
	public void test() throws InterruptedException {
		RemoveThread thread = new RemoveThread(1000);
		thread.setName("RemoveThread");
		thread.getTable().add("second", "second");
		thread.getTable().add("first", "first");

		thread.getTable().add("third", "third");
		thread.getTable().add("second", "second");

		Thread.sleep(40);

		thread.getTable().get("first");

		for (Entry<String, Long> entry : thread.getTable().getTimes()
				.entrySet()) {
			LOG.info(entry.getKey() + " / " + entry.getValue());
		}

		thread.start();
		thread.join();

	}
}
