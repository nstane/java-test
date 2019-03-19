import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 */

/**
 * @author nstanwar
 *
 */
public class ConcurrencyAtomic {

	private volatile int i = 0; //volatile is use to provide latest update of var to all other workers or thread

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ConcurrencyAtomic().call();
	}

	private void call() {
		AtomicInteger ii = new AtomicInteger();

		new Thread(() -> {
			i++;
			System.out.println(i + " n " + ii.getAndIncrement());
		}).start();
		
		new Thread(() -> {
			i--;
			System.out.println(i + " n " + ii.getAndIncrement());
		}).start();
	}

}
