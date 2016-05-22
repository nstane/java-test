/**
 * 
 */
package com.naren.test.main;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.naren.mainmethod.MainMethod;

/**
 * @author nstanwar
 *
 */
public class TestMainMethod {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.naren.mainmethod.MainMethod#MainMethod()}.
	 */
	@Test
	public final void testMainMethod() {
		

	}

	/**
	 * Test method for {@link com.naren.mainmethod.MainMethod#main(java.lang.String[])}.
	 */
	@Test
	public final void testMain() {
		String [] str= {"My Name","Naredner"};
		MainMethod.main(str);
	}

}
