/**
 * 
 */
package com.test;

import java.util.concurrent.TimeUnit;

public class Multithreading 
{
	private static boolean stopRequested; 
	
	public static void main() throws InterruptedException
	{
		Thread backgroundThread = new Thread(new Runnable()
		{
			public void run()
			{
				int i = 0;
				while(!stopRequested)
				{
					i++;
				}
			}
		});
		backgroundThread.start();
		
		TimeUnit.SECONDS.sleep(1);
		stopRequested = true;
	}
}
