package com.wait;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestWait
{
	static SimpleDateFormat dateFormatter = new SimpleDateFormat("HH:mm:ss:SSS");
	
	public static void main(String[] args) throws InterruptedException
	{
		for(int i = 0; i < 10; i++)
		{
			Task t = new Task("Task_"+i, i);
			Thread thread = new Thread(t);
			
			System.out.println("Now starting thread: " +t.id);
			thread.start();
			
			//Wait for each thread created above to finish execution.
			//Wait for 5 seconds before i th thread is terminated un-safely.
			
			//Wait on this task, until it notifies or times out.
			System.out.println("Waiting on " +t+ " task, until it notifies. Time: " +dateFormatter.format(new Date()));
			synchronized(t)
			{
				//All the Tasks that are internally waiting for more than 5 s will be timedout.
				t.wait(5000l);
			}
			System.out.println("Task " +t.name+ " completion status " +t.isExecuted);
			System.out.println(t+ " task notified or timed out at " +dateFormatter.format(new Date()));
		}
	}

	/*private static void wait(Task t, int seconds) throws InterruptedException
	{
		long waitTillTime = System.currentTimeMillis() + seconds * 1000;
		System.out.println("Waiting till " +dateFormatter.format(waitTillTime)+ " for task " +t.id);
		while(true)
		{
			if(t.isExecuted || waitTillTime <= System.currentTimeMillis())
			{
				//If the task execution is complete than stop waiting.
				System.out.println("Task " +t.id+ " is either finished executing or wait time over. Time: " +dateFormatter.format(System.currentTimeMillis()));
				break;
			}
			//Wait for 500 m second.
			Thread.sleep(500l);
		}
	}*/
}
