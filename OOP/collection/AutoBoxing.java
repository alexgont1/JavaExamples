package collection;

public class AutoBoxing {

	public static void main(String[] args) {
		
		int var = 10;
		Integer obj = new Integer(var);//wrapping = AutoBoxing
		//automatically in collections
		
		System.out.println(obj);
		
		int i = obj;//unwrapping = AutoUnBoxing
		//automatically in collections
		
		System.out.println(i);
		
			/*public class Test {
			public static void main(String[] args)
			{
			int i=45;
			Integer wrapper = new Integer (i);//Integer - wrapper class to wrap int
			System.out.println(wrapper);
			int unwrapped = wrapper.intValue();
			System.out.println(unwrapped);
			}}*/

	}

}
