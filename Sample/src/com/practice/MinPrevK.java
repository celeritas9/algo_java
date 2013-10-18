/*
 * This code is a protected work and subject to domestic and international
 * copyright law(s).  A complete listing of authors of this work is readily
 * available.  Additionally, source code is, by its very nature, confidential
 * information and inextricably contains trade secrets and other information
 * proprietary, valuable and sensitive to Redknee.  No unauthorized use,
 * disclosure, manipulation or otherwise is permitted, and may only be used
 * in accordance with the terms of the license agreement entered into with
 * Redknee Inc. and/or its subsidiaries.
 *
 * Copyright (c) Redknee Inc. and its subsidiaries. All Rights Reserved.
 */
package com.practice;

/**
 * 
 *
 * @author dshah
 * @since 
 */
public class MinPrevK {

	public static void main(String[] args) {
		
		int a[] = {6,1,5,3,2,5,7,2,7,9,8,5,5};
		
		printOutput(minPrevK(a, 3));
	}

	private static void printOutput(int[] a) {
		for(int val : a) {
			System.out.println(val);
		}
	}

	private static int[] minPrevK(int[] a, int k) {

	    if(a == null || a.length == 0) {
	        return new int[0];
	    }
	    
		int[] output = new int[a.length - k + 1];
	    
		//0 - index; 1 - value
		int firstMin[] = min(a, 0, k -1);
		
		for(int i = 0; i < a.length; i++) {
			if(firstMin[0] < i) {
				//discard the first min and find new in i...i+k range;
				firstMin = min(a, i, i + k -1);
			}
			if(i >= output.length) {
				return output;
			}	
			output[i] = firstMin[1];	
		}
		
	    return output;
	}
	
	private static int[] min(int a[], int startIndex, int endIndex) {
		
		int min[] = new int[2];
		min[0] = startIndex;		//stores index
		min[1] = a[startIndex];		//stores value
		
		for(int i = startIndex; i <= endIndex; i++) {
			if(min[1] > a[i]) {
				min[0] = i;
				min[1] = a[i];
			}
		}
		return min;
	}
}
