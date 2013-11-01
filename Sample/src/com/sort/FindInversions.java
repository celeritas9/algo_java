package com.sort;


/**
 * Given a list {a1, a2,…, an}, propose an algorithm to count the number of inversions with O(n * lg n) complexity.
 * 
 * @author Devang_1
 */
public class FindInversions
{
	int inversions = 0;
	
	int findInversions(int A[])
	{
		int TempArray[] = new int[A.length];
		countInversions(A, TempArray, 0, A.length - 1);
		
		return inversions;
	}

	void countInversions(int A[], int TempArray[], int left, int right)
	{
		int center;
		if ( left < right)
		{
			center = (right + left)/2;
			countInversions(A, TempArray, left, center);
			countInversions(A, TempArray, center+1, right);
			
			Merge(A, TempArray, left, center+1, right);
		}
	}

	void Merge(int A[], int TempArray[], int Lpos, int Rpos, int Rend)
	{
		int i, Lend, Num, TempPos;
		Lend = Rpos - 1;
		TempPos = Lpos;
		Num = Rend - Lpos +1;
		
		while((Lpos <=Lend) && (Rpos <= Rend))
		{	if(A[Lpos] <= A[Rpos])
			{
				TempArray[TempPos++] = A[Lpos++];
				//this is not a inversion so spare it.
			}
			else
			{
				inversions += (Lend - Lpos) + 1;
				TempArray[TempPos++] = A[Rpos++];
				//Whenever we take an element from second array it means that it's an inversion and all the remaining elements in first array are greater that this element.
			}
		}
		while (Lpos <= Lend) // Copy rest of first half
			TempArray[TempPos++] = A[Lpos++];
		while (Rpos <= Rend) // Copy rest of second half
			TempArray[TempPos++] = A[Rpos++];
		
		for(i =1; i <= Num; i++, Rend--)
			A[Rend] = TempArray [Rend];
	}
}
