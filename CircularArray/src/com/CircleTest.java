package com;

import java.util.Iterator;

public class CircleTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularArray<Integer> array = new CircularArray<Integer> (10);
		array.set(0, 10);
		array.set(1, 20);
		try {
			System.out.println("First element" + array.get(0));

		array.rotate(1);
		System.out.println("First element after rotate" + array.get(0));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator<Integer> itr = array.getIterator();
		while(itr.hasNext()) {
			System.out.println("Item:" + itr.next());
		}

	}

}
