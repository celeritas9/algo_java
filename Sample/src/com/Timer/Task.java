package com.Timer;

import java.util.Date;

public class Task implements Runnable {

	static int count;
	private String taskName;
	
	public Task(String inTime, String name){
		System.out.println(inTime);
		taskName = name;
	}
	
	@Override
	public void run(){
		// TODO Auto-generated method stub
		System.out.println("Thread " + taskName + ": is executed at: " + new Date());
/*		try{
			Thread.sleep(5000);
		}
		catch(InterruptedException ie){
			ie.printStackTrace();
		}
		System.out.println("Thread " + count++ + " is up again.");
*/
	}
	
}
