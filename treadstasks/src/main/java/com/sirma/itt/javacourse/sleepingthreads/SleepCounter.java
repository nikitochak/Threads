package com.sirma.itt.javacourse.sleepingthreads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Counts in an interval and after each count sleeps for 500 milliseconds.
 * 
 * @author Nikolay Ch
 */
public class SleepCounter extends Thread {
	private static final Logger LOGG = LoggerFactory
			.getLogger(SleepCounter.class);
	private int start;
	private int finish;

	private SleepCounter counter;

	/**
	 * Default constructor;
	 */
	public SleepCounter() {

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
	public SleepCounter(int start, int finish) {
		this.start = start;
		this.finish = finish;

	}

	/**
	 * Setter for the field counter which keeps the other counter.
	 * 
	 * @param counter
	 *            the value for the counter
	 */
	public void setCounter(SleepCounter counter) {
		this.counter = counter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	public void run() {

		LOGG.info(this.getName());
		try {
			for (; start <= finish; start++) {
				Thread.sleep(500);
				String toString = "";
				toString += start;
				LOGG.info(toString);

				if (start == finish) {
					LOGG.info(this.getName() + " stops " + counter.getName());
					counter.interrupt();
				}
			}
		} catch (InterruptedException e) {

		}
		LOGG.info("Izlizam ot " + this.getName());

	}

}
