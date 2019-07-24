package collection;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetExample {

	public static void main(String[] args) {
		
		//HashSet set = new HashSet();
		//OR:
		HashSet<String> set = new HashSet<String>();
		set.add("Alex");
		set.add("Java");
		set.add("Selenium");
		set.add("Automation");
		set.add("Java");
		
		System.out.println(set);//unOrdered and no duplicates

		//print all set values:
		for(String var:set) {
			System.out.print(var+"\t");
		}
		System.out.println();
		
		//show some element:
		Iterator<String> itr = set.iterator();
		while(itr.hasNext()) {
			
			String var = itr.next();
			if(var.equals("Automation")) {
				System.out.println(var);
			}			
			
		}

	}

}
