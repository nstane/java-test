/**
 * 
 */
package com.naren.collection;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Narender Singh
 *
 */
public class TestBlockingQueue {

	/**
	 * 
	 */
	public TestBlockingQueue() {
		 
	}

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		 
		BlockingQueue<String> bq = new ArrayBlockingQueue<String>(1024);
		//Producer Thread
		Thread thread1 = new Thread (new Runnable(){
			@Override
			public void run(){
				try {
					bq.put("Hello");
					Thread.sleep(4000);
					bq.put("Hello2");
					Thread.sleep(2000);
					bq.put("Hello3");
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		//COnsumer Thread
		Thread thread2 =new Thread (new Runnable(){
			@Override
			public void run(){
				try {
					System.out.println(bq.take());
					System.out.println(bq.take());
					System.out.println(bq.take());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		thread1.start();
		thread2.start();
//		thread1.join();
//		thread2.join();
		System.out.println("End program");
	}

}
