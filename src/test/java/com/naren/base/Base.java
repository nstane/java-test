package com.naren.base;

public abstract class Base {

	
	public Base() {
		 
	}
	protected void call() throws RuntimeException, Exception{
	}
	
	protected void defaultcall(){
		//method inner class can't be static 
		class MethodInner{
			void innerCall(){
				System.out.println("Inner class");
			}
		}
		new MethodInner().innerCall();
	}
	
	protected abstract void absCall();
	public abstract void otherCall();

}
