/**
 * 
 */
package com.naren.base;

/**
 * @author nstanwar
 *
 */
public class ChildA  extends Base{

	/**
	 * 
	 */
	public ChildA() {
		 
	}
	
	protected void defaultcall(){
		
	}

	@Override
	protected void absCall() {
		 
		
	}

	@Override
	public void otherCall() {
		 
		
	}
	
	class StaticInnerClass{
		//non static inner class cant have static method or member
		void staticCall(){
			
		}
	}

}
