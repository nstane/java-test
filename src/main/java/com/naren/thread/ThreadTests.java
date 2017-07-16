/**
 * 
 */
package com.naren.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * @author nstanwar
 *
 */
public class ThreadTests {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    //join();
	    //throwException();
	    threadExec();
	}
	
	public static void threadExec(){
		AtomicInteger intr =  new AtomicInteger();
		
		Runnable task = () ->{
			int count = 1;
			while(count++ <= 10){
				System.out.println(Thread.currentThread().getName()+" Printing "+intr.incrementAndGet());
				Thread.yield();
			}
		};
		
		IntStream.range(1, 4).forEach(E -> {
			Thread t = new Thread(task);
			t.start();
			try {
				t.join();
			} catch (InterruptedException e) {
				System.out.println("Error : "+e.getMessage());
			}
		});
	}
	
	public static void throwException(){
		Thread t1 = new Thread(()->{
			throw new RuntimeException("Helllllloooo");
		});
		t1.start();;
	}
	
	@SuppressWarnings("unused")
	private static void join(){
		Thread t1 = new Thread(() -> {
			System.out.println("Thread t1 processing task1");
		});
		Thread t2 = new Thread(() -> {
			System.out.println("Thread t2 processing task2");
		});
		Thread t3 = new Thread(() -> {
			System.out.println("Thread t3 processing task3");
		});
		
		System.out.println("Starting Thread");
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			System.out.println("Error : "+e.getMessage());
		}
		
		System.out.println("t1 started and joined");
		
		t2.start();
		try {
			t2.join();
		} catch (InterruptedException e) {
			System.out.println("Error : "+e.getMessage());
		}
		
		System.out.println("t2 started and joined");
		
		t3.start();
		try {
			t3.join();
		} catch (InterruptedException e) {
			System.out.println("Error : "+e.getMessage());
		}
		
		System.out.println("t3 started and joined");
		
	}
	
	@SuppressWarnings("unused")
	private static void runSequential(){
		Thread thread = new Thread();
		System.out.println("Name : "+thread.getName());
		System.out.println("Priority : "+thread.getPriority()+"\nID : "+thread.getPriority()+"\nThread : "+thread.toString());
		
		final Thread t1 = new Thread("t1") {
	        @Override
	        public void run() {
	            System.out.println("i am thread: " + Thread.currentThread().getName());
	        }
	    };

	    final Thread t2 = new Thread(t1, "t2") {
	        @Override
	        public void run() {
	            t1.start();
	            try {
	                t1.join();
	            } catch ( InterruptedException e ) {
	                e.printStackTrace();
	            }
	            System.out.println("i am thread: " + Thread.currentThread().getName());
	        }
	    };

	    Thread t3 = new Thread(t2, "t3") {
	        @Override
	        public void run() {
	            t2.start();
	            try {
	                t2.join();
	            } catch ( InterruptedException e ) {
	                e.printStackTrace();
	            }
	            System.out.println("i am thread: " + Thread.currentThread().getName());
	        }
	    };

	    t3.start();
	}

}




