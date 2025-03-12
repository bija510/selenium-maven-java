package com.core.java;

public class EqualsType {

	public static void main(String[] args) {
		String a = "aPPle";
		String b = "banana";
		
		String x ="ApplE";
		String y = "BANANA";
		
		if ( a.equalsIgnoreCase(x) ) {
			System.out.println("this is true");
		}else {
			System.out.println("this is false");
		}

	}

}
