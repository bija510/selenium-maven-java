package aCoreJava;

public class IfandElse {

	public static void main(String[] args) {		
		//operators:- ==, !=, >, <, >=, <=
		
		String a = "apple";
		String b = "ball";
		String c = "cat";
		String d = "apple";
		int e = 7;
		int f = 10;
		int g = 7;
		
		if(e != g) {               // != --> not equal to
			System.out.println("apple");
		
		        }
		else if(a.contains("ple")) {
		      System.out.println("ball");
		
		        }
		else if(f < g) {
		      System.out.println("cat");
		        }
	    else{		
			System.out.println("Dog");
		
		      }
		
	}

}
