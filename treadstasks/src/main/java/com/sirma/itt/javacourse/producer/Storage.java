package com.sirma.itt.javacourse.producer;

import java.util.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents a storage, which has a method for producing and selling products.
 * 
 * @author Nikolay Ch
 * 
 */
public class Storage {
	private static final Logger LOGG = LoggerFactory.getLogger(Storage.class);
	private final int MAX_CAPACITY = 10;
	private Stack<Object> store;
	private int toWhere;

	/**
	 * Initializes the list and its index.
	 */
	public Storage() {
		store = new Stack<Object>();
		toWhere = 0;
	}

	/**
	 * Produces a Product and puts it into the storage only if the storage is
	 * not full.
	 * 
	 * @throws InterruptedException
	 *             if the thread is interrupted
	 */
	synchronized public void produceProduct() throws InterruptedException {
		while (toWhere == MAX_CAPACITY) {
			LOGG.info("Waiting to sell a product.");
			wait();
		}

		LOGG.info("Producing a product.");
		Product product = new Product();
		store.add(product);
		toWhere++;
		notify();
	}

	/**
	 * Removes the last element in the storage if there is at least one product.
	 * 
	 * @throws InterruptedException
	 *             if the thread is interrupted
	 */
	synchronized public void sellProduct() throws InterruptedException {
		while (toWhere == 0) {
			LOGG.info("Waiting to produce a product.");
			wait();
		}
		LOGG.info("Selling a product.");
		toWhere--;
		store.remove(toWhere);

		notify();
	}

}
