/**
 * 
 */
package com.naren.test.logicaloperator;

/**
 * @author nstanwar
 *
 */
public class JavaANDOR {

	/**
	 * 
	 */
	public JavaANDOR() {
		 
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 
		Reward reward =  new Reward(false,true);
		
		boolean flag = !((reward.Expired_in_Influitive__c == true || reward.Expired__c == true) && 
				( reward.Expired_in_Influitive__c == true && reward.Expired__c== true)) ;
		if(true && flag){
			System.out.println(flag);
		}else{
			System.out.println("some thing wrong");
		}
	}

}
