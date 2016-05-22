/**
 * 
 */
package com.naren.java.blocks;

/**
 * @author nstanwar
 *
 */
public class BaseJavaBlock {

	/**
	 * 
	 */
	public BaseJavaBlock() {
		System.out.println("base constructor");
	}
	static {
		System.out.println("base static");

	}
	{
		System.out.println("base init");
	}

}
