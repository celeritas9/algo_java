/**
 * 
 */
package com.test;

import java.util.BitSet;

/**
 * @author dshah
 *
 */
public class TestBitSet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BitSet set = new BitSet();
		set.set(2);
		set.set(4);
		set.set(5);
		
		int index = 3;
		System.out.println("cardinality:" +set.cardinality());
		System.out.println("nextSetBit: " +set.nextSetBit(index));
	}

}
