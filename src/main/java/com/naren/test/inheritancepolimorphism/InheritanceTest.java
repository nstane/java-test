package com.naren.test.inheritancepolimorphism;

public class InheritanceTest {

	public static void main(String... a) {
		inheritanceTest();
	}

	/**
	 * 
	 */
	private static void inheritanceTest() {
		A aa = new A();
		A b = new B();
		A c = new C();
		if (b instanceof B) {
			System.out.println("instance of b");
		}
		aa.run();
		b.run();
		c.run();
		AA aaa = new AA() {
			@Override
			void call() {
				System.out.println("fdfdf");
			}
		};
		{
			aaa.call();
		}
		// down casting
		AAA aAA = new BB();
		// BB bb = (BB) new AAA();
		// bb.call();
		if (aAA instanceof AAA) {
			AAA aA = (AAA) aAA;
			aA.call();
		}
		int u=0;
		{{
			u =9;
			System.out.println(u);
		}}
	}
}

class A {
	void run() {
		System.out.println("A");
	}
}

class B extends A {
	void run() {
		System.out.println("B");
	}
}

class C extends B {
	void run() {
		System.out.println("C");
	}
}

abstract class AA {
	void call() {

	}
}

class AAA {
	void call() {
		System.out.println("A");
	}
}

class BB extends AAA {
	void call() {
		System.out.println("B");
	}
}

class CC extends AAA {
	void call() {
		System.out.println("c");
	}
}