package com.sirma.itt.javacourse.producer;

/**
 * The thread that produces products in a storage.
 * 
 * @author Nikolay Ch
 * 
 */
public class ProducingProducts extends Thread {
	private Storage store;
	private int time;

	/**
	 * Initializes the storage.
	 * 
	 * @param store
	 *            the value
	 */
	public ProducingProducts(Storage store, int time) {
		this.store = store;
		this.time = time;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		try {
			while (true) {
				store.produceProduct();
				sleep(time);
			}
		} catch (InterruptedException e) {

			
		}
	}
}
