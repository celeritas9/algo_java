package com.exception;

public class TestException
{

	public static void main(String[] args) throws Exception
	{
		try
		{
			throw new SampleException("This exception is thrown in the first line.");
		}
		finally
		{
			System.out.println("Let's check if this final block is executed.");
		}
		
		//System.out.println("this is test");
	}
}
