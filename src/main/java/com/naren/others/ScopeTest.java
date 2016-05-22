package com.naren.others;

public class ScopeTest {

	public ScopeTest() {
		 
	}
	public static void main(String[] args){ 
		Scope scope = new Scope(); 
		scope.method1(5); 
		} 

}
class Scope { 
	public void method1(final int arg) { // here arg is being a parameter variable 
		@SuppressWarnings("unused")
		Runnable run = new Runnable() { 
			public void run() { 
				System.out.println("variable arg from anonymous class scope "+arg); 
				// here we are accessing variable arg in anonymous class 
			} 
		};
		System.out.println("variable arg from method scope "+arg); 
	//	arg = 10; // here arg becomes local variable 
	} 
} 