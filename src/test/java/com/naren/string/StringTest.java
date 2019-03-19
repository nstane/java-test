/**
 * 
 */
package com.naren.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author nstanwar Purpose of String Constant Pool : Each class has its own
 *         constant pool, Store object and when they are required in program
 *         multiple time then get them from there instead creating new.
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
		String a = "27152|0|0:\n" + "24464|0|0:\n" + "27550|1|1:\n" + "14840|1|1:\n" + "27190|0|0:\n" + "26875|0|0:\n"
				+ "13942|1|1:\n" + "25581|1|1:\n" + "99991|0|0:\n" + "27753|0|0:\n" + "26323|1|1:\n" + "27058|0|0:\n"
				+ "5242|0|0:\n" + "27524|0|0:\n" + "24507|1|1:\n" + "12639|1|1:\n" + "10591|1|1:\n" + "12687|0|0:\n"
				+ "8305|0|0:\n" + "26076|0|0:\n" + "26286|1|1:\n" + "9389|1|1:\n" + "16128|1|1:\n" + "28039|0|0:\n"
				+ "27081|1|1:\n" + "27242|1|1:";
		a = a.replaceAll("\n", "");
		System.out.println(a);

		String b = "27152|0|0:26886|1|1:24464|0|0:27550|1|1:14840|1|1:27190|0|0:26875|0|0:13942|1|1:25581|1|1:99991|0|0:27753|0|0:"
				+ "26323|1|1:27058|0|0:5242|0|0:27524|0|0:12639|1|1:10591|1|1:12687|0|0:8305|0|0:26016|0|0:26076|0|0:26286|1|1:9389|1|1:16128|1|1:28039|0|0:27081|1|1:27242|1|1";

		//b = b.replaceAll(".0|", "|0|0:").replaceAll(".1|", "|1|1:");
		System.out.println(b);

		List<String> l1 = new ArrayList<>(Arrays.asList(a.split(":")));
		List<String> l2 = new ArrayList<>(Arrays.asList(b.split(":")));
		System.out.println(l1.size() + " " + l2.size());
		System.out.println(l2.removeAll(l1));
		System.out.println(l2);
		int aa[]= new int[2];
		for(int i:aa) {
			
		}

	}

	@SuppressWarnings("unused")
	private static void test1() {
		String s = "Hello";
		String s1 = s.intern();
		System.out.println(s == s1);
		String s2 = new String("Hello");
		String s4 = "Hello";
		String s3 = s2.intern(); // intern return object refer in SCP
		System.out.println(s3 == s2);
		System.out.println(s1 == s4);
		// All Above statement create 2 object
	}

	@SuppressWarnings("unused")
	private static void test2() {
		String str1 = new String("gabbar");
		String str2 = new String("gabbar");
		String str3 = "gabbar";
		String str4 = str1.intern();
		String str5 = str2.intern();
		String str6 = str3.intern();
		// What's the output if i write:
		System.out.println(str1 == str1.intern());
		System.out.println(str3 == str1.intern());
		System.out.println(str3 == str2.intern());
		System.out.println(str3 == str3.intern());
	}

}
