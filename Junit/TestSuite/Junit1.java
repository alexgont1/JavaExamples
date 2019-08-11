package com.auto.Junit;

import java.util.Date;

import org.junit.Test;

public class Junit1 {
	
	@Test//Add JUnit to build path
	//To start it - right click - Run as JUnit test
	public void testNavigation() {
		
		Date d = new Date();
		System.out.println("Open website"+d);
	}
	
	@Test
	public void testLogin() {
		
		Date d = new Date();
		System.out.println("Login test"+d);
	}

}
