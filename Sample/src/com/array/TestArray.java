package com.array;

public class TestArray
{
	public static void main(String[] args)
	{
		Object[] a = new Object[10];
		a[0] = "this is 0";
		a[0] = "this is 9";
		
		Object[][] b = new Object[10][5];
		
		if(a instanceof Object[][])
		{
			System.out.println("a is 2D array.");
		}
		if(a instanceof Object[])
		{
			System.out.println("a is 1D array.");
		}
		
		if(b instanceof Object[][])
		{
			System.out.println("b is 2D array.");
		}
		if(b instanceof Object[])
		{
			System.out.println("b is 1D array.");
		}
	}
}
