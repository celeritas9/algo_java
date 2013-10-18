/**
 * 
 */
package com.wait;

import java.util.Random;

/**
 * @author dshah
 */
public class Task implements Runnable
{

	String name;
	int id;
	boolean isExecuted = false;
	
	public Task(String name_, int id_)
	{
		name = name_;
		id = id_;
	}
	
	@Override
	public void run()
	{
		try
		{
			/*Wait for 1 to 10 seconds*/
			long timeToWait = (new Random().nextLong() % 10) * 1000;
			System.out.println("Task " +this.id+ " waiting for " +timeToWait+ " ms");
			Thread.sleep(Math.abs(timeToWait));
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		
		//Trying another approach of notifying.
		synchronized(this)
		{
			isExecuted(true);
			this.notify();
		}
	}
	
	public void isExecuted(boolean state)
	{
		isExecuted = state;
	}
}
