package com.naren.others;

public class FinalizerCall {

	public FinalizerCall() {
		 
	}

	public static void main(String[] args) {
		 
		System.gc();
		Runtime.getRuntime().gc();
		System.runFinalization();
		{
			int a = 0;
			System.out.println(a);
		}
		{
			int a = 23;
			System.out.println(a);
		}  
	}
	@Override
	protected void finalize() throws Throwable{
		System.out.println("finalize");
	}

}
