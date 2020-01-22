/**
 * 
 */
package com.naren.test.inheritancepolimorphism;

import java.sql.SQLException;

/**
 * @author nstanwar
 *
 */
public class Inheritance extends BaseInheratance{

	static{
		System.out.println("child static");
	}
	
	/**
	 * 
	 */
	public Inheritance() {
		System.out.println("child constructor");
	}
	public Inheritance(String msg) {
		System.out.println("child constructor"+msg);
	}
	{
		System.out.println("Child init");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 
		//Can't cast parent to child will raise class cast exception on runtime.
		Inheritance inheritance = (Inheritance) new BaseInheratance();
		inheritance.print("");
		//if we pass null will show ambiguous error without integer method it will print null if we pass null
		//The method print(String) is ambiguous for the type Inheritance
		//((Inheritance) inheritance).print(new Object());
		//inheritance.call();
		//BaseInheratance base = new BaseInheratance();
	}
	
	public void get(){
		
		System.out.println("CHild get");
		
	}
	
	public void print(String str){
		System.out.println("print str"+str);
	}
	public Object print(Object object){
		System.out.println("print object"+object);
		return object;
	}
	//@Override
	public void print(Integer integer){
		System.out.println("print integer"+integer);
		this.get();
	}
	
	public void call(){
		System.out.println("cjhild call");
	}
	
	//Parent will have same of higher exception 
	public void throwExcetion() throws SQLException{
		
	}
	
	@Override
	public Long getInt()
	{
		return (long) 0;
	}
}
