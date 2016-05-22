/**
 * 
 */
package com.naren.finalargument;

/**
 * @author nstanwar
 *
 */
public class FinalArgument {

	/**
	 * 
	 */
	public FinalArgument() {
		 
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String msg = "Hello from Adele.";
		Person p = new Person("Narender");
		Person returnP = new FinalArgument().callME(p);
		System.out.println(p == returnP);
		System.out.println(p);
		new FinalArgument().callME(msg);
		System.out.println(msg);
	}
	/**
	 * We force compile time that parameter never change or reassign 
	 * @param person
	 * @return
	 */
	private Person callME(final Person person){
		person.setName("Adele");
		System.out.println(person);
		
		//callMsg = "Hello from Narender.";
		return person;
	}
	private String callME(String callMsg){
		System.out.println(callMsg);
		
		callMsg = "Hello from Narender.";
		return callMsg;
	}

}
class Person{
	
	private String name;

	
	public Person(String name) {
		super();
		this.name = name;
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
		return "Person [name=" + name + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		if (!(obj instanceof Person)) {
			return false;
		}
		Person other = (Person) obj;
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
