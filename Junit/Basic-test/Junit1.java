package com.auto.Junit;

import org.junit.Test;

public class Junit1 {
	
	@Test//Add JUnit to build path
	//To start it - right click - Run as JUnit test
	public void testNavigation() {
		
		System.out.println("Open website");
	}
	
	@Test
	public void testLogin() {
		
		System.out.println("Login test");
	}

}
