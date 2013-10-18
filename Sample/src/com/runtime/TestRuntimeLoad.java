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
package com.runtime;

/**
 * 
 *
 * @author dshah
 * @since 
 */
public class TestRuntimeLoad
{
	public static void main(String[] args) throws Exception
	{
		for(int i = 0 ; i < 100000; i++)
		{
			print();
			Thread.sleep(1000);
		}
	}
	
	public static void print()
	{
		System.out.println("This is version V1 of method print().");
	}
}
