/**
 * 
 */
package com.naren.exceptiion;

/**
 * @author nstanwar
 *
 */
public class TestException {

	public static final String NOSUCHPRODUCTEXIST = "This product no more exist";
	/**
	 * 
	 */
	public TestException() {
		 
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 
		callMe();
	}
	public static void callMe(){
		int productid= 1000;
		//throw new NoSuchProductException(NOSUCHPRODUCTEXIST,productid,new Exception());
		throw new NoSuchProductException(NOSUCHPRODUCTEXIST,productid);
	}

}
