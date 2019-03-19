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

import com.naren.others.Person;

/**
 * @author Narender Singh
 *
 */
public class Java8Collection {
	private static List<Integer> list = new ArrayList<Integer>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = -2939880373417477170L;

		{
			add(1);
			add(2);
			add(3);
			add(10);
			add(5);
			add(8);
			add(5);
		}
	};
	private static List<Person> persons = new LinkedList<Person>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1249367500359764048L;

		{
			add(new Person("Naren", "Singh", 28, "Male"));
			add(new Person("Amita", "P", 29, "Female"));
			add(new Person("Gajju", "N", 30, "Male"));
		}
	};
	private static LinkedHashMap<String, Person> personsMap = new LinkedHashMap<String, Person>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = -1107855095661995258L;

		{
			put("1", new Person("Naren", "Singh", 28, "Male"));
			put("2", new Person("Amita", "P", 29, "Female"));
			put("3", new Person("Gajju", "N", 30, "Male"));
		}
	};
	private static Map<String, String> map = new HashMap<String, String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = -7156176687430418014L;

		{
			put("Hello", "Naren");
			put("Bye", "Naren1");
		}
	};
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
		// sum of element
		Integer sum = (int) list.stream().map(Integer::intValue).mapToInt(Integer::intValue).sum();
		// find average
		OptionalDouble ave = list.stream().map(Integer::intValue).mapToInt(Integer::intValue).average();
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
		Comparator<Person> pComp = (e1, e2) -> {
			return e1.getfName().compareTo(e2.getfName());
		};
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
		persons.stream().filter(p -> p.getAge() >= 29).forEach(p -> System.out.println(p));
		OptionalDouble averageAge = persons.stream().filter(p -> p.getAge() >= 29).mapToInt(p -> p.getAge()).average();
		System.out.println(averageAge.isPresent() ? averageAge.getAsDouble() : "0");
	}

	public static LinkedHashMap<String, Person> getPersonsMap() {
		return personsMap;
	}

	public static void setPersonsMap(LinkedHashMap<String, Person> personsMap) {
		Java8Collection.personsMap = personsMap;
	}
}
