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
package com.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 *
 * @author dshah
 * @since 
 */
public class TestMapKeySet {

	public static void main(String[] args) {
		Map m = new HashMap();
		m.put(10, 10);
		
		Object o = m.get(10l);
		
		System.out.println(o);
	}

}
