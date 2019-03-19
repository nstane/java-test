/**
 * 
 */
package com.naren.collection;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author nstanwar
 *
 */
public class ConcurrentHashMapTest {

	/**
	 * 
	 */
	public ConcurrentHashMapTest() {
		 
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 
		Map<String,String> map = new ConcurrentHashMap<>();
		map.put("A", "b");
		map.put("A2", "b2");
		map.put("A3", "b3");
		map.put("A4", "b4");
		for(String s:map.keySet()){
			System.out.println(s+":"+map.get(s));
			map.put("A5","B5");
		}
		
		Set<Employee> employeeSet = new HashSet<Employee>();
		employeeSet.add(new Employee(123,"Narender",23));
		employeeSet.add(new Employee(123,"Narender",23));
		System.out.println(employeeSet.size());
	}

}

class Employee{
	
	private long id;
	private String name;
	private int age;
	
	public Employee(){
		
	}
	
	public Employee(long id,String name,int age){
		this.id = id;
		this.name = name;
		this.age = age;
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Employee)) {
			return false;
		}
		Employee other = (Employee) obj;
		if (age != other.age) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}
}
