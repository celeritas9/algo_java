package com.test.synchronize;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Task implements Runnable {

	static List<String> stringList = new CopyOnWriteArrayList<String>();
	static Iterator listIterator = stringList.iterator();
	String name;
	
	public Task(String name)
	{
		this.name = name;
	}
	
	@Override
	public void run() {
		
		while(listIterator.hasNext()) {
			//List contains nothing in the starting.
			
		}
		stringList.add(this.name);
		System.out.println("List size: " +stringList.size());
		/*try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		System.out.println(this.name +"executed at" + new Date(System.currentTimeMillis()));
	}
}
