/**
 * 
 */
package com.naren.others;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 2.
 * @author Narender Singh
 *
 */
public class MyClass {

	@SuppressWarnings("unused")
	private String name; 
	/*
	 * 3.
	 */
	private static final List<String> LIST = new ArrayList<String>(){
		/**
		 * 
		 */
		private static final long serialVersionUID = -8399014031814455274L;

		{
			add("hEllo");
			System.out.println(getList());
		}
	};
	/**
	 * 
	 */
	public MyClass() {
		 
	}

	/**
	 * @param args
	 */
	@SuppressWarnings({ "unchecked" })
	public static void main(String[] args) {
		 
		MyClass m1 =new MyClass();
		MyClass m2 =new MyClass();
		m1.name =m2.name = "m1";
		callMe(m1,m2);
		System.out.println(m1 +" & "+m2);
		///4.
		Map<String,Object> map =new TreeMap<>();
		System.out.println(map.compute("hello", (k,v)->(v == null) ? new ArrayList<Object>() : ((List<String>)v).add("bar")));
		System.out.println(map.compute("hello", (k,v)->(v ==null) ?new ArrayList<Object>():((List<String>)v).add("hh")));
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		sc.useDelimiter("\n");
		int x=sc.nextInt();
		double y  =sc.nextDouble();
		String s = sc.next();
		System.out.println("String: "+s);
		System.out.println("Double: "+y);
		System.out.println("Int: "+x);
	}
	private static void callMe(MyClass... m){
		m[0] = m[1];
		m[0].name = "new name";
	}

	public static List<String> getList() {
		return LIST;
	}
}
