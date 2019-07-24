
public class Test {

	public static void main(String[] args) {
		
		String name1 = "Alex";
		String name2 = "Alex";
		
		//here they are the same
		//because here we compare strings
		System.out.println(name1==name2);
		System.out.println(name1.equals(name2));
		
		//it's false because here we compare objects
		//they have different address references
		String name3 = new String("Alex");
		String name4 = new String("Alex");
		System.out.println(name3==name4);
		
		//BUT we can point 2 objects to 1 address to be equal
		//It's Singleton - new Class
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		//only 1 object was created
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1==s2);
		

	}

}
