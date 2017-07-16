/**
 * 
 */
package com.naren.exception;

/**
 * @author nstanwar
 * 
 *         If Base class's method override in child then only throws Same or
 *         Parent Exception
 *
 */
public class ExceptionHandling {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int returnVal = getMe(0);
		System.out.println(returnVal);
	}

	@SuppressWarnings("finally")
	private static int getMe(int i) {

		try {
			int c = 10 / i;
			System.exit(0);
			return c;
			// after return don't put any thing
		} catch (NullPointerException e) {
			// keep exception after other exception
		} catch (Exception e) {
			return 20 / i;
		} finally {
			return 30 / i;
		}
	}
}

class Base {
	public void excep() throws RuntimeException {
		System.out.println("Throw ");
	}
}

class Child extends Base {
	@Override
	public void excep() throws RuntimeException {

	}
}
