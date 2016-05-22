/**
 * 
 */
package com.naren.others;

import java.io.Serializable;
import java.util.Comparator;
import java.util.function.Function;

/**
 * @author Narender Singh
 *
 */
public class Person implements Serializable {

	/**
	 * 
	 */
	enum Sex {
		MALE, FEMALE
	}

	private static final long serialVersionUID = -2450924260546503870L;
	private String fName;
	private String lName;
	private int age;
	private String gender;

	/**
	 * 
	 */
	public Person() {
		 
	}

	public Person(String fName, String lName, int age, String gender) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.age = age;
		this.gender = gender;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((fName == null) ? 0 : fName.hashCode());
		result = prime * result + ((lName == null) ? 0 : lName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (fName == null) {
			if (other.fName != null)
				return false;
		} else if (!fName.equals(other.fName))
			return false;
		if (lName == null) {
			if (other.lName != null)
				return false;
		} else if (!lName.equals(other.lName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [fName=" + fName + ", lName=" + lName + ", age=" + age + "]";
	}

	// Get rid of equals, compareTo and toString
	public final static Comparator<Person> COMPARATOR = Comparator.comparing(Person::getfName)
			.thenComparing(Person::getfName);
	public final static Function<Person, String> TO_STRING = p -> p.getfName() + " " + p.getfName();

}
