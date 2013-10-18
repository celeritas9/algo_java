package com.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * 
 *
 * @author dshah
 * @since 
 */
public class TestThreadPoolExec
{
	static ThreadLocal<Integer> tl = new ThreadLocal<Integer>();
	private static int ch;

	public static void main(String[] args)
	{
		ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(100);
		ThreadPoolExecutor tpe = new ThreadPoolExecutor(5, 10, 0, TimeUnit.SECONDS, queue);
		Runnable r;
		tl.set(ch);
		for(int i = 0; i < 100; i++)
		{
			r = new TestRunnable();
			queue.add(r);
			tpe.execute(r);
			if(i == 5)
			{
				System.out.println("[" +Thread.currentThread().getName()+ "]5 threads executed. The size of threadpool is " +tpe.getPoolSize());
				System.out.println("[" +Thread.currentThread().getName()+ "]5 threads executed. Active count is " +tpe.getActiveCount());
				System.out.println("[" +Thread.currentThread().getName()+ "]5 threads executed. Queue size is " +tpe.getQueue().size());
			}
			
			if(i > 10)
			{
				System.out.println("[" +Thread.currentThread().getName()+ "]" +i+ " threads executed. The size of threadpool is " +tpe.getPoolSize());
				System.out.println("[" +Thread.currentThread().getName()+ "]" +i+ " threads executed. Active count is " +tpe.getActiveCount());
				System.out.println("[" +Thread.currentThread().getName()+ "]" +i+ " threads executed. Queue size is " +tpe.getQueue().size());
			}
		}
		
		tpe.shutdown();
	}

	
	public static class TestRunnable implements Runnable
	{
		public void run()
		{
			System.out.println("[" +Thread.currentThread().getName()+ "]");
			try
			{
				Thread.sleep(10000);
			}
			catch (InterruptedException e)
			{
				// TODO: Auto-generated catch block!
			}
		}
	};
}
