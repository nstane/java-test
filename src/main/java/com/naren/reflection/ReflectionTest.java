package com.naren.reflection;

public class ReflectionTest 
{


	public static void main(String h[]) 
	{

		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()); 
		String k= Thread.currentThread().getStackTrace()[1].getMethodName(); 
		getme(k);
	}

	static void getme(String ko) 
	{

		Throwable t = new Throwable(); 
		StackTraceElement[] elements = t.getStackTrace();

		String calleeMethod = elements[0].getMethodName(); 
		String callerMethodName = elements[1].getMethodName(); 
		String callerClassName = elements[1].getClassName();

		System.out.println("CallerClassName=" + callerClassName + " , Caller method name: " + callerMethodName); 
		System.out.println("Callee method name: " + calleeMethod); 
	}
	
}