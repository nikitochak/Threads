package com.sirma.itt.javacourse.producer;

/**
 * The thread that produces products in a storage.
 * 
 * @author Nikolay Ch
 * 
 */
public class ProducingProducts extends Thread {
	private Storage store;

	/**
	 * Initializes the storage.
	 * 
	 * @param store
	 *            the value
	 */
	public ProducingProducts(Storage store) {
		this.store = store;
	}

	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		try {
			store.produceProduct();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
}
