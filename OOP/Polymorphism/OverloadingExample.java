package Polymorphism;

public class OverloadingExample {

	public static void main(String[] args) {	
		
		OverloadingExample obj = new OverloadingExample();
		obj.add(5, 5);//for 2 arguments you call method with 2
		obj.add(7, 7, 7);//here you call method with 3 arguments
		
		//obj.addition(10,20,30,40);//for varargs

	}
	
	public void add(int a, int b) {
		
	}
	
	public void add(int a, int b, int c) {
				
	}
	
	/*public int add(int a, int b) {
		
	}*/
	
	//varargs	
	//public void addition(int... a) {
	//	int[] var = a;
	//}

}
