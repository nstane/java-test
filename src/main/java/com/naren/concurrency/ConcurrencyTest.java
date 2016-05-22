/**
 * 
 */
package com.naren.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author nstanwar
 * http://www.java-fries.com/2015/06/print-even-and-odd-numbers-using-threads-in-java/
 * Executors are capable of running asynchronous tasks and typically manage a pool of threads, 
 * so we don't have to create new threads manually.
 * All threads of the internal pool will be reused under the hood for revenant tasks, 
 * so we can run as many concurrent tasks as we want throughout the life-cycle of our application with 
 * a single executor service.
 * http://winterbe.com/posts/2015/04/07/java8-concurrency-tutorial-thread-executor-examples/
 * Concurrency vs Thread 
 * A. Read concurrent not in thread
 * B. Use thread pool no need to create new thread every time get thread pool when required in thread create new thread
 * C. Main Thread not dead until call shutdown of executor in thread main thread may dead before task finish.
 * D. Concurrency supports callable and future 
 */
public class ConcurrencyTest {

	/**
	 * 
	 */
	public ConcurrencyTest() {
		 
	}

	/**
	 * @param args
	 * @throws InterruptedException 
	 * @throws ExecutionException 
	 */
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		 

		int i = Runtime.getRuntime().availableProcessors();
		ExecutorService executor = Executors.newFixedThreadPool(i);
		List<Callable<Factory>> callables = new ArrayList<Callable<Factory>>();
		final Lock loc  =new ReentrantLock();
		callables.add(()->{
			return Factory.getInstance();
		});
		callables.add(()->{
			return Factory.getInstance();
		});
		callables.add(()->{
			return Factory.getInstance();
		});
		callables.add(()->{
			return Factory.getInstance();
		});
		List<Future<Factory>> futures = executor.invokeAll(callables);
		int cc = 0;
		for(Future<Factory> future:futures){
			if(future.isDone()){
				System.out.println(future);
				System.out.println(future.get());
				if(cc < futures.size()-1){
					System.out.println(futures.get(cc) == futures.get(cc+1));
				}
			}
		}
		executor.submit(()->{
			loc.lock();
			System.out.println("Submit 1");
			//Factory.getInstance();
			loc.unlock();
		});
		executor.submit(()->{
			//loc.lock();			
			System.out.println("Submit 2");
			//Factory.getInstance();
			//loc.unlock();
		});
		executor.submit(()->{
			//loc.lock();
			System.out.println("Submit 3");
			//Factory.getInstance();
			//loc.unlock();
		});
		executor.submit(()->{
			//loc.lock();
			System.out.println("Submit 4");
			//Factory.getInstance();
			//loc.unlock();
		});
		ScheduledExecutorService executor2 = Executors.newScheduledThreadPool(1);

		Runnable task = () -> System.out.println("Scheduling: " + System.nanoTime());

		int initialDelay = 3;
		int period = 3;
		executor2.scheduleAtFixedRate(task, initialDelay, period, TimeUnit.SECONDS);
		
		Runnable task2 = () -> {
		    try {
		        TimeUnit.SECONDS.sleep(2);
		        System.out.println("Scheduling: " + System.nanoTime());
		    }
		    catch (InterruptedException e) {
		        System.err.println("task interrupted");
		    }
		};

		executor2.scheduleWithFixedDelay(task2, 0, 5, TimeUnit.SECONDS);
		/*An ExecutorService provides two methods for that purpose: shutdown() 
		waits for currently running tasks to finish while
		shutdownNow() interrupts all running tasks and shut the executor down immediately.*/
		try {
			System.out.println("attempt to shutdown executor");
			executor.shutdown();
			//executor2.shutdown();
			executor.awaitTermination(5, TimeUnit.SECONDS);
			//executor2.awaitTermination(5, TimeUnit.SECONDS);
		}
		catch (InterruptedException e) {
			System.err.println("tasks interrupted");
		}
		finally {
			if (!executor.isTerminated()) {
				System.err.println("cancel non-finished tasks");
			}
			executor.shutdownNow();
			System.out.println("shutdown finished");
		}
		System.out.println("End of main");
	}

}


class Factory{

	private static Factory factory;
	private Factory(){

	}

	public synchronized static Factory getInstance(){
		System.out.println("factory out: "+Thread.currentThread().getName()+" factory "+factory);

		if(factory == null){
			//synchronized (factory) {
				//if(factory != null){
					System.out.println("factory in: "+Thread.currentThread().getName());
					factory = new Factory();
				//}
			//}

		}
		return factory;
	}

}
//factory out: pool-1-thread-2factory out: pool-1-thread-4factory in: pool-1-thread-4factory out: pool-1-thread-3factory out: pool-1-thread-1factory in: pool-1-thread-2java.util.concurrent.FutureTask@1b28cdfa
