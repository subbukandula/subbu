package com.subbu;

public class ClasstoTest {
	
	UsesResourceBundle userResource = new UsesResourceBundle();
	
	public void methodToTest() {
		int value = UsesResourceBundle.handleInt();
		System.out.println("int "+value);
		String value1 = UsesResourceBundle.handleString();
		System.out.println("String "+value1);
		UsesResourceBundle.handleVoid();
		int value2 = userResource.handleNonStaticInt();
		System.out.println("intNonStatic "+value2);
		String value3 = userResource.handleNonStaticString();
		System.out.println("intNonStatic "+value3);
		userResource.handleNonStaticVoid();
	}
}
