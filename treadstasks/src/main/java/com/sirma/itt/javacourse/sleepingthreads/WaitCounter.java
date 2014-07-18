package com.sirma.itt.javacourse.sleepingthreads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Counts in an interval and after each count waits for 500 milliseconds.
 * 
 * @author Nikolay Ch
 */
public class WaitCounter extends Thread {
	private static final Logger LOGG = LoggerFactory
			.getLogger(WaitCounter.class);
	private int start;
	private int finish;

	private WaitCounter counter;

	/**
	 * Default constructor;
	 */
	public WaitCounter() {

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
	public WaitCounter(int start, int finish) {
		this.start = start;
		this.finish = finish;

	}

	/**
	 * Setter for the field counter which keeps the other counter.
	 * 
	 * @param counter
	 *            the value for the counter
	 */
	public void setCounter(WaitCounter counter) {
		this.counter = counter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	public void run() {

		LOGG.info(this.getName());
		for (; start <= finish; start++) {
			try {
				this.wait(500);
			} catch (Exception e) {

			}
			String toString = "";
			toString += start;
			LOGG.info(toString);

			if (start == finish) {
				LOGG.info(this.getName() + " stops " + counter.getName());
				counter.interrupt();
			}
		}
		LOGG.info("Izlizam ot " + this.getName());

	}

}
