/**
 * 
 */
package com.naren.others;

import java.io.Serializable;

/**
 * @author Narender Singh
 *
 */
public class User implements Serializable{

	/**
	 * 
	 */
	//private static final long serialVersionUID = 10L;
	private String name;
	private int age;
	private String email;
	//private String hello;
	/**
	 * 
	 */
	public User() {
		 
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [name=" + name + "]";
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
