package com.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestCallable implements Callable<String>
{
	
	public static int threadCount = 0;
	public static final int MAX_THREADS = 10;
	
	public TestCallable(int count)
	{
		
	}
	
	public static void main(String[] args)
	{
		ExecutorService exec = Executors.newFixedThreadPool(MAX_THREADS);
		List <Future<String>> list = new ArrayList<Future<String>>();
		
		
	}

	@Override
	public String call() throws Exception
	{
		return Thread.currentThread().getName() + threadCount++;
	}

}
