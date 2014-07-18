package com.sirma.itt.javacourse.timeout;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Has to tables and methods for inserting in them. The first keeps the objects
 * and the second keeps the time when the object has been added.
 * 
 * @author Nikolay Ch
 * 
 */
public class TimeOutHashTable {
	private static final Logger LOG = LoggerFactory.getLogger(TimeOutHashTable.class);
	private final int MAX_CAPACITY = 10;
	private Map<String, Object> keepObject = new HashMap<String, Object>(
			MAX_CAPACITY);
	private Map<String, Long> keepTime = new HashMap<String, Long>(MAX_CAPACITY);

	/**
	 * Getter for the map with the objects.
	 * 
	 * @return the map
	 */
	public Map<String, Object> getObjects() {
		return this.keepObject;
	}

	/**
	 * Adds new object to the map. If there is already object with that key
	 * replaces it with the new value.
	 * 
	 * @param key
	 *            the key for the value
	 * @param object
	 *            the value
	 */
	public void add(String key, Object object) {
		LOG.info("Inserting new object");
		if (keepObject.containsKey(key)) {
			LOG.info("The old time of the object is "
					+ keepTime.get(key));
			keepObject.replace(key, object);
			keepTime.replace(key, System.currentTimeMillis());
			LOG.info("The new time is " + keepTime.get(key));
		} else {
			keepObject.put(key, object);
			keepTime.put(key, System.currentTimeMillis());
		}
	}

	/**
	 * Gets an object by its key and updates its time.
	 * 
	 * @param key
	 *            the key
	 * @return the object
	 */
	public Object get(String key) {
		if (keepTime.containsKey(key)) {
			keepTime.replace(key, System.currentTimeMillis());
			LOG.info("Getting an object. The time is "
					+ keepTime.get(key));
		}

		return keepObject.get(key);
	}

	/**
	 * If there is an object with that key removes it.
	 * 
	 * @param key
	 *            the key for the object
	 */
	public void remove(String key) {
		if (keepTime.containsKey(key)) {
			keepTime.remove(key);
			keepObject.remove(key);
			LOG.info("Removing the object by its key");
		}
	}

	/**
	 * Getter for the table which keeps the times.
	 * 
	 * @return the table
	 */
	public Map<String, Long> getTimes() {
		return keepTime;
	}

}
