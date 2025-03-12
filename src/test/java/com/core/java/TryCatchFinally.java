package com.core.java;

public class TryCatchFinally {

	public static void main(String[] args) {
		
//		int[] num = {1, 2, 3};
//	      System.out.println(num[10]);
//		
//		System.out.println("apple");
	      
		try {
			int[] num1 = {1, 2, 3};
		      System.out.println(num1[10]); 
		}
	
		catch(Exception e){
			System.out.println(e);
		}

		finally {
			System.out.println("this will always print");
		}

	}

}
