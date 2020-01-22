/**
 * 
 */
package com.naren.test.inheritancepolimorphism;

import java.sql.SQLException;

/**
 * @author nstanwar
 *
 */
public class BaseInheratance {

	static{
		System.out.println("Base static");
	}
	
	{
		System.out.println("base init");
	}
	/**
	 * 
	 */
	public BaseInheratance() {
		//this.get();
		this("Base");
		System.out.println("Base  cons ");
	}
	
	public BaseInheratance(String msg) {
		 
		//this.get();
		System.out.println("Base  cons"+msg);
	}
	
	public void get(){
		
		System.out.println("Base get");
	}
	
	protected void call(){
		System.out.println("base call");
	}
	
	public void throwExcetion() throws SQLException{
		
	}
	
	public void print(Integer integer){
		System.out.println("Print int "+integer);
	}

	protected Long getInt()
	{
		return 0l;
	}
}
