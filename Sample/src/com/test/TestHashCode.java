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
package com.test;

import java.util.HashMap;

import com.test.TestHashCode.Test;

/**
 * 
 *
 * @author dshah
 * @since 
 */
public class TestHashCode {

	public static void main(String[] args) {
		
		TestHashCode thc = new TestHashCode();
		TestHashCode.Test test = thc.new Test();
		HashMap map = new HashMap();
		map.put(test, true);
		
		System.out.println(map.get(test));
		test.i = 10;
		System.out.println(map.get(test));
	}
	
	public class Test {
		int i = 0;
		@Override
		public int hashCode() {
			return i;
		}
	}
}
