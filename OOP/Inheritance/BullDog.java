package Inheritance;

public class BullDog extends Dog {

	public static void main(String[] args) {
		BullDog obj = new BullDog();
		obj.sound(); //inherit from Dog and Animal too
	//It's a tree structure and this child class can
	//inherit from all previous classes in tree including Animal
	//it's MultiLevel Inheritance
		
	//BUT if subclass has own method with same name - it will
	//work 1st!!! and ignore parent method
	
	//!!!Java class can't inherit from 2 SUPER classes 
	}
	
	public void sound () {
		System.out.println("Whow!!!");
	}
	
}
