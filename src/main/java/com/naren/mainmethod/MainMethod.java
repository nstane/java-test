/**
 * 
 */
package com.naren.mainmethod;

import java.util.Arrays;

/**
 * @author nstanwar
 *
 */
public class MainMethod {

	/**
	 * 
	 */
	public MainMethod() {
		 
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Arrays.asList(args).forEach(e-> System.out.println(e));
	}

}
