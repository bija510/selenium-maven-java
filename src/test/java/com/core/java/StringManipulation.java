package com.core.java;

public class StringManipulation {

	public static void main(java.lang.String[] args) {
		
		String a = "apple is";
		String b = "";
		                   
		System.out.println(a.replace("a", "z"));
		
		System.out.println(a.length());
		
		System.out.println(a.charAt(4));
		
		System.out.println(a.concat(" Red"));
		
		System.out.println(a.contains("y"));
		
		System.out.println(a.substring(6));
		
		System.out.println(a.substring(0, 5));
		
		System.out.println(b.isEmpty());
		
		System.out.println(a.endsWith("e is"));
				
		String aFor = "apple";
		String bFor = "is";
		String cFor = "Red";
		
		System.out.println(aFor + " "+ bFor +" "+cFor);
		System.out.println("apple is red");
	}

	}


