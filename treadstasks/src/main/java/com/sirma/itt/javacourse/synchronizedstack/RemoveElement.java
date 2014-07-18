package com.sirma.itt.javacourse.synchronizedstack;

/**
 * Thread which deletes last element of a list.
 * 
 * @author Nikolay Ch
 * 
 */
public class RemoveElement extends Thread {

	private List list;

	/**
	 * 
	 * Setter for the list from which to delete.
	 * 
	 * @param list
	 *            the list
	 */
	public void setList(List list) {
		this.list = list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		try {

			list.remove();

		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

}
