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
 * @author nstanwar
 *
 */
public class SerrialVerionIUUIDTest {

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
		 
		//writeObject();
		
		//System.out.println("Deserilization......");
		//Thread.sleep(3000);
		readObject();
//		int a= 10;
//		a = a >> 2;
//		System.out.println(a);
//		a = a  << 2;
//		System.out.println(a);
	}
	
	@SuppressWarnings("unused")
	private static void writeObject(){
		User user = new User();
		user.setName("Narender");
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
