package com.Timer;

import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestScheduler {
	
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		ScheduledThreadPoolExecutor se = new ScheduledThreadPoolExecutor(20);

		Task t1 = new Task("Task 1 submitted at: "+ new Date(), "Task 1");
		Object f1 = se.schedule(t1, -5, TimeUnit.MINUTES);
		Thread.sleep(5000);
		
		Task t2 = new Task("Task 2 submitted at: "+ new Date(), "Task 2");
		Object f2 = se.schedule(t2, 4, TimeUnit.MINUTES);
		Thread.sleep(5000);
		
		Task t3 = new Task("Task 3 submitted at: "+ new Date(), "Task 3");
		Object f3 = se.schedule(t3, 5, TimeUnit.MINUTES);
		//Before removing from the queue.
		System.out.println(se.getQueue().toString());

/*	for (long i = 0; i < 1000 ; i++){
			Task t = new Task("Task " + i +" submitted at: " + new Date(), "Task " + i);
			se.schedule(t, 2+1*i, TimeUnit.SECONDS);
			System.out.println("Queue size: "+se.getQueue().size());
		}*/
		/*System.out.println("Removed " + se.remove(returnTask(se.getQueue())));*/
/*		System.out.println("Removed " + se.remove((Runnable) f1));
		System.out.println("Removed " + se.remove((Runnable) f2));
		System.out.println("Removed " + se.remove((Runnable) f3));*/
		
		//After removing from the queue.
		System.out.println(se.getQueue().toString());
		
		se.shutdown();
		//System.exit(0);

	}

	public static Runnable returnTask(BlockingQueue<Runnable> q){
		int i = 0;

		Iterator<Runnable> iterator = q.iterator();
		while(iterator.hasNext() && i != 10){
			i++;
		}

		return iterator.next();
	}

}
