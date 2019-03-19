/**
 * 
 */
package com.naren.java8;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
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

		Predicate<String> predicate = (env) -> {
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
}
