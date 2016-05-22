/**
 * 
 */
package com.naren.others;

/**
 * @author Narender Singh
 *
 */
public class EvennNOdd {

	/**
	 * 
	 */
	public EvennNOdd() {
		 
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 
		String largeNumber = "911111111111111111111111111111111111111111112";
		System.out.println(isEven(largeNumber));
		System.out.println(isEven(9));
	}

	public static boolean isEven (int num) {
	    return (num & 1) == 0;
	}
	
	//large no
	
	static boolean isEven(String input){
		String in = String.valueOf(input.charAt(input.length()-1));
		System.out.println(in);
	    return Integer.parseInt(in)%2 == 0;
	}
}
