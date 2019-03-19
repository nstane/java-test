package com.naren.java8;

public class DefaultStaticMathods implements A, B {

	public static void main(String[] args) {
		new DefaultStaticMathods().call();
	}

	@Override
	public void call() {
		A.super.call();
		B.super.call();
		A.staticCall();
		B.staticCall();
	}

	@Override
	public void run() {

	}
}

@FunctionalInterface
interface A {
	default void call() {
		System.out.println("interface A call");
	}

	static void staticCall() {
		System.out.println("interface A staticCall");
	}

	void run();
}

interface B {
	default void call() {
		System.out.println("interface B call");
	}

	static void staticCall() {
		System.out.println("interface B staticCall");
	}
}
