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

	/**
	 * 
	 */
	public BaseInheratance() {
		this.get();
		//this("Base");
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
	
	public void throwExcetion() throws SQLException, Exception{
		
	}
	
	public void print(int integer){
		System.out.println("Print int "+integer);
	}

}
