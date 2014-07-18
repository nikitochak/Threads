package com.sirma.itt.javacourse.synhronizedthreads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Counter extends Thread {
	private static final Logger LOGG = LoggerFactory.getLogger(Counter.class);
	private int start;
	private int finish;
	boolean connect = true;
	CounterHelper helper = new CounterHelper();

	/**
	 * Default constructor;
	 */
	public Counter() {

	}

	/**
	 * Initializes the fields.
	 * 
	 * @param start
	 *            the start position
	 * @param finish
	 *            the finish position
	 * @param counter
	 *            the thread that it has to stop
	 */
	public Counter(int start, int finish, CounterHelper counterHelper) {
		this.start = start;
		this.finish = finish;
		this.helper = counterHelper;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	public void run() {

			for (; start <= finish; start++) {
				String toString = "";
				toString += start;
				LOGG.info("The count in " + this.getName() + " is " + toString);

				try {

					helper.firstWait(true);

				} catch (InterruptedException e) {

					e.printStackTrace();
				}
			}

		

	}
}
