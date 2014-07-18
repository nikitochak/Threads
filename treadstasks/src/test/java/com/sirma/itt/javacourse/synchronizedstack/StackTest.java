package com.sirma.itt.javacourse.synchronizedstack;

import org.junit.Test;

/**
 * Tests the synchronized stack.
 * 
 * @author Nikolay Ch
 * 
 */
public class StackTest {

	/**
	 * Makes a thread for inserting an element and one for removing an element.
	 * At first start the thread for removing which must wait until the other
	 * thread insert a new element.
	 * 
	 * @throws InterruptedException
	 *             if the thread is interrupted
	 */
	@Test
	public void testRun() throws InterruptedException {
		AddElement add = new AddElement();
		RemoveElement remove = new RemoveElement();
		add.setName("Add");
		remove.setName("Remove");
		List list = new List(10);
		Data data = new Data(5, "Ivan");
		remove.setList(list);
		add.setList(list);

		add.inserValue(data);

		remove.start();
		add.start();
		add.join(435);
	}

}
