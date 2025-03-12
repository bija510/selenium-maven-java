package com.core.java;

public class Modifiers {

	/**
	 * we have 2 diffrent modifiers
	 * Access modifiers (public, private, protected, default)
	 * Non access modifiers(static and final)
	 *
	 */
	
	/**
	 * Modifier   | Scope           | Accessibility
	 * -------------------------------------------
	 * default    | Package-Private | Accessible only within the same package
	 * public     | Global          | Accessible from anywhere
	 * protected  | Inherited       | Accessible within the same package and by subclasses
	 * private    | Restricted      | Accessible only within the same class
	 */
	
	/**
	 * Keyword      | Usage                   | Behavior
	 * ---------------------------------------------------------------
	 * static       | Class-level             | Belongs to the class, no need to create instances
	 * final        | Variable, Method, Class | Prevents modification (constant, method override, inheritance)
	 * static final | Constant                | Shared across all instances, cannot be modified
	 */
	
	public String aFor = "Ant"; //Can access anywhere
	String bFor = "Ball";
	private String cFor = "Cat"; // Can access only within the class
	protected String dFor = "Dog"; // Can access only in same package and subclass
	
	final String eFor = "Egg"; // Cannot modified it
	static String fFor = "Fish"; // Can access anywhere without using "new" keyword
	
	
	public static void main(String[] args) {
		

	}

}
