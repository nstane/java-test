/**
 * 
 */
package com.naren.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author nstanwar
 * Benefit of generic 
 * A. Avoid run time ClassCastException
 * B. Generic only compile time feature to ensure TYPE_SAFETY
 * 
 * ? extends E means Object E and all child of E or defines E as the upper bound: "This can be cast to E".
 * ? super E means Object E and all super of E or defines E as the lower bound: "E can be cast to this."
 */
public class GenericTest {

	/**
	 * 
	 */
	public GenericTest() {
		 
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		 
		List<? super String > list  = new ArrayList<>();
		List<? super String> list2 = list;
		list.add("One");
		List <? extends Number > list22 = new ArrayList<>();
		//list22.add(0, new Integer(12));
		List <?> list21 = new ArrayList<String>();
		//list21.add("");
		System.out.println(list.getClass()+" "+list2.getClass());

		List<Integer> myInts = Arrays.asList(1,2,3,4,5);
		List<Long> myLongs = Arrays.asList(1L, 2L, 3L, 4L, 5L);
		List<Double> myDoubles = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);

		System.out.println(sum(myInts)); //compiler error
		System.out.println(sum(myLongs)); //compiler error
		System.out.println(sum(myDoubles)); //compiler error
		List<? extends Number> myNums = new ArrayList<Integer>();
		List<? extends Number> myNums2 = new ArrayList<Float>();
		List<? extends Number> myNums3 = new ArrayList<Double>();
		List<? super Integer> dst = new ArrayList<Number>();
	}

	private static long sum(List<? extends Number> numbers) {
		long summation = 0;
		for(Number number : numbers) {
			summation += number.longValue();
		}
		return summation;
	}

	public void pushAll(Iterable<? extends Collection<String>> src) {
		for (Collection<?> e: src) 
			System.out.println(e);
	}
	public void popAll(Collection<? super List<String>> dst) {
		
	}

}
