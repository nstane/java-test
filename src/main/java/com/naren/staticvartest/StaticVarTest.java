/**
 * 
 */
package com.naren.staticvartest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Narender Singh
 *
 */
public class StaticVarTest {
	
	static int x =12;
	/**
	 * 
	 */
	public StaticVarTest() {
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		StaticVarTest svt = null;
		System.out.println(svt.x);
		System.out.println(StaticVarTest.x);
		List<String> stringList =  new ArrayList<>();
		stringList.add("one");
		stringList.add("two");
		stringList.add("five");
		stringList.add("none");
		stringList.add("eight");
		Iterator<String> iterator = stringList.iterator();
		String s =null;
		for(;iterator.hasNext();){
			s=iterator.next();
			if(s.equals("one")){
				//iterator.remove();
			}
			//s=iterator.next();
			System.out.println(s);
		}
		for(String ss :stringList){
			//stringList.remove(ss);
			System.out.println(ss);
		}
		
	}

}
