
public class LearnFunctions {
	
	public static void print() {
		System.out.println("Learning Functions");
	}
	
	public static int a = 20;
	public static int b = 30; 
	public static int addNumbers() {
		int c = a + b;
		return c;
	}

	public static void main(String[] args) {

		print();
		System.out.println(a+"+"+b+"="+(addNumbers()));
	}

}
