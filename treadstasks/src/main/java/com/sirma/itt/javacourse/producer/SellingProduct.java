package com.sirma.itt.javacourse.producer;

/**
 * The thread that sells the products in a storage.
 * 
 * @author Nikolay Ch
 * 
 */
public class SellingProduct extends Thread {
	private Storage store;
	private int time;

	/**
	 * Initializes the storage.
	 * 
	 * @param store
	 *            the value
	 */
	public SellingProduct(Storage store, int time) {
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
				store.sellProduct();
				sleep(time);
			}
		} catch (InterruptedException e) {

		}
	}
}
