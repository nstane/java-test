/**
 * 
 */
package com.naren.others;

/**
 * @author Narender Singh
 *
 */
public class StackOverFlow {

	/**
	 * 
	 */
	public StackOverFlow() {
		 
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 
		call();
	}
	//If you have verified that the recursion is implemented correctly, 
	//you can increase the stack’s size, in order to allow a larger number of invocations. 
	//Depending on the Java Virtual Machine (JVM) installed, the default thread stack size may equal to either 512KB, or 1MB. You can increase the thread stack size using the -Xss flag. This flag can be specified either via the project’s configuration, or via the command line. 
	//The format of the -Xss argument is: -Xss[g|G|m|M|k|K]
	//http://stackoverflow.com/questions/214741/what-is-a-stackoverflowerror
	static void call(){
		//uncomment call() to reproduce stackover flow
		//for(int i = 0 ;i<10000000;i++){
			//new String();
			call();
		//}
	}
}
