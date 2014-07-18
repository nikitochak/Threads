package com.sirma.itt.javacourse.twocounters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * Counts from one number to another. The same as the previous task but keeps an
 * instance of the same class and if its counter is equal to the last position
 * of the interval stops the process in that instance.
 * 
 * @author Nikolay Ch
 * 
 * 
 */
public class Counter extends Thread {
	private static final Logger LOGG = LoggerFactory.getLogger(Counter.class);
	private int start;
	private int finish;

	private Counter counter;

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
	 * 
	 */
	public Counter(int start, int finish) {
		this.start = start;
		this.finish = finish;

	}

	/**
	 * Setter for the counter field.
	 * 
	 * @param counter
	 *            the value for the counter
	 */
	public void setCounter(Counter counter) {
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
				Thread.sleep(0);
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
