package com.practice;

/**
 * @author dshah
 * @since 
 */
public class MaxSequenceSum {

	public static void main(String[] args) {
		
		int[] arrayValues = {10,4,5,-1,20,15};
		
		int maxSum = maxSum(arrayValues);
		System.out.println(maxSum);
	}
	
	public static int maxSum(int[] arrayValues) {
		int sum = 0;
		int i;
		int start = 0, end = 0;
		for(i = 0; i < arrayValues.length; i++) {
			sum += arrayValues[i];
			if(sum < 0) {
				sum = 0;
				start = i + 1;
			}
		}
		end = i - 1;
		
		System.out.println("Start is " +start+ " and end is " +end);
		return sum;
	}
}
