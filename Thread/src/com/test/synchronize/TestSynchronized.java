package com.test.synchronize;


public class TestSynchronized {
	
	public static void main(String[] args) {
		
		for(int i = 0; i < 100000; i++) {
		
			Thread task = new Thread(new Task("thread"+i));
			task.start();
			/*try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
	}
}
