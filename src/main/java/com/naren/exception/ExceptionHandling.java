/**
 * 
 */
package com.naren.exception;

/**
 * @author nstanwar
 *
 */
public class ExceptionHandling {

	/**
	 * 
	 */
	public ExceptionHandling() {
		 
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 
		int returnVal = getMe(0);
		System.out.println(returnVal);
	}
	
	@SuppressWarnings("finally")
	private static int getMe(int i){
		
		try{
			int c = 10/i;
			System.exit(0);
			return c;
			//after return don't put any thing
		}catch(NullPointerException e){
			//keep exception after other exception
		}catch(Exception e){
			return 20/i;
		}finally{
			return 30/i;
		}
	}

}
