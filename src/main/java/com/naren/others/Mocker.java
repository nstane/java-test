/**
 * 
 */
package com.naren.others;

import java.sql.SQLException;

/**
 * @author Narender Singh
 *
 */
public class Mocker <T extends Exception>{

	/**
	 * 
	 */
	public Mocker() {
		 
	}

	/**
	 * Turns out the compiler gets confused just as we do, and the code makes it think that the catch block is unreachable. 
	 * For the unsuspecting bystander, there is no SQLException. The correct answer is that compilation fails 
	 * because the compiler doesn’t expect a SQLException to be thrown from the try block – When in fact it does get thrown!
	 * @param args
	 */
	public static void main(final String[] args) {
		 
		try{
			new Mocker<RuntimeException>().pleaseThrow(new SQLException());
		}finally{
			
		}
//		}catch(final SQLException se){
//			se.printStackTrace();
//		}
	}
	
	@SuppressWarnings("unchecked")
	public void pleaseThrow(final Exception t) throws T{
		throw ((T) t);
	}

}
