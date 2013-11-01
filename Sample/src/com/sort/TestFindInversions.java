package com.sort;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestFindInversions
{
	int expected;
	FindInversions inv;
	
	@Before
	public void setup()
	{
		inv = new FindInversions();
	}
	
	@Test
	public void test1()
	{
		int [] input = {5, 8, 2, 9, 7, 3};
		expected = 8;
		Assert.assertEquals(expected, inv.findInversions(input));
	}
	
	@Test
	public void test2()
	{
		int [] input = {5, 8, 2, 9, 7, 3, 4, 6, 10, 1, 12};
		expected = 24;
		Assert.assertEquals(expected, inv.findInversions(input));
	}
}
