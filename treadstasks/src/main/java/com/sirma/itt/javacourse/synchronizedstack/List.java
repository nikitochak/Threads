package com.sirma.itt.javacourse.synchronizedstack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * Makes an List of objects and some methods for adding new element,removing and
 * printing all the elements.
 * 
 * @author Nikolay Ch
 * 
 */
public class List {
	private static final Logger LOGG = LoggerFactory.getLogger(List.class);
	private int size;
	public Data[] list = new Data[10];
	private int toWhere = 0;

	/**
	 * Constructor for the class which makes the first element of the list null.
	 */
	public List() {
		size = 0;
	}

	public List(int size) {
		this.size = size;
		toWhere = 0;
	}

	/**
	 * Inserts new data in the end of the list.If it is full, throw new
	 * exception. If the current index is equal to the size waits until another
	 * thread removes an element.
	 * 
	 * @param data
	 *            the data we want to insert
	 * @throws InterruptedException
	 *             when the thread is interrupted
	 */
	synchronized public void add(Data data) throws InterruptedException {

		while (toWhere == size) {
			LOGG.info("Waiting to remove.");
			wait();
		}
		LOGG.info("Inserting new element");
		list[toWhere] = data;
		toWhere++;
		notify();

	}

	/**
	 * Removes the last of the list if it is not empty. If it is empty waits
	 * until another thread inserts new element and then removes it.
	 * 
	 * @throws InterruptedException
	 *             when the thread is interrupted
	 * 
	 */
	synchronized public void remove() throws InterruptedException {

		while (toWhere == 0) {
			LOGG.info("Waiting fot inserting .");
			wait();
		}
		LOGG.info("Removeing last element.");
		toWhere--;
		notify();
	}

	/**
	 * Prints the elements of the list.
	 */
	public void print() {
		for (int i = 0; i < toWhere; i++) {
			LOGG.info(i + "the number" + list[i].getNum() + " the name "
					+ list[i].getName());

		}
		if (toWhere == 0)
			LOGG.info("Out.");
	}

	/**
	 * @return true if the list is empty
	 */
	public boolean isEmpty() {
		return toWhere == 0;
	}

	/**
	 * 
	 * @return true if the list is full
	 */
	public boolean isFull() {
		return toWhere == size;
	}
}
