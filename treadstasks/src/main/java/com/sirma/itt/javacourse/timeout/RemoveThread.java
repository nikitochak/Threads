package com.sirma.itt.javacourse.timeout;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Thread which iterates through a map and removes the value if the time for
 * exist of it value has finished. The thread is started until the map is empty.
 * 
 * @author Nikolay Ch
 * 
 */
public class RemoveThread extends Thread {
	private static final Logger LOG = LoggerFactory
			.getLogger(RemoveThread.class);
	private final int millisecExistance;
	private TimeOutHashTable table = new TimeOutHashTable();

	/**
	 * The user sets the time.
	 * 
	 * @param time
	 *            the milliseconds for existance
	 */
	public RemoveThread(int time) {
		this.millisecExistance = time;
	}

	/**
	 * By default sets the existing time to be zero milliseconds.
	 */
	public RemoveThread() {
		this.millisecExistance = 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		List<String> list = new ArrayList<String>();

		while (!table.getTimes().isEmpty()) {
			int br = 0;
			list.clear();
			for (Entry<String, Long> entry : table.getTimes().entrySet()) {

				if (System.currentTimeMillis() >= entry.getValue()
						+ millisecExistance) {
					LOG.info(" "+table.getObjects().get(entry.getKey()));
					list.add(entry.getKey());
					br++;
				}
			}

			for (int i = 0; i < br; i++) {
				String key = list.get(i);
				LOG.info("Remove " + key);
				table.getObjects().remove(key);
				table.getTimes().remove(key);
			}
		}

	}

	/**
	 * Getter for the table.
	 * 
	 * @return the table
	 */
	public TimeOutHashTable getTable() {
		return table;
	}

}
