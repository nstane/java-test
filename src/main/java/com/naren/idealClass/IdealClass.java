/*
 * Class : IdealClass
 * Copyright (c) 1994, 2013, NST and/or its affiliates. All rights reserved.
 * NST PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.naren.idealClass;

import java.util.logging.Logger;

/**
 * This class was created for Show Ideal Class Model
 * @author nstanwar
 * @version 1.0
 * @see java.lang.String
 * @since Test 
 */
public class IdealClass {

	/*
	 * Class Implementation comments
	 */
	
	/**static logger field
	 */
	public static final Logger LOGGER = null; // Logger 
	/**
	 * instance test field 
	 */
	private Boolean test; //test field

	/**
	 * construstor
	 */
	public IdealClass() {

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		@SuppressWarnings("unused")
		String a = "";

		//Methods are separated by a blank line
		
		//Class don't exceed 2000 lines 
		
		//Line could not exceed 80 char 
		
		//Trailing comments return xyz;/*xyz contains xxx val */
		
		//Each line one statement
		
		//Note: if statements always use braces {}
		
		/*if (condition) { statements;
		}
		 */

		//Single line space
		/*
		 * One blank line should always be used in the following circumstances:
			• Between methods
			• Between the local variables in a method and its first statement
			• Before a block (see section 5.1.1) or single-line (see section 5.1.2) comment
			• Between logical sections inside a method to improve readability
		 */
		
		//Two blank lines should always be used in the following circumstances:
		/*	• Between sections of a source file
			• Between class and interface definitions
		 */
		
		//Blank Space
		/*
		 * A keyword followed by a parenthesis should be separated by a space
		 * A blank space should appear after commas in argument lists
		 * All binary operators except . should be separated from their operands by spaces.
		 * eg a += c + d;
           a = (a + b) / (c * d);
           while (d++ = s++) {
               n++;
           }
           prints("size is " + foo + "\n");
           
           Casts should be followed by a blank
           
           The expressions in a for statement should be separated by blank spaces
		 */
		
		//Parntheses
		
		//if ((a == b) && (c == d)) // RIGHT
	}

	/**
	 * @return the test
	 */
	public Boolean getTest() {
		return test;
	}

	/**
	 * @param test the test to set
	 */
	public void setTest(Boolean test) {
		this.test = test;
	}


}
