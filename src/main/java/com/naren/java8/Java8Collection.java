/**
 * 
 */
package com.naren.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.naren.others.Person;

/**
 * @author Narender Singh
 *
 */
public class Java8Collection {
	private static List<Integer> list = Arrays.asList(1,2,5,9,3);
	private static List<Person> persons = Arrays.asList(new Person("Naren", "Singh", 28, "Male"),
			new Person("Amita", "P", 29, "Female"),
            new Person("Amita", "P1", 18, "Female"),
			new Person("Gajju", "N", 30, "Male"));
	private static Map<String, Person> personsMap = getPersonMap();
	private static Map<String, String> map = getStringMap();
	private static List<String> myList = Arrays.asList("area", "block", "building", "city", "country");

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		listTest();
		mapTest();

	}

	private static void listTest() {
		// list and set
		print(persons);
		// count element
		Integer count = (int) list.stream().map(Integer::intValue).count();
		Integer multiply = IntStream.rangeClosed(1,5).reduce(1,(a,b)-> a*b); //multiply = 120;
		Integer sumOf = IntStream.rangeClosed(1,5).reduce(0,(a,b)-> a+b); //sum = 15;
		String reduceStringArrays = myList.stream().reduce("start",(a,b)-> a+","+b);
		String reduceStringArrays2 = myList.stream().collect(Collectors.joining(","));

		System.out.println("Mux of 1..5 = " + multiply);
		System.out.println("Sum of 1..5 = " + sumOf);
		System.out.println("reduceStringArrays : "+reduceStringArrays+" other joining : "+ reduceStringArrays2);

		// sum of element
		Integer sum = (int) list.stream().mapToInt(Integer::intValue).sum();

		// find average
		OptionalDouble ave = list.stream().mapToInt(Integer::intValue).average();
		System.out.println("Sum : " + sum + " Count : " + count + " ave " + ave);

		// shorting
		Comparator<Integer> normal = Integer::compare;
		Comparator<Integer> reversed = normal.reversed();
		Collections.sort(list, normal);
		System.out.println(list);

		// short reverse
		Collections.sort(list, reversed);
		System.out.println(list);

		// short list
		myList.stream().filter(s -> s.startsWith("c")).map(String::toUpperCase).sorted().forEach(System.out::println);

		//compare multiple property
		Comparator<Person> pComp = Comparator.comparing(Person::getfName).thenComparingInt(Person::getAge).thenComparing(Person::getGender);

		Collections.sort(persons, pComp);
		System.out.println("Sorted persons : " + persons);
		Arrays.sort("Narender singh".replace("\\s", "").toCharArray());
		// personsMap.entrySet().stream().collect(Collectors.groupingBy(e -> e.))
	}

	private static void mapTest() {
		// map filter values
		map.values().stream().filter(e -> e.equals("Naren")).forEach(e -> {
			System.out.println("PP" + e);
		});
		// join all map values with commma seprated
		String joined = map.values().stream().map(Object::toString).collect(Collectors.joining(", "));
		System.out.println(joined);

		//
		Map<String, List<String>> namesByGender = persons.stream().collect(
				Collectors.groupingBy(Person::getGender, Collectors.mapping(Person::getfName, Collectors.toList())));
		System.out.println(namesByGender);
		
		Map<String, Integer> totalAgeByGender = persons.stream().collect(
				Collectors.groupingBy(Person::getGender, Collectors.reducing(0, Person::getAge, Integer::sum)));
		System.out.println(totalAgeByGender);

		Map<String, Double> averageAgeByGender = persons.stream()
				.collect(Collectors.groupingBy(Person::getGender, Collectors.averagingInt(Person::getAge)));
		System.out.println(averageAgeByGender);

	}

	public static void print(List<Person> persons) {
		persons.stream().filter(p -> p.getAge() >= 29).forEach(System.out::println);
		OptionalDouble averageAge = persons.stream().filter(p -> p.getAge() >= 29).mapToInt(Person::getAge).average();
		System.out.println(averageAge.isPresent() ? averageAge.getAsDouble() : "0");
	}

	public static void setPersonsMap(LinkedHashMap<String, Person> personsMap) {
		Java8Collection.personsMap = personsMap;
	}

	public static Map<String, Person> getPersonMap()
	{
		Map<String, Person> personMap = new LinkedHashMap<String, Person>();
		personMap.put("1", new Person("Naren", "Singh", 28, "Male"));
		personMap.put("2", new Person("Amita", "Jain", 29, "Female"));
        personMap.put("3", new Person("Neeta", "Sain", 29, "Female"));
        personMap.put("4", new Person("Joe", "D", 29, "Male"));
		personMap.put("5", new Person("Gajju", "N", 30, "Male"));
        personMap.put("5", new Person("Gajju", "N", 30, "Female"));
		return personMap;
	}

	private static Map<String, String> getStringMap()
	{
		Map<String, String> stringMap = new HashMap<String, String>();
		stringMap.put("Hello", "Naren");
		stringMap.put("Bye", "Naren1");
		return stringMap;
	}
}
