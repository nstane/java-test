/**
 * 
 */
package com.naren.java8;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Narender Singh Java 8 Feature with some easy examples
 */
public class Java8 {

	private static final String FILENAME = "tmp.text";
	// Stream.reduce is use to generate a single output for a stream like sum, avg,
	// min and max.

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		flatMapTest();
		System.out.println("hello");

		// Generate 5 random nmbers
		System.out.println(Stream.generate(Math::random).limit(5).skip(2).collect(Collectors.toList()));

		// Write data to file
		String data[] = { "1", "2", "3", "4", "5", "6" };
		try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(Paths.get(FILENAME)))) {
			Stream.of(data).forEach(writer::println);
		} catch (Exception e) {
			System.out.println(e);
		}

		// Read file
		try (Stream<String> stream = Files.lines(Paths.get(FILENAME))) {
			stream.forEach(System.out::println);
		} catch (Exception e) {
			System.out.println(e);
		}

		// Predicate

		Predicate<String> predicate = env -> {
			if ("prod".equals(env)) {
				return true;
			} else {
				return false;
			}
		};
		
		if(predicate.test("test")) {
			System.out.println("This is test environment");
		} else {
			System.out.println("This is prod environment");
		}
	}

	private static void flatMapTest()
	{
		List<String> list = new ArrayList<>();
		list.add("111");
		list.add("112");
		list.add("113");
		List<String> list2 = new ArrayList<>();
		list.add("1111");
		list.add("1122");
		list.add("1133");
		List<List<String>> lists = Arrays.asList(list, list2);
		System.out.println(lists.stream().flatMap(Collection::stream).collect(Collectors.toList()));
	}
}
