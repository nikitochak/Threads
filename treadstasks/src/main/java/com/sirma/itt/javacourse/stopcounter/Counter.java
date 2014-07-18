package com.sirma.itt.javacourse.stopcounter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * Counts until changing the value of the boolean field stopRun to false. If
 * there is no change of the stopRun value stops automatically when reaches the
 * maximum value.
 * 
 * @author Nikolay Ch
 * 
 * 
 */
public class Counter extends Thread {
	private int counter=0;
	public static final Logger LOGG = LoggerFactory
			.getLogger(CounterTest.class);
	private final int maxValue;
	private boolean stopRun = true;

	/**
	 * Initializes the max value.
	 * 
	 * @param maxValue
	 *            the value
	 */
	public Counter(int maxValue) {
		this.maxValue = maxValue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		while (stopRun == true && maxValue >= counter) {
			counter++;
			LOGG.info(""+counter);
		}

	}

	/**
	 * Getter for the counter.
	 * 
	 * @return the value
	 */
	public int getCounter() {

		return this.counter;
	}

	/**
	 * Setter for the boolean field.
	 * 
	 * @param value
	 *            the value for the field
	 */
	public void setStopRun(boolean value) {
		this.stopRun = value;
	}
}
