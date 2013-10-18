package com.search;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Devang_1
 *
 */
public class TestUnimode
{
	public SearchModeInUnimodal unimode;
	public int expectedMode;
	
	@Before
	public void setUp()
	{
		unimode = new SearchModeInUnimodal();
	}
	
	@Test
	public void test_1()
	{
		int a[] = new int[] {1, 2, 3, 4, 7, 6, 5, 0};
		expectedMode = 7;
		
		Assert.assertEquals(expectedMode, unimode.recFindMode(a, 0, a.length));
	}
	
	@Test
	public void test_2()
	{
		int a[] = new int[] {5, 8, 19, 13, 12, 10, 9, 4, 1};
		expectedMode = 19;
		
		Assert.assertEquals(expectedMode, unimode.recFindMode(a, 0, a.length));
	}
}
