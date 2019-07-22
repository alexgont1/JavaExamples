package Demo2;

//All rules here work for variables inside class too

public class Test {//accessible everywhere, BUT if it's
	//another package you must import this package class in the
	//beginning of package where you need it, like:
	//	import rough.Test; //it goes after name of new package 
	
	class demo {//=default class,accessible only in this package
		
	}
	
	protected class demo2 {
		//accessible here and outside this package only using
		//inheritance - Example in TC2
		//means: 1 class object inherit 2nd class properties
		//Example1: A (child) wants properties of B (parent):
		//public class A extends B
		//
	}
	
	private class pri {
		//access only inside this class
	}

	//Examples
	public static void main(String[] args) {

	//	ClassB obj3 = new ClassB();//No access!!! 
		//it's default in another package
		

	}

}
