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
package com.concurrency;

import java.util.concurrent.CountDownLatch;

/**
 * 
 *
 * @author dshah
 * @since 
 */
public class TestCountDownLatch
{

	public static void main(String[] args) throws InterruptedException
	{
		CountDownLatch latch = new CountDownLatch(5);
		
		for(int i = 0; i < 10; i++)
		{
			CountDownTask t = new CountDownTask("Task:"+i, i, latch);
			new Thread(t).start();
		}
		latch.await();
		System.out.println("Main thread waiting finished as 5 threads have finished execution.");
		System.exit(0);
	}
}
