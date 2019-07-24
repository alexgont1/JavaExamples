
public class Singleton {
	
	//it must be private
	private static Singleton instance = new Singleton();
	
	private Singleton() {
		System.out.println("Creating Object");
	}
	
	//it returns reference to the same object
	public static Singleton getInstance() {
		return instance;
	}
	

}
