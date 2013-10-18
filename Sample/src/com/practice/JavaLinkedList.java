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
package com.practice;

import java.io.IOException;

/**
 * 
 *
 * @author dshah
 * @since 
 */
public class JavaLinkedList
{
	private static JavaLinkedList list;

	public static void main(String[] args) throws IOException
	{
		int c;
		do
		{
			System.out.println("0. Exit \n1. Create \n2. Add \n3. Remove");
			c = System.in.read();
			if(c < 48 || c > 57)
			{
				System.out.println("You have entered: " +c);
				System.out.println("Wrong choice! Please try again.");
				continue;
			}
			switch(c)
			{
				case 48:
					return;
				case 49:
					list = new JavaLinkedList();
					System.out.println("New Linked List created. To add nodes choose appropriate option.");
					break;
				case 50:
					break;
				case 51:
					break;
				default:
					System.out.println("Choice " +c+ " not found. Please try again.");
					break;
			}
			flushSysIn();
		}while(c != 48);
	}

	private static void flushSysIn() throws IOException
	{
		int c = System.in.available();
		for(int i = 0; i < c; i++)
		{
			//System.out.println("Flushing " +System.in.available()+ " chars");
			System.in.read();
		}
	}
}
