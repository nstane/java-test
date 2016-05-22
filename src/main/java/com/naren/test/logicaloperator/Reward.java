/**
 * 
 */
package com.naren.test.logicaloperator;

/**
 * @author nstanwar
 *
 */
public class Reward {

	public boolean Expired_in_Influitive__c ;
	public boolean Expired__c;
	/**
	 * 
	 */
	public Reward(boolean Expired__c,boolean Expired_in_Influitive__c) {
		 
		this.Expired_in_Influitive__c= Expired_in_Influitive__c;
		this.Expired__c = Expired__c;
	}

}
