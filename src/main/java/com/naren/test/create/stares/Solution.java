/**
 * 
 */
package com.naren.test.create.stares;

import java.util.Scanner;

/**
 * @author nstanwar
 *
 */
public class Solution {

	/**
	 * 
	 */
	public Solution() {
		 
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 
		//reverseArray();
		//createStare();
		Book book = new MyBook("Narender's Authobiography","Narender Singh",250);
		book.display();
	}
	@SuppressWarnings({ "resource", "unused" })
	private static void reverseArray(){
		int N = new Scanner(System.in).nextInt();
        int arr[] = new int[N];
        for(int i=0; i < N; i++){
            arr[i] = new Scanner(System.in).nextInt();
        }
        for(int i =arr.length-1;i>=0;i--){
        	System.out.print(arr[i]+" ");
        }
	}
	@SuppressWarnings("unused")
	private static void createStare(){
		int count = 6;
		for(int k=0;k<=count;k++){
			String s ="";
			for(int i=0;i<count-k;i++){
				s+=" ";
			}
			for(int j = 0;j<=k;j++){
				s+="#";
			}
			System.out.println(s);
		}
	}

}
