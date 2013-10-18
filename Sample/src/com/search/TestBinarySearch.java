/**
 * 
 */
package com.search;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Devang
 */
public class TestBinarySearch
{
	public BinarySearch binSearch;
	int expectedValue;
	
	@Before
    public void setUp()
	{
		binSearch = new BinarySearch();
    }
	
	@Test
	public void testSearchValue_1000()
	{
		int[] input = {9000, 9000, 1000, 2000, 3000, 11000, 11000, 11000, 
				11000, 11000, 11000, 11000, 11000, 11000, 11000, 11000};
		int value = 1000;
		
		expectedValue = 2;
		binSearch.setInput_(input);
		binSearch.setValue_(value);
		
		Assert.assertEquals(expectedValue, binSearch.searchValueRecursion(0, input.length - 1));
		Assert.assertEquals(expectedValue, binSearch.searchValue(0, input.length - 1));
	}
	
	@Test
	public void testSearchValue_2000()
	{
		int[] input = {9000, 9000, 1000, 2000, 3000, 11000, 11000, 11000, 
				11000, 11000, 11000, 11000, 11000, 11000, 11000, 11000};
		int value = 2000;
		
		expectedValue = 3;
		binSearch.setInput_(input);
		binSearch.setValue_(value);
		
		Assert.assertEquals(expectedValue, binSearch.searchValueRecursion(0, input.length - 1));
		Assert.assertEquals(expectedValue, binSearch.searchValue(0, input.length - 1));
	}
	
	@Test
	public void testSearchValue_3000()
	{
		int[] input = {9000, 9000, 1000, 2000, 3000, 11000, 11000, 11000, 
				11000, 11000, 11000, 11000, 11000, 11000, 11000, 11000};
		int value = 3000;
		
		expectedValue = 4;
		binSearch.setInput_(input);
		binSearch.setValue_(value);
		
		Assert.assertEquals(expectedValue, binSearch.searchValueRecursion(0, input.length - 1));
		Assert.assertEquals(expectedValue, binSearch.searchValue(0, input.length - 1));
	}
	
	@Test
	public void testSearchValue_NotPresent()
	{
		int[] input = {9000, 9000, 1000, 2000, 3000, 11000, 11000, 11000, 
				11000, 11000, 11000, 11000, 11000, 11000, 11000, 11000};
		int value = 5000;
		
		expectedValue = -1;
		binSearch.setInput_(input);
		binSearch.setValue_(value);
		
		Assert.assertEquals(expectedValue, binSearch.searchValueRecursion(0, input.length - 1));
		Assert.assertEquals(expectedValue, binSearch.searchValue(0, input.length - 1));
	}
}
