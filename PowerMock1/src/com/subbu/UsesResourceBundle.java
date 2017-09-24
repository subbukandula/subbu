package com.subbu;

public class UsesResourceBundle {

	public static int handleInt() {
		System.out.println("In Handle Int");
		return 1;
	}
	
	public static String handleString() {
		System.out.println("In Handle Int");
		return "String";
	}
	
	public static void handleVoid() {
		System.out.println("Nothing to do");
	}
	
	public int handleNonStaticInt() {
		System.out.println("In Handle Int");
		return 1;
	}
	
	public String handleNonStaticString() {
		System.out.println("In Handle Int");
		return "String";
	}
	
	public void handleNonStaticVoid() {
		System.out.println("Nothing to do");
	}
	
}