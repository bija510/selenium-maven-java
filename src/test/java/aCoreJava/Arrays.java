package aCoreJava;

public class Arrays {

	public static void main(String[] args) {
	
		//one-dimensional Array
		int[] a = {1, 2, 3, 4, 5, 6}; //index start from 0			 
		int nnn = a[2];		 		
		System.out.println(nnn);
		
		String[] b = {"car", "van", "truck", "jeep" };		
		String bb = b[1];		
		System.out.println(bb);
		
		//Two-Dimensional Array
		int[][] e = { {1, 2, 3, 4, 5},{6, 7, 8, 9, 10} };//{{row0}, {row1 } r, c
        System.out.println(e[0][0]); // [R][C]
        System.out.println(e[0][1]);
        System.out.println(e[0][2]);
        System.out.println(e[0][3]);
        System.out.println(e[0][4]);
        
        System.out.println("===========================");
        
        System.out.println(e[1][0]);
        System.out.println(e[1][1]);
        System.out.println(e[1][2]);
        System.out.println(e[1][3]);
        System.out.println(e[1][4]);
        
        
	}

}
