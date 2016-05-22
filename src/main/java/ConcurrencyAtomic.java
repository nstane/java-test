import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 */

/**
 * @author nstanwar
 *
 */
public class ConcurrencyAtomic {

	volatile int i = 0;
	/**
	 * 
	 */
	public ConcurrencyAtomic() {
		 
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 
		
		new ConcurrencyAtomic().call();
	}
	
	private void call(){
		AtomicInteger ii = new AtomicInteger();
		Runnable run = ()->{
			i++; 
			ii.getAndIncrement();
			System.out.println(i+" n "+ii.toString());
			};
		Runnable run2 = ()->{
			i--; 
		ii.getAndDecrement();
		System.out.println(i+" n "+ii.toString());
		};
		new Thread(run).start();
		new Thread(run2).start();
	}

}
