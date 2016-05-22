/**
 * 
 */
package com.naren.thread.chaining;

/**
 * @author nstanwar
 *
 */
public class ChainThread {

	/**
	 * 
	 */
	public ChainThread() {
	}

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		Runnable run1 = () -> {
			System.out.println("hello "+Thread.currentThread().getName());
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		};
		Runnable run2 = () -> {
			System.out.println("hello "+Thread.currentThread().getName());
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		};
		Runnable run3 = () -> {
			System.out.println("hello "+Thread.currentThread().getName());
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		};
		Thread t1 = new Thread(run1);
		Thread t2 = new Thread(run2);
		Thread t3 = new Thread(run3);
		
		t3.start();
		t3.join();
		t2.start();
		t2.join();
		t1.start();
		t1.join();
		System.out.println(Thread.currentThread().getName());
	}

}
