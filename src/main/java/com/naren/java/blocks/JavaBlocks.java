package com.naren.java.blocks;

public class JavaBlocks extends BaseJavaBlock {
	
	public JavaBlocks() {
		System.out.println("Constructors...");
	}
	
	static {
		System.out.println("Static block");
	}
	{
		System.out.println("init block");
	}
	public static void main(String[] args) {
		System.out.println("static main");
		JavaBlocks javaBlocks = new JavaBlocks();
		javaBlocks.callMe();
	}
	private void callMe() {
		System.out.println("instance method");
		
	}

}
