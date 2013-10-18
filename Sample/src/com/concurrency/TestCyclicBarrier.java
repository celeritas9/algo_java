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

import java.util.concurrent.CyclicBarrier;

/**
 * 
 *
 * @author dshah
 * @since 
 */
public class TestCyclicBarrier
{

	public static void main(String[] args)
	{
		CyclicBarrier barrier = new CyclicBarrier(5);
		
		for(int i = 0; i < 10; i++)
		{
			CyclicBarrierTask t = new CyclicBarrierTask("Task:"+i, i, barrier);
			new Thread(t).start();
		}
		System.out.println("Main thread finishes execution.");
	}
}
