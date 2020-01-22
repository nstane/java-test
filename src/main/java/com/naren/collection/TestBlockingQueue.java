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
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		 
		final BlockingQueue<String> bq = new ArrayBlockingQueue<>(1024);

		Runnable producer = ()->{
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
		};

		Runnable consumer = () -> {
			try {
				System.out.println(bq.take());
				System.out.println(bq.take());
				System.out.println(bq.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		//Producer Thread
		Thread thread1 = new Thread (producer);
		//consumer Thread
		Thread thread2 =new Thread (consumer);
		thread1.start();
		thread2.start();
//		thread1.join();
//		thread2.join();
		System.out.println("End program");
	}
}
