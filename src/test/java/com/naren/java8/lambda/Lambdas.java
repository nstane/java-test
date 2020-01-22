package com.naren.java8.lambda;

import static org.junit.Assert.assertEquals;

import java.util.function.Function;
import java.util.stream.Stream;

public class Lambdas {

	public static void main(String[] args) {
		Validator nullValidator = (obj)-> obj != null;
		Validator emptyValidator = (obj)-> nullValidator.validate(obj) && !obj.equals("");
		Stream.of("").forEach(System.out::println);
		
		assertEquals(true, nullValidator.validate(""));
		assertEquals(true, emptyValidator.validate("d"));
	}
}


@FunctionalInterface
interface Validator{
	boolean validate(Object obj);
}
