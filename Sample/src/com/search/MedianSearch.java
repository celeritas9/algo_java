/**
 * 
 */
package com.search;

/**
 * Given two sorted arrays A and B, each of size n. Provide an algorithm to find the median of
 * A U B (union or combination of A and B) with the running time complexity of O(lg n). 
 * Note that the median of array elements is a number such that half the elements (round down) 
 * are less than that number and half are at least as large as that number.
 * 
 * Assume: n % 2 = 0. And A U B has distinct elements.
 * 
 * @author Devang_1
 */
public class MedianSearch
{

	int medianSearch(int arrayA[], int arrayB[])
	{
		int arrayAStart = 0;
		int arrayAEnd = arrayA.length - 1;
		int arrayBStart = 0;
		int arrayBEnd = arrayA.length - 1;
		
		for(;;)
		{
			if(arrayAEnd == arrayAStart || arrayBEnd == arrayBStart)
			{
				if(arrayA[arrayAEnd] > arrayB[arrayB.length / 2] && 
						arrayA[arrayAEnd] < arrayA[arrayA.length / 2])
					return arrayA[arrayAEnd];
				if(arrayB[arrayBEnd] > arrayB[arrayB.length / 2] && 
						arrayB[arrayBEnd] < arrayA[arrayA.length / 2])
					return arrayB[arrayBEnd];
			}
			
			int medianAIndex = (arrayAEnd - arrayAStart + 1)/2;
			int medianBIndex = (arrayBEnd - arrayBStart + 1)/2;
			medianAIndex = arrayAStart + 1;
			medianBIndex = arrayBStart + 1;
			if(arrayA[medianAIndex] > arrayB[medianBIndex])
			{
				//it means that median lies between B[medianBIndex] - A[medianAIndex].
				//if this is the case then consider left elements of A and right elements of B.
				arrayAEnd = medianAIndex;
				arrayBStart = medianBIndex;
			}
			else if(arrayA[medianAIndex] < arrayB[medianBIndex])
			{
				//it means that median lies between A[medianAIndex] - B[medianBIndex].
				//if this is the case then consider right elements of A and left elements of B.
				arrayBEnd = medianBIndex;
				arrayAStart = medianAIndex; 
			}
		}
	}

}
