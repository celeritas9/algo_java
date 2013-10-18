package com.sort;

/**
 * 
 *
 * @author dshah
 * @since 
 */
public class SelectionSort {

	public static void main(String[] args) {
		int[] toSort = {5,4,3,2,1};
		
		selectionSort(toSort);
		int a = 23;
		System.out.println(Byte.parseByte(String.valueOf(a)));
	}

	/**
	 * @param toSort
	 */
	private static int[] selectionSort(int[] toSort) {
		int [] sortedArray = new int[toSort.length];
		
		for(int i = 0; i < toSort.length - 1; i++) {
			int minI = i;
			for(int j = i + 1; j < toSort.length; j++) {
				
			}
		}
		
		return sortedArray;
	}
}
