package com.naren.thread;

class BrokenBankAccount {
	private int balance;

	int getBalance() {
		return balance;
	}

	void setBalance(int x) 
			throws IllegalStateException {
		balance = x;
		if (balance < 0) {
			throw new IllegalStateException("Negative Balance");
		}
	}

	synchronized void  deposit(int x) {
		int b = getBalance();
		System.out.println("Current balance : "+b+ " deposit : "+x);
		setBalance(b + x);
		int b1 = getBalance();
		System.out.println("Now Current balance : "+b1);
	}

	synchronized void withdraw(int x) {
		int b = getBalance();
		System.out.println("Current balance : "+b+ " widthraw : "+x);
		setBalance(b - x);
		int b1 = getBalance();
		System.out.println("Current balance : "+b1);
	}

	public static void main(String ...a) {
		BrokenBankAccount b = new BrokenBankAccount();


		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				b.deposit(5);

			}

		});
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				b.withdraw(5);

			}

		});

		t1.start();
		t2.start();
		for(int i=0;i<10;i++){
			new Thread(()->{
				print(1);
			}).start();
			new Thread(()->{
				print(2);
			}).start();
			new Thread(()->{
				print(3);
				System.out.println(" ----------------");
			}).start();
			//System.out.println(" ----------------");
		}
		for(int i=0;i<10;i++){
			new Thread(()->{
				b.print("One");
			}).start();
			new Thread(()->{
				b.print("Two");
			}).start();
			new Thread(()->{
				b.print("Three");
				System.out.println(" ----------------");
			}).start();
			//System.out.println("End ----------------");
		}
	}
	private static void print(int n){
		System.out.println(n);
	}
	private synchronized void print(String n){
		System.out.println(n);
	}
}