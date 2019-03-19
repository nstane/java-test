package com.naren.java8;

import java.util.function.Consumer;
import java.util.function.Supplier;

import com.naren.others.Person;

public class SuplierConsumer {

	public static void main(String[] args) {
		Supplier<Person> supplier = () -> {
			return new Person("Naren", "Singh", 34, "Male");
		};
		Person person = supplier.get();
		person.setAge(45);
		System.out.println("Updated detail : " + person.toString());
		System.out.println("Orignal Detail : " + supplier.get());
	
		Consumer<String> consumer1 = (test) -> {
          System.out.println(test);
        };
        consumer1.accept("Test consumer");
	}
}
