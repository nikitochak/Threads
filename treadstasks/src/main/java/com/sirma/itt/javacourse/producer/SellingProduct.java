package com.sirma.itt.javacourse.producer;

/**
 * The thread that sells the products in a storage.
 * 
 * @author Nikolay Ch
 * 
 */
public class SellingProduct extends Thread {
	private Storage store;

	/**
	 * Initializes the storage.
	 * 
	 * @param store
	 *            the value
	 */
	public SellingProduct(Storage store) {
		this.store = store;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		try {
			store.sellProduct();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
}
