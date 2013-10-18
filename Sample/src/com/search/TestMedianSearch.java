package com.search;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestMedianSearch
{
	public MedianSearch testMedianSearch;
	int expected;
	
	@Before
    public void setUp()
	{
		testMedianSearch = new MedianSearch();
	}
	
	@Test
	public void test_1()
	{
		int a[] = {4, 7, 12, 18, 25, 27};
		int b[] = {1, 3, 5, 9, 29, 30};
		expected = 12;
		
		Assert.assertEquals(expected, testMedianSearch.medianSearch(a, b));
	}
	
	@Test
	public void test_2()
	{
		int a[] = new int[]{1, 7, 9, 12, 13, 18};
		int b[] = new int[]{0, 2, 3, 4, 5, 9};
		expected = 7;
		
		Assert.assertEquals(expected, testMedianSearch.medianSearch(a, b));
	}
}


