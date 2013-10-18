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
 * @author dshah
 * @since 
 */
public class CountDownTask implements Runnable {

	public String name;
	public int id;
	public CountDownLatch latch;
	
	public CountDownTask(String name, int id, CountDownLatch latch)
	{
		this.name = name;
		this.id = id;
		this.latch = latch;
	}

	public void run()
	{
		System.out.println("Thread " +name+ " started.");
		try
		{
			Thread.sleep(5000 * id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("Thread " +name+ " finished execution.");
		latch.countDown();
	}
}
