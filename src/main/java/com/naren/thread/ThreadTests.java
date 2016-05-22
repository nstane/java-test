/**
 * 
 */
package com.naren.thread;

/**
 * @author nstanwar
 *
 */
public class ThreadTests {

	/**
	 * 
	 */
	public ThreadTests() {
		 
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 
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
