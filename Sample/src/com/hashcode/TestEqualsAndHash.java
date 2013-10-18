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
package com.hashcode;

import java.text.DateFormat;
import java.text.SimpleDateFormat;


/**
 * 
 *
 * @author dshah
 * @since 
 */
public class TestEqualsAndHash
{
	public static void main(String[] args)
	{
		/*StringBuffer a = new StringBuffer();
		StringBuffer b = new StringBuffer();*/
		
		/*String a = "testString";
		String b = "testString";
		
		if(a == b)
			System.out.println("success");
		System.out.println("hash of a "+Integer.toHexString(a.hashCode()));
		System.out.println("identityHashCode of a " + System.identityHashCode(a));
		System.out.println("hash of b "+Integer.toHexString(b.hashCode()));
		System.out.println("identityHashCode of b " + System.identityHashCode(b));
		*/
		DateFormat df1 = new SimpleDateFormat("ddMMyyyy");
		DateFormat df2 = new SimpleDateFormat("ddMMyyyy");
		
		StringBuffer buff = new StringBuffer();
		
		TestObject o1 = new TestObject("test", buff, df1);
		System.out.println("hashcode of testObject1: " +Integer.toHexString(System.identityHashCode(o1)));
		
		TestObject o2 = new TestObject("test", buff, df1);
		System.out.println("hashcode of testObject2: " +Integer.toHexString(System.identityHashCode(o2)));
		
		assert (o1 != o2);
	}
}
