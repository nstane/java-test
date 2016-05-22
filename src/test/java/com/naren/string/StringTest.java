/**
 * 
 */
package com.naren.string;

/**
 * @author nstanwar
 * Purpose of String Constant Pool : 
 * Each class has its own constant pool,
 * Store object and when they are required in program multiple time then get them from there instead creating new.
 */
public class StringTest {

	/**
	 * 
	 */
	public StringTest() {
		 
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 
		test2();
		
	}
	@SuppressWarnings("unused")
	private static void test1(){
		String s= "Hello";
		String s1 = s.intern();
		System.out.println(s == s1);
		String s2 = new String("Hello");
		String s4 = "Hello";
		String s3 = s2.intern(); // intern return object refer in SCP
		System.out.println(s3 == s2);
		System.out.println(s1 == s4);
		//All Above statement create 2 object
	}
	@SuppressWarnings("unused")
	private static void test2(){
		String str1 = new String("gabbar");
		String str2 = new String("gabbar");
		String str3 = "gabbar";
		String str4 = str1.intern();
		String str5 = str2.intern();
		String str6 = str3.intern();
		//What's the output if i write:
		System.out.println( str1 == str1.intern() );
		System.out.println( str3 == str1.intern() );
		System.out.println( str3 == str2.intern() );
		System.out.println( str3 == str3.intern() );
	}

}
