package com.sirma.itt.javacourse.synchronizedstack;

/**
 * Class with fields and their getters and setters.
 * 
 * @author Nikolay Ch
 * 
 */
public class Data {
	private int number;
	private String name;

	/**
	 * Initializes the fields.
	 * 
	 * @param num
	 *            the value for the field number
	 * @param name
	 *            the value for the field name
	 */
	public Data(int num, String name) {
		this.number = num;
		this.name = name;
	}

	/**
	 * Setter for the field name.
	 * 
	 * @param name
	 *            the value for the field
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Setter for the number field.
	 * 
	 * @param number
	 *            the value for the field number
	 */
	public void setNum(int number) {
		this.number = number;
	}

	/**
	 * Getter for the number field.
	 * 
	 * @return the value of the field
	 */
	public int getNum() {
		return this.number;
	}

	/**
	 * Getter for the name value.
	 * 
	 * @return the value in name field
	 */
	public String getName() {
		return this.name;
	}

}