/**
 * 
 */
package com.naren.test.inheritancepolimorphism;

/**
 * @author nstanwar
 *
 */
public class Inheritance extends BaseInheratance{

	/**
	 * 
	 */
	public Inheritance() {
		System.out.println("child constructor");
	}
	public Inheritance(String msg) {
		System.out.println("child constructor"+msg);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 
		BaseInheratance inheritance = new Inheritance();
		//if we pass null will show ambiguous error without integer method it will print null if we pass null
		//The method print(String) is ambiguous for the type Inheritance
		((Inheritance) inheritance).print(123);
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
	
	public void throwExcetion() throws Exception{
		
	}
}
