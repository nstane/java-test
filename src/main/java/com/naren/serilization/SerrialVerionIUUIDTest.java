/**
 * 
 */
package com.naren.serilization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.naren.others.User;

/**
 * 1.The critical things that the Java Object Serialization specification can manage automatically are:
 * Adding new fields to a class or remove field
 * Changing the fields from static to nonstatic or nonstatic to  static 
 * Changing the fields from transient to nontransient or nontransient to transient
 * BELOW exception will be thrown when any changes done after serilize object and when we do try to deserilize.
 * java.io.InvalidClassException: com.naren.others.User; local class incompatible: stream classdesc serialVersionUID = -832235717272298865, local class serialVersionUID = 5274002272192372188
 * 
 * So Always add generated SerialversionUID to avoid above exception
 * 
 * 2. Same exception will be thrown if SerialversionUID gets changes.
 * @author nstanwar
 *
 */
public class SerrialVerionIUUIDTest {

	/* Suppose you have serialized your objects into a File and keep using after de-serialization.
       After 2 years, you have changed your original source code and added/deleted some methods, attributes etc
       and now serialized your objects again but keeping the older stored/serialized objects as it is with client. 
       Now if your old serialized objects need to de-serialize with new new code base, it won't work. 
       It will say java.io.InvalidClassException. I mean Version/SerialVersionUID is modified.
       So what affects the value of serialVersionUID and what does not?
			What affects SerialVersionUID change?
			1.    Non-default Constructors
			2.    Addition/Deletion of non-private static or instance methods as well as their access modifiers
			3.    Addition/Deletion of static/instance attributes as well as their access modifiers
			4.    The interfaces implemented by the class
			
			What does not affect SerialVersionUID?
			1.    Default Constructor
			2.    Addition of private static or instance methods
			3.    The class extended by the class to be serialized
	 */
	/**
	 * 
	 */
	public SerrialVerionIUUIDTest() {

	}

	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {

		writeObject();

		readObject();

		//System.out.println("Deserilization......");
		//Thread.sleep(3000);

		//		int a= 10;
		//		a = a >> 2;
		//		System.out.println(a);
		//		a = a  << 2;
		//		System.out.println(a);
	}

	@SuppressWarnings("unused")
	private static void writeObject(){
		User user = new User();
		user.setName("Narenderwe");
		try(
				FileOutputStream fout =new FileOutputStream(new File("user"));
				ObjectOutputStream out = new ObjectOutputStream(fout);
				){
			out.writeObject(user);
		}catch(final Exception e){
			e.printStackTrace();
		}
	}
	private static void readObject(){
		try(
				FileInputStream fin =new FileInputStream(new File("user"));
				ObjectInputStream in = new ObjectInputStream(fin);
				){
			User user = (User) in.readObject();
			System.out.println(user);
		}catch(final Exception e){
			e.printStackTrace();
		}
	}

}

class Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;

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

}
