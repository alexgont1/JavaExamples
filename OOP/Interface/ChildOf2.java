package Interface;

//child can implement 2 interfaces from parents with the same
//method names
//public class ChildOf2 implements Parent1, Parent2 {

//OR even more complicated-extends always 1st then implements:
public class ChildOf2 extends Parent3 implements Parent1, Parent2 {

	//if delete below - Parent3 show() will work
	@Override
	public void show() {
		
		System.out.println("Child show");
		
	}
	
	public static void main(String[] args) {
		
		ChildOf2 c = new ChildOf2();
		c.show();
		
	}

}
