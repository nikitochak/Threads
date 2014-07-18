package com.sirma.itt.javacourse.producer;

import org.junit.Test;

/**
 * Tests the methods in the storage.
 * 
 * @author Nikolay Ch
 * 
 */
public class StorageTest {

	/**
	 * Tests the selling and producing a product in the storage.
	 * 
	 * @throws InterruptedException
	 *             if the thread is interrupted
	 */
	@Test
	public void testProduce() throws InterruptedException {
		Storage store = new Storage();
		SellingProduct sell = new SellingProduct(store, 400);
		sell.setName("Seller");
		ProducingProducts producer = new ProducingProducts(store, 500);
		producer.setName("Producer");

		sell.start();
		producer.start();

		Thread.sleep(1000);

		producer.interrupt();
		sell.interrupt();

	}

}
