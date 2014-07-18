package com.sirma.itt.javacourse.synchronizedstack;

/**
 * The thread for inserting data in the list.
 * 
 * @author Nikolay Ch
 * 
 */
public class AddElement extends Thread {

	private Data valueToPut;
	private List theList;

	/**
	 * Setter for the list.
	 * 
	 * @param list
	 *            the list
	 */
	public void setList(List list) {
		this.theList = list;
	}

	/**
	 * Insert some data.
	 * 
	 * @param data
	 *            the object for inserting
	 */
	public void inserValue(Data data) {
		this.valueToPut = data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	public void run() {

		try {
			theList.add(valueToPut);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
