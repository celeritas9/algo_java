package com.search;

public class SearchModeInUnimodal
{
	public int recFindMode(int array[], int start, int end)
	{
		if(array.length == 1)
			return array[0];
		
		int middle = (end + start)/2;
		
		if(array[middle] > array[middle - 1] && array[middle] > array[middle + 1])
			return array[middle];
		else if(array[middle] > array[middle - 1] && array[middle] < array[middle + 1])
			//Continue with the right half.
			return recFindMode(array, middle + 1, end);
		else if(array[middle] < array[middle - 1] && array[middle] > array[middle + 1])
			//Continue with the left half.
			return recFindMode(array, start, middle - 1);
		
		return array[middle];
	}
}
